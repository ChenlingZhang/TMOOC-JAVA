package cn.tedu.boot51.Controller;

import cn.tedu.boot51.Entity.User;
import cn.tedu.boot51.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("reg")
    public int reg(@RequestBody User user){
        User u = mapper.selectByName(user.getUsername());
        if (u != null){
            return 1;
        }
        mapper.insert(user);
        return 0;
    }
    @RequestMapping("login")
    public int login(@RequestBody User user, HttpSession session){
        User u = mapper.selectByName(user.getUsername());
        if (u == null){
            return 3;
        }else {
            if (user.getPassword().equals(u.getPassword())){
                // 把当前登陆的用户提交给session
                session.setAttribute("user",u);
                return 1;
            }
            return 2;
        }
    }

    @RequestMapping("currentUser")
    public User currentUser(HttpSession session){
        User u = (User)session.getAttribute("user");
        return u;
    }

    @RequestMapping("logout")
    public void logout(HttpSession session){
        session.removeAttribute("user");
    }
}
