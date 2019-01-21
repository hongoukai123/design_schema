package com.kai.chap.result;

/**
 * 响应结果类
 */
public class ResponseResult<T> {

    private Integer code;

    private T data;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseResult() {
        this.code = 2001;
        this.msg = "error";
        this.data = null;
    }

    public ResponseResult(T data) {
        this.data = data;
        this.code = 2000;
        this.msg = "success";
    }

    public ResponseResult(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>(data);
    }

    public static <T> ResponseResult<T> error() {
        return new ResponseResult<T>(2001, null, "error");
    }

    @Override
    public String toString() {
        return "ResponseResult [code=" + code + ", data=" + data + ", msg=" + msg + "]";
    }

}
