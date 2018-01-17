package com.zhang.rest;


/**
 * Rest接口返回JSON实体
 *
 * @ClassName: Result
 * @Description:
 * @author: zhangyu
 * @date: 2017年4月11日上午11:18:27
 */
public class Result {

    /**
     * 状态码 - 成功(1)
     */
    public static Integer RECODE_SUCCESS = 1;

    /**
     * 状态码 - 失败(2)
     */
    public static Integer RECODE_ERROR = 0;

    /**
     * 状态码 - 未登陆(-1)
     */
    public static Integer RECODE_UNLOGIN = -1;

    /**
     * 状态码 - 校验失败(-2)
     */
    public static Integer RECODE_VALIDATE_ERROR = -2;

    /**
     * 错误信息(出错时有信息)
     */
    private String errMsg;

    /**
     * 状态码
     */
    private Integer retCode;

    /**
     * 返回数据
     */
    private Object data;

    public Result() {
        // 默认为成功状态
        this.retCode = Result.RECODE_SUCCESS;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "errMsg='" + errMsg + '\'' +
                ", retCode=" + retCode +
                ", data=" + data +
                '}';
    }
}
