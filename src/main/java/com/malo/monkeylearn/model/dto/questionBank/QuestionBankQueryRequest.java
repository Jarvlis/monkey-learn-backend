package com.malo.monkeylearn.model.dto.questionBank;

import com.malo.monkeylearn.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询题库请求
 *
 * @author <a href="https://github.com/jarvlis">Jarvlis</a>

 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionBankQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * id
     */
    private Long notId;

    /**
     * 搜索词
     */
    private String searchText;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片
     */
    private String picture;

    /**
     * 是否需要关联查询题目列表
     */
    private boolean needQueryQuestionList;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}