package cn.tedu.boot11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller //创建Controller对象，将对象存储在Spring中的Bean容器中
public class HelloController {
    @RequestMapping("hello") // 设置访问路径
    public void hello(HttpServletResponse response) throws IOException {
        // 设置响应类型，告诉客户端服务器响应的数据类型以及字符集
        response.setContentType("text/html; charset=utf-8");
        // 得到输出对象
        PrintWriter pw = response.getWriter();
        // 输出数据
        pw.print("服务器接收到了请求！<h1>测试成功</h1>");
        // 关闭资源
        pw.close();
    }
}
