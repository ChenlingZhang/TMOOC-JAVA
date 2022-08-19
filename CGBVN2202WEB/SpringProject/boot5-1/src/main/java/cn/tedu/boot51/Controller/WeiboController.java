package cn.tedu.boot51.Controller;

import cn.tedu.boot51.Entity.User;
import cn.tedu.boot51.Entity.Weibo;
import cn.tedu.boot51.Mapper.WeiboMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class WeiboController {
    @Autowired
    WeiboMapper mapper;
    @RequestMapping("insert")
    public int insert(@RequestBody Weibo weibo, HttpSession session){
        // 得到当前登陆的用户对象
        User u = (User) session.getAttribute("user");
        if (u == null){
            return 2; // 表示未登陆
        }
        // new Date: 得到系统的当前时间
        weibo.setCreated(new Date());
        // 将已经登陆的用户信息添加到微博对象中
        weibo.setUserID(u.getId());
        weibo.setNickname(u.getNickname());
        System.out.println("weibo: =" + weibo);
        mapper.insert(weibo);
        return 1;
    }

    @RequestMapping("select")
    public List<Weibo> select(){
        return mapper.select();
    }
}
