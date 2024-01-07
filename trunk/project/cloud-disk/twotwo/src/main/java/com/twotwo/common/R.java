package com.twotwo.common;

import lombok.Data;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 *
 * @param <T>
 */
@Data
public class R<T> {
    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private Integer total;//数据总量
    private T data; //数据

    public static <T> R<T> success() {
        R<T> r = new R<>();
        r.code = 1;
        return r;
    }

    public static <T> R<T> success(T object) {
        R<T> r = new R<>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> success(T object, Integer count) {
        R<T> r = new R<>();
        r.data = object;
        r.total = count;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R<T> r = new R<>();
        r.msg = msg;
        r.code = 0;
        return r;
    }

}