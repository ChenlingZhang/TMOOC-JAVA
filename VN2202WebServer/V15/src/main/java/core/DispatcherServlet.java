package core;

import http.HTTPServletRequest;
import http.HttpServletResponse;
import java.io.File;
import java.net.URISyntaxException;

public class DispatcherServlet {
    private static File staticDir;

    static {
        try {
            staticDir = new File(ClientHandle.class.getClassLoader().getResource("./static").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void service(HTTPServletRequest request, HttpServletResponse response) {
        String path = request.getUrl();
        System.out.println("Abstract Path: " + path);
        /*
          指定父级目录，防止子级目录报错，影响父级目录。报空指针错误
         */
        File file = new File(staticDir,path);
        if (file.isFile()){ // 如果是文件，说明访问的资源存在
            // 发送状态行
            response.setContentFile(file);

        }
        else{
            response.setStatusCode(404);
            response.setStatusResult("NotFound");
            // 如果不存在则访问404页面
            file = new File(staticDir,"/root/404.html");
            response.setContentFile(file);
            response.addHeaders("Content-Type", "text/html");
            response.addHeaders("Content-Length", file.length()+"");
        }
    }
}
