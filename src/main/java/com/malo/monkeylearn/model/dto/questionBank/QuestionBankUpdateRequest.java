package com.malo.monkeylearn.model.dto.questionBank;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新题库请求
 *
 * @author <a href="https://github.com/jarvlis">Jarvlis</a>

 */
@Data
public class QuestionBankUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

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

    private static final long serialVersionUID = 1L;
}