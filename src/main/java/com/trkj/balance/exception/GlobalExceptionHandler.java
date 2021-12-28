package com.trkj.balance.exception;

import com.trkj.balance.vo.AjaxResponse;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public AjaxResponse defaultErrorHandler(HttpServletRequest request, Exception e) {
        log.info("开始输出错误信息：");
        e.printStackTrace();
        if (e instanceof NoHandlerFoundException) {
            log.info("没有找到匹配的url");
            return AjaxResponse.error(new CustomError(CustomErrorType.PAGE_NOT_FOUND_ERROR, e.getMessage()));
        } else if (e instanceof SignatureException) {
            log.info("签名验证异常");
            return AjaxResponse.error(new CustomError(CustomErrorType.SIGNATURE_ERROR, e.getMessage()));
        }
        log.info("系统产生了异常");
        return AjaxResponse.error(new CustomError(CustomErrorType.SYSTEM_ERROR, e.getMessage()));
    }
}