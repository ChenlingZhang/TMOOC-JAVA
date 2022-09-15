package cn.tedu.csmall.sever.Controller;

import cn.tedu.csmall.sever.POJO.DTO.BrandAddNewDTO;
import cn.tedu.csmall.sever.POJO.DTO.BrandEditorDTO;
import cn.tedu.csmall.sever.Service.IBrandService;
import cn.tedu.csmall.sever.Web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/brands")
@Slf4j
@Api(tags="1. 品牌管理模块")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    public BrandController(){
        System.out.println("创建数据层对象：BrandController");
    }

    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 1001)
    @PostMapping("/add-new")
    public JsonResult addNew(BrandAddNewDTO brandAddNewDTO){
        log.debug("接收的参数：{}", brandAddNewDTO);
        brandService.addNew(brandAddNewDTO);
        return JsonResult.ok();
    }
    @ApiOperation("修改品牌")
    @ApiOperationSupport(order = 1002)
    @PostMapping("/{id:[0-9]+}/edit")
    public String updateByID(@PathVariable Long id, BrandEditorDTO brandEditorDTO){
        System.out.println("BrandController.updateByID");
        System.out.println("id = " + id + ", brandEditorDTO = " + brandEditorDTO);
        return "更改品牌--待完成";
    }

    @ApiOperation("删除品牌")
    @ApiOperationSupport(order = 1003)
    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteByID(@PathVariable Long id){
        System.out.println("BrandController.deleteByID");
        System.out.println("id = " + id);
        return "删除品牌--待完成";
    }

    @ApiOperation("查看品牌")
    @ApiOperationSupport(order = 1004)
    @GetMapping
    public String list(){
        System.out.println("BrandController.list");
        return "品牌列表--待完成";
    }
}
