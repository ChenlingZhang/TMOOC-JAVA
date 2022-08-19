package cn.tedu.coolshark;

import cn.tedu.coolshark.Entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filter.MyFiltter", urlPatterns = {"/insertProduct.html","/admin.html",})
public class FilterMyFiltter implements Filter {
    // 初始化方法，当过滤器初始化时执行的方法
    public void init(FilterConfig config) throws ServletException {
    }
    // 当过滤器销毁时执行的方法
    public void destroy() {
    }

    // 当过滤器销毁时执行的方法，需要在此方法中判断是否满足条件，如果满足则可以访问资源文件，不满足则拦截
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest http_request = (HttpServletRequest) request;
        HttpServletResponse http_response = (HttpServletResponse) response;
        // 得到session会话对象
        HttpSession session = http_request.getSession();
        // 从会话对象当中得到登陆成功之后保存的用户对象
        User user = (User) session.getAttribute("user");
        if (user !=null) {
            chain.doFilter(request, response); // 放行允许访问资源
        }
        else{
            http_response.sendRedirect("/login.html");
        }
        System.out.println("The Filtter is Excuted");
    }
}
