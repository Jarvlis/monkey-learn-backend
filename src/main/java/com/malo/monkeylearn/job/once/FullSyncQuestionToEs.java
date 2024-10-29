package com.malo.monkeylearn.job.once;

import com.malo.monkeylearn.esdao.PostEsDao;
import com.malo.monkeylearn.esdao.QuestionEsDao;
import com.malo.monkeylearn.model.dto.post.PostEsDTO;
import com.malo.monkeylearn.model.dto.question.QuestionEsDTO;
import com.malo.monkeylearn.model.entity.Post;
import com.malo.monkeylearn.model.entity.Question;
import com.malo.monkeylearn.service.PostService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;

import com.malo.monkeylearn.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import cn.hutool.core.collection.CollUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 全量同步题目到 es
 *
 * @author <a href="https://github.com/jarvlis">Jarvlis</a>
 
 */
// todo 取消注释开启任务
@Component
@Slf4j
public class FullSyncQuestionToEs implements CommandLineRunner {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionEsDao questionEsDao;

    @Override
    public void run(String... args) {
        List<Question> questionList = questionService.list();
        if (CollUtil.isEmpty(questionList)) {
            return;
        }
        List<QuestionEsDTO> questionEsDTOList = questionList.stream().map(QuestionEsDTO::objToDto).collect(Collectors.toList());
        final int pageSize = 500;
        int total = questionEsDTOList.size();
        log.info("FullSyncQuestionToEs start, total {}", total);
        for (int i = 0; i < total; i += pageSize) {
            int end = Math.min(i + pageSize, total);
            log.info("sync from {} to {}", i, end);
            questionEsDao.saveAll(questionEsDTOList.subList(i, end));
        }
        log.info("FullSyncQuestionToEs end, total {}", total);
    }
}
