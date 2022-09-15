package cn.tedu.csmall.sever.Web;

/**
 * 业务状态码
 */
public class ServiceCode {
    /*成功*/
    public static final int OK = 20000;
    /*错误：冲突，出现了重复的错误*/
    public static final int ERR_CONFLICT = 40001;
    /*错误：插入错误*/
    public static final int ERR_INSERT = 50200;
    /*错误：更新错误*/
    public static final int ERR_UPDATE = 50300;
    /*错误：删除错误*/
    public static final int ERR_DELETE = 50400;
    /*错误：未知错误*/
    public static final int ERR_UNKNOWN = 59999;

}
