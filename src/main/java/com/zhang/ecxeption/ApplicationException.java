package com.zhang.ecxeption;

/**
 * 自定义异常
 *
 * @author zhangyu
 */
public class ApplicationException extends RuntimeException {

    private int code;

    public ApplicationException(int code, String message) {
        super(message, null, true, true);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
