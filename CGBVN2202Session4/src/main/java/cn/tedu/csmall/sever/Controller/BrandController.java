package cn.tedu.csmall.sever.Controller;

import cn.tedu.csmall.sever.Service.IBrandService;
import cn.tedu.csmall.sever.pojo.dto.BrandAddNewDTO;
import cn.tedu.csmall.sever.pojo.dto.BrandEditorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    public IBrandService brandService;

    public BrandController(){
        System.out.println("创建数据层对象：BrandController");
    }

    @RequestMapping("/add-new")
    public String addNew(BrandAddNewDTO brandAddNewDTO){
        System.out.println("BrandController.addNew");
        System.out.println("brandAddNewDTO = " + brandAddNewDTO);
        return "新增品牌--待完成";
    }

    @RequestMapping("/{id:[0-9]+}/edit")
    public String updateByID(@PathVariable Long id, BrandEditorDTO brandEditorDTO){
        System.out.println("BrandController.updateByID");
        System.out.println("id = " + id + ", brandEditorDTO = " + brandEditorDTO);
        return "更改品牌--待完成";
    }

    @RequestMapping("/{id:[0-9]+}/delete")
    public String deleteByID(@PathVariable Long id){
        System.out.println("BrandController.deleteByID");
        System.out.println("id = " + id);
        return "删除品牌--待完成";
    }

    @RequestMapping
    public String list(){
        System.out.println("BrandController.list");
        return "品牌列表--待完成";
    }
}
