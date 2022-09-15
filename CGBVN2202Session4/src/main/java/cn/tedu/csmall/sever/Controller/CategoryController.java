package cn.tedu.csmall.sever.Controller;


import cn.tedu.csmall.sever.Service.ICategoryService;
import cn.tedu.csmall.sever.POJO.DTO.CategoryAddNewDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 组件扫描：
 *  1. 添加组件注解：Spring框架作用范围：以下四个注解是等效的
 *      /@Component--通用注解可以用于任何地方
 *      /@Controller--控制器注解
 *      /@Service--业务层控制器
 *      /@Repository--存储控制器
 *  2. 必须在"组件扫描"的包下
 */

//@Controller
@RestController
@RequestMapping("/category")
@Api(tags = "2.类别管理模块")
@Slf4j
public class CategoryController {
    @Autowired
    public ICategoryService categoryService;

    public CategoryController(){
        System.out.println("Create Controller Object: CategoryController");
    }
    // requestmapping 注解可以限制访问的类型例如限制访问的类型为get请求，需要在注解内加入method=RequestMethod.GET @RequestMapping（value=""，method=RequestMethod.__）
    @PostMapping(value = "/{id:[0-9]+}/delete")
    //@ResponseBody // 返回响应正文
    public String delete(@PathVariable long id){
        System.out.println("CategoryController.delet()");
        System.out.println("id = " + id);
        return "删除商品--待完成";
    }
    //此下写法可以被PostMapping替代
    @PostMapping(value = "/add-new")
    public String addNew(){
        System.out.println("CategoryController.addNew");
        return "新增商品 -- 待完成";
    }

    @GetMapping()
    public String list(){
        System.out.println("CategoryController.list");
        return "商品列表--待完成";
    }

    @PostMapping("/{id:[0-9]+}/update-by-id")
    public String updateByID(@PathVariable Long id, CategoryAddNewDTO categoryAddNewDTO){
        System.out.println("CategoryController.updateByID");
        System.out.println("id = " + id + ", categoryAddNewDTO = " + categoryAddNewDTO);
        return "更新商品--待完成";
    }

}
