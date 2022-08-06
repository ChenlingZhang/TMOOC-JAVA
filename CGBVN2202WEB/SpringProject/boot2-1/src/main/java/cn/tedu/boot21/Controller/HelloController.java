package cn.tedu.boot21.Controller;

import cn.tedu.boot21.Entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HelloController {
    // 访问路径为hello，返回结果为测试成功
    /*@RequestMapping("hello")
    public void hello(HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write("测试成功");
        pw.close();
    }*/

    @RequestMapping("hello")
    @ResponseBody //Spring MVC框架提供的注解，作用：可以通过返回值的方式将数据响应给客户端
    public String hello(){
        return "测试成功!!";
    }

    @RequestMapping("/param1")
    @ResponseBody
    public String param1(HttpServletRequest request){
        String info = request.getParameter("info");
        return "接收到参数： "+ info;
    }

    @RequestMapping("/param2")
    @ResponseBody
    public String param2(String name, int age){
        return "接收到了参数: \n" + "姓名：\n"+ name +"年龄：\n" + age;
    }

    @RequestMapping("/param3")
    @ResponseBody
    public String param3(Emp emp){
        return emp.toString();
    }
}
