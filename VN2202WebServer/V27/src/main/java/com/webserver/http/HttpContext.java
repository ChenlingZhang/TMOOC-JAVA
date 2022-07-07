package com.webserver.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 这个类用于定义所有HTTP协议规定的内容,可以被复用
 */
public class HttpContext {
    /*
     * 回车符
     */
    public static final char CR = 13;
    /*
     * 换行符
     */
    public static final char LF = 10;
    /*
     * 资源后缀与MIME类型的对应关系
     * key:资源的后缀名 例如:png
     * value:MIME类型 例如:image/png
     */
    private static Map<String,String> mimeMapping = new HashMap<>();
    static{//当HttpContext类加载时,static代码块中的内容也会随之加载
        initMimeMapping();
    }
    private static void initMimeMapping(){
        /*
         * java.util.Properties
         * 该类是专门用于解析.properties文件的工具类.
         * Properties本身就是一个Map
         * Properties继承了Hashtable,Hashtable实现了Map接口,
         * 它是一个并发安全的Map,而HashMap不是并发安全的
         */
        Properties properties = new Properties();
        //读取和当前类HttpContext同一个目录下的web.proterties文件
        /*
         * 两个实际开发中常用的相对路径:
         * 类名.class.getClassLoader().getResourceAsStream(".");
         * 这里的"."指的是该类所在包的顶级包的上一级,即是"根"
         * 例如HttpContext类,包名是com.webserver.http上一级是编译后的target/classes目录
         * 类名.class.getResourceAsStream(".");
         * 这里的"."指的是该类所在的目录
         * 例如HttpContext类,包名是com.webserver.http
         * 同一目录是target/classes/com/webserver/http
         */
        try {
            //读取时,会自动解析读取的文件,properties文件的书写格式 a=b 会将a当做key,b当做value存储到properties这个map中
            properties.load(
                    HttpContext.class.getResourceAsStream("./web.properties")
            );
            //将properties这个map中的存储的k和v都转移到mimeMapping中
            properties.forEach(
                    (k,v)->mimeMapping.put(k.toString(), v.toString())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * 根据后缀名获取对应的MIME类型
     * @param ext 后缀名
     * @return 后缀名对应的MIME值
     */
    public static String getMimeType(String ext){
        return mimeMapping.get(ext);
    }
}
