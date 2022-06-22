package http;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/***
 * 这个类用于定义HTTP协议规定的内容，一颗被复用
 */
public class HttpContext {
    /**
     * 资源后缀与Mine类型的对应关系
     * key类型：资源的后缀名 例如：png
     * value：mime类型 例如：img/png
     */
    private static Map<String, String> mimeMapping = new HashMap<>();
    public static final char CR = 13; // 回车符
    public static final char LF = 10; // 换行符

    static { // 当HttpContext这个类加载的时候，static代码块中的内容也会随之加载
        initMimeMapping();
    }

    private static void initMimeMapping() {
        Properties properties = new Properties();
        /**
         * className.class.getClassLoader().getRescourseAsStream("./")
         * 表示该类所在包的顶级包的上一级
         * className.class.getRescourseAsStream
         * 表示该类所在的包
         */
        try {
            //读取时自动解析读取的properties文件会把文件中a=b形式转换为map形式存储
            properties.load(HttpContext.class.getResourceAsStream("./web.properties"));
            properties.forEach((k, v) -> mimeMapping.put(k.toString(), v.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String getMimeType(String ext) {
        return mimeMapping.get(ext);
    }
}
