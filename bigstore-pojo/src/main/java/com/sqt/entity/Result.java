package com.sqt.entity;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-11-04  15:08
 */
public class Result  implements Serializable {

    private int code; //返回状态码
    private  String msg; //返回消息

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
