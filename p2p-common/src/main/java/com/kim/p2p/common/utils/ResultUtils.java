package com.kim.p2p.common.utils;


import com.alibaba.fastjson.JSON;
import com.kim.p2p.common.constant.ResultConstant;
import lombok.Data;

import java.io.Serializable;

public class ResultUtils {


    public static String ok(Object data){
        return JSON.toJSONString(new Result(ResultConstant.SIMPLE_SUCCESS_CODE, ResultConstant.SIMPLE_SUCCESS_MSG, data, true));
    }

    public static String ok(String msg, Object data){
        return JSON.toJSONString(new Result(ResultConstant.SIMPLE_SUCCESS_CODE, msg, data, true));
    }

    public static String ok(Integer code, Object data){
        return JSON.toJSONString(new Result(code, ResultConstant.SIMPLE_SUCCESS_MSG, data, true));
    }

    public static String ok(Integer code, String msg, Object data){
        return JSON.toJSONString(new Result(code, msg, data, true));
    }



    public static String error(Object data){
        return JSON.toJSONString(new Result(ResultConstant.SIMPLE_FAIL_CODE, ResultConstant.SIMPLE_FAIL_MSG, data, false));
    }

    public static String error(String msg, Object data){
        return JSON.toJSONString(new Result(ResultConstant.SIMPLE_FAIL_CODE, msg, data, false));
    }

    public static String error(Integer code, Object data){
        return JSON.toJSONString(new Result(code, ResultConstant.SIMPLE_FAIL_MSG, data, false));
    }

    public static String error(Integer code, String msg, Object data){
        return JSON.toJSONString(new Result(code, msg, data, false));
    }

    @Data
    private static class Result implements Serializable{

        private static final long serialVersionUID = 9070193333783812112L;

        private Integer code;

        private String msg;

        private Object data;

        private Boolean result;

        public Result(Integer code, String msg, Object data, Boolean result){
            this.code = code;
            this.msg = msg;
            this.data = data;
            this.result = result;
        }
    }
}
