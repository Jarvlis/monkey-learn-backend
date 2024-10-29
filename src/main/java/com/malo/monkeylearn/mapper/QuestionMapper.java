package com.malo.monkeylearn.mapper;

import com.malo.monkeylearn.model.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
* @author 十肆
* @description 针对表【question(题目)】的数据库操作Mapper
* @createDate 2024-10-06 16:07:29
* @Entity com.malo.monkeylearn.model.entity.Question
*/
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * 查询题目列表（包括已被删除的数据）
     * @param minUpdateTime
     * @return
     */
    @Select("select * from question where updateTime >= #{minUpdateTime}")
    List<Question> listQuestionWithDelete(Date minUpdateTime);
}




