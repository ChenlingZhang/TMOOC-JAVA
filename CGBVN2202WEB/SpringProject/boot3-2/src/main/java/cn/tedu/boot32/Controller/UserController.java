package cn.tedu.boot32.Controller;

import cn.tedu.boot32.Entity.User;
import cn.tedu.boot32.Mapping.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    Usermapper mapper;
    @RequestMapping("reg")
    public int reg(@RequestBody User user){
        User u = mapper.selectByUserName(user.getUsername());
        if (u != null){
            return 2;
        }
        mapper.insert(user);
        return 1;
    }
    @RequestMapping("login")
    public int login(@RequestBody User user){
        User u = mapper.selectByUserName(user.getUsername());
        if (u!=null){
            if (user.getPassword().equals(u.getPassword())){
                return 1; // 登陆成功
            }
            return 3; // 密码错误
        }
        return 2;// 用户名错误
    }
}
