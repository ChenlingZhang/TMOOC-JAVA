package core;

import java.util.HashMap;
import java.util.Map;

/***
 * 这个类用于定义HTTP协议规定的内容，一颗被复用
 */
public class HttpContext {
    /**
     * 资源后缀与Mine类型的对应关系
     * key类型：资源的后缀名 例如：png
     * value：mime类型 例如：img/png
     */
    private static Map<String,String> mimeMapping = new HashMap<>();
    public static final char CR = 13; // 回车符
    public static final char LF = 10; // 换行符
    static { // 当HttpContext这个类加载的时候，static代码块中的内容也会随之加载
        initMimeMapping();
    }
    private static void initMimeMapping(){
        mimeMapping.put("html","text/html");
        mimeMapping.put("js","text/js");
        mimeMapping.put("gif","image/gif");
        mimeMapping.put("jpg","image/jpeg");
        mimeMapping.put("png","image/png");
    }

    public static String getMimeType(String ext){
        return mimeMapping.get(ext);
    }
}
