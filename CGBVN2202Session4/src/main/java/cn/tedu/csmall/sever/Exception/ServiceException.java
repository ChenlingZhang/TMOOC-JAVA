package cn.tedu.csmall.sever.Exception;

public class ServiceException extends RuntimeException{
    private Integer serviceCode;
    public ServiceException(Integer serviceCode,String message) {
        super(message);
        this.serviceCode = serviceCode;
    }

    public Integer getServiceCode(){
        return serviceCode;
    }
}
