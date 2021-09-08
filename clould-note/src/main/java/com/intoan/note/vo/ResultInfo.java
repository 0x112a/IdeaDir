package com.intoan.note.vo;

import lombok.Data;

/**
 * 封装返回值的封装类
 */
@Data
public class ResultInfo<T> {

    private Integer code;
    private String msg;
    private T result;

}
