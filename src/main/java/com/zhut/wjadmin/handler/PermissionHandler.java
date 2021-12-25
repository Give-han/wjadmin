package com.zhut.wjadmin.handler;

import com.zhut.wjadmin.common.domain.ResultVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.SignatureException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class PermissionHandler {
    @ExceptionHandler(value = { SignatureException.class })
    public ResultVo authorizationException(SignatureException e) {
        return ResultVo.fail(e.getMessage());
    }
}
