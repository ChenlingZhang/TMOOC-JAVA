package com.webserver.http;

/**
 * 自定义异常类,类名一定要见明知义:异常类型+Exception
 * 空请求异常:当HttpServletRequest在解析请求时发现本次的请求是空请求时,会抛出该异常
 * 步骤:
 *  1:继承Exception异常父类
 *  2:重写父类的构造方法
 *      alt+insert 选择Constructor 全选,OK
 */
public class EmptyRequestException extends Exception{
    public EmptyRequestException() {
    }
    public EmptyRequestException(String message) {
        super(message);
    }
    public EmptyRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public EmptyRequestException(Throwable cause) {
        super(cause);
    }
    public EmptyRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
