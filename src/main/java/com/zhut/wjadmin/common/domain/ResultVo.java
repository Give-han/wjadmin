package com.zhut.wjadmin.common.domain;

import com.zhut.wjadmin.common.constant.ResultCodeConstant;
import lombok.Data;

import java.util.HashMap;

@Data
public class ResultVo<T> extends HashMap<String, Object> {

    private static final String CODE = "code";

    private static final String MESSAGE = "message";

    private static final String DATA = "data";

    // 状态码
    private Integer code;

    // 信息
    private String message;

    // 响应数据
    private Object data;

    public ResultVo () {}

    public ResultVo (Integer code, String message, Object data) {
//        this.code = code;
//        this.message = message;
//        this.data = data;
        super.put(CODE, code);
        super.put(MESSAGE, message);
        if (data != null) {
            super.put(DATA, data);
        }
    }

    public static ResultVo success (String message, Object data) {
        return new ResultVo(ResultCodeConstant.SUCCESS , message, data);
    }

    public static ResultVo success (String message) {
        return success(message, null);
    }

    public static ResultVo success (Object data) {
        return  success("SUCCESS", data);
    }

    public static ResultVo fail (String message, Object data) {
        return new ResultVo(ResultCodeConstant.ERROR , message, data);
    }

    public static ResultVo fail (String message) {
        return success(message, null);
    }

    public static ResultVo fail (Object data) {
        return success("FAIL", data);
    }

}
