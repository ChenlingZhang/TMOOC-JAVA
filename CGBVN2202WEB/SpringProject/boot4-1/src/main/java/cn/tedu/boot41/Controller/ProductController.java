package cn.tedu.boot41.Controller;

import cn.tedu.boot41.Eneity.Product;
import cn.tedu.boot41.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;
    @RequestMapping("insert")
    public void insert(@RequestBody Product product){
        mapper.insert(product);
        System.out.println("product="+product);
    }
    @RequestMapping("select")
    public List<Product> select(){
        return mapper.select();
    }

    @RequestMapping("delete")
    public void delete(int id){
        mapper.deleteById(id);
    }

    @RequestMapping("selectById")
    public Product selectById(int id){
        return mapper.selectById(id);
    }

    @RequestMapping("update")
    public void update(@RequestBody Product product){
        mapper.update(product);
    }
}
