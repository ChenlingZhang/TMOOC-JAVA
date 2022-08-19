package cn.tedu.coolshark.Controller;

import cn.tedu.coolshark.Entity.User;
import cn.tedu.coolshark.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;
    @RequestMapping("login")
    public int login(@RequestBody User user, HttpSession session){
        User u = mapper.selectByUserName(user);
        if (u != null){
            if (u.getPassword().equals(user.getPassword())){
                session.setAttribute("user",u);
                return 1; //登陆成功
            }
            else return 3; // 密码错误
        }
        return 2; // 用户名不存在
    }

    @RequestMapping("currentUser")
    public User currentUser(HttpSession session){
        return (User) session.getAttribute("user");
    }

    @RequestMapping("logout")
    public void Logout(HttpSession session){
        session.removeAttribute("user");
    }
}
