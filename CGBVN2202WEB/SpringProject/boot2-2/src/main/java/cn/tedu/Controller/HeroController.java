package cn.tedu.Controller;

import cn.tedu.entity.Hero;
import cn.tedu.mapper.HeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HeroController {
    /*
       自动装配注解: Spring框架结合Mybatis框架会自动将HeroMapper生成一个实现类，并实例化存入容器中
       Autowrited会从容器中找到类型匹配的对象注入到此变量中
     */
    @Autowired
    HeroMapper mapper;

    @RequestMapping("add")
    @ResponseBody
    public String add(Hero hero){
        mapper.insert(hero);
        return "添加完成"+hero;
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(String name){
        mapper.deleteByName(name);
        return "删除完成 "+name;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Hero hero){
        mapper.update(hero);
        return "修改成功 " + hero;
    }

    @RequestMapping("select")
    @ResponseBody
    public List<Hero> select(){
        List<Hero> list = mapper.select();
        return list;
    }
}
