package http;

/**
 * 自定义异常类，类名一定要见名知意：异常类型+Exception
 * 空请求异常：当HttpExceptionRequest在解析请求时候发现本次的请求是空请求时，会抛出该异常
 * 步骤1：
 * 1. 继承Exception异常父类
 * 2. 重写父类的构造方法
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
