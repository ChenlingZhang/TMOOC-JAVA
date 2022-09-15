package cn.tedu.csmall.sever.Exception.Handler;

import cn.tedu.csmall.sever.Exception.ServiceException;
import cn.tedu.csmall.sever.Web.JsonResult;
import cn.tedu.csmall.sever.Web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public JsonResult handleServiceException(ServiceException e){
        log.error("统一异常处理:ServiceException,错误信息:{}",e.getMessage());
        return JsonResult.fail(e);
    }

    @ExceptionHandler
    public JsonResult handleThrowable(Throwable e){
        log.error("统一异常处理:{},错误信息:{}",e.getClass().getName(),e.getMessage());
        return JsonResult.fail(ServiceCode.ERR_UNKNOWN, e.getMessage());
    }
}
