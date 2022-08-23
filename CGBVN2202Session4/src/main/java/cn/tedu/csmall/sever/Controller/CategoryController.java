package cn.tedu.csmall.sever.Controller;


import org.springframework.stereotype.Controller;


/**
 * 组件扫描：
 *  1. 添加组件注解：Spring框架作用范围：以下四个注解是等效的
 *      /@Component--通用注解可以用于任何地方
 *      /@Controller--控制器注解
 *      /@Service--业务层控制器
 *      /@Repository--存储控制器
 *  2. 必须在"组件扫描"的包下
 */
@Controller
public class CategoryController {
    public CategoryController(){
        System.out.println("Create Controller Object: CategoryController");
    }
}
