package com.bupt.cad.utils;

import com.bupt.cad.common.ApiResult;

public class ResultUtil {

    public static ApiResult success(Object data,String message){
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(0);
        apiResult.setMessage(message);
        apiResult.setDATA(data);
        return apiResult;
    }
    public static ApiResult success(String message) {
        return success(null,message);
    }
    public static <T> ApiResult<T> error(Integer code,String message) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }
}
