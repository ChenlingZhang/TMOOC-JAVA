package cn.tedu.csmall.sever.Web;

import cn.tedu.csmall.sever.Exception.ServiceException;
import lombok.Data;

@Data
public class JsonResult {
    /**业务状态码*/
    private Integer code;
    /**错误时候的信息*/
    private String Message;

    private Object data;

    public static JsonResult ok(){
        return ok(null);
    }

    public static JsonResult ok(Object data){
        JsonResult jsonResult = new JsonResult();
        jsonResult.code = ServiceCode.OK;
        jsonResult.data = data;
        return jsonResult;
    }
    public static JsonResult fail(ServiceException e){
        return fail(e.getServiceCode(),e.getMessage());
    }
    public static JsonResult fail(Integer code, String message){
        JsonResult jsonResult = new JsonResult();
        jsonResult.code = code;
        jsonResult.setMessage(message);
        return jsonResult;
    }
}
