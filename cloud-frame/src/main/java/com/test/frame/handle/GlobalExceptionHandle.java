package com.test.frame.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.test.common.entity.Result;
import com.test.common.enums.ErrorCodeEnum;
import com.test.common.exception.BusinessException;

/**
 * 全局异常处理
 * @author Administrator
 * annotations 处理类型：RestController
 */
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandle {
	
	@ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> Result<T> runtimeExceptionHandler(Exception e) {
//        log.error("---------> huge error!", e);
        String exstr =  e.getClass().getSimpleName();
        if("BadSqlGrammarException".equalsIgnoreCase(exstr)){
        	return  Result.err(ErrorCodeEnum.DATA_SQL_ERROR.getErrCode(),ErrorCodeEnum.DATA_SQL_ERROR.getMessage());
        }
        return Result.err(ErrorCodeEnum.SYS_ERROR_OTHER.getErrCode(),"系统异常请稍后再试!");
    }
	
	//业务异常
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    private <T> Result<T> BusinessExceptionHandler(BusinessException e) {
//        log.error("---------> business error!", e);
        return Result.err(e.getErrorCode(),e.getMessage());
    }

}
