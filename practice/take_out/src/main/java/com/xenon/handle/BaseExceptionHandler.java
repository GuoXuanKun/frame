package com.xenon.handle;


import com.xenon.common.Result;
import com.xenon.exceptions.BusinessException;
import com.xenon.exceptions.enumeration.ResponseEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler
    public Object handleException(Exception e) {
        e.printStackTrace();
        return Result.error(ResponseEnum.ERROR);
    }

    @ExceptionHandler
    public Object handleException(RuntimeException e) {
        e.printStackTrace();
        return Result.error(ResponseEnum.ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public Object handleBusinessException(BusinessException e) {
        return Result.error(e.getResponse());
    }
}
