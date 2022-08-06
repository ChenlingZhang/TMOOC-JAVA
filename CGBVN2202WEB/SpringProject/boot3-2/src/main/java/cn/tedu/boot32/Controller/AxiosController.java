package cn.tedu.boot32.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxiosController {
    @RequestMapping("/hello1Axios")
    public String hello1(String info){
        return "Get请求成功! info="+info;
    }

    /**
     * RequestBody 的作用：当客户端发出post请求并且提交给的是自定义对象时，服务端接收参数必须使用此注解
     * 否则接收不到传递来的参数
     * @param info
     * @return
     */
    @RequestMapping("/hello2Axios")
    public String hello2(@RequestBody String info){
        return"Post请求成功! info="+info;
    }
}
