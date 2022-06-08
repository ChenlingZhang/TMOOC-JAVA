package core;

import http.HTTPServletRequest;
import http.HttpServletResponse;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

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
            Map<String,String> fileNames = new HashMap<>();
            fileNames.put("html","text/html");
            fileNames.put("js","text/js");
            fileNames.put("gif","image/gif");
            fileNames.put("jpg","image/jpeg");
            fileNames.put("png","image/png");
            String fileName=file.getName();
            String nameSplit = fileName.substring(fileName.lastIndexOf(".")+1);
            String mine = fileNames.get(nameSplit);
            response.addHeaders("Content-Type", mine);
            response.addHeaders("Content-Length", file.length()+"");
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
