package cn.tedu.csmall.sever.Controller;

import cn.tedu.csmall.sever.Service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BrandController {
    @Autowired
    public IBrandService brandService;

    public BrandController(){
        System.out.println("创建数据层对象：BrandController");
    }
}
