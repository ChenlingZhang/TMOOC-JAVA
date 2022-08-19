package cn.tedu.coolshark.Controller;

import cn.tedu.coolshark.Entity.Category;
import cn.tedu.coolshark.Mapper.CategoryMapper;
import cn.tedu.coolshark.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryMapper mapper;
    @Autowired
    ProductMapper productMapper;

    @RequestMapping("select")
    public List<Category> select(){
        return mapper.select();
    }

    @RequestMapping("delete")
    public void delete(int id){
        mapper.deleteById(id);
        productMapper.deleteByCid(id);
    }
    @RequestMapping("insert")
    public void insertByName(String name){
        mapper.insertByName(name);
    }
}
