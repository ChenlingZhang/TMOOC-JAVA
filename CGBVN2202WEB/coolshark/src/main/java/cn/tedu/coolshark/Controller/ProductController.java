package cn.tedu.coolshark.Controller;

import cn.tedu.coolshark.Entity.Product;
import cn.tedu.coolshark.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Value("${dirPath}")
    String localPath;

    @Autowired
    ProductMapper mapper;
    @RequestMapping("insert")
    public void insert(@RequestBody Product product){
        //设置商品的发布时间为当前时间
        product.setCreated(new Date());
        mapper.insert(product);
    }

    @RequestMapping("select")
    public List<Product> product(){
        return mapper.select();
    }

    @RequestMapping("delete")
    public void deleteById(int id){
        String url = mapper.selectUrlById(id);
        String dirPath = localPath + "/"+url;
        // 创建文件对象并进行删除
        new File(dirPath).delete();
        mapper.deleteById(id);
    }

    @RequestMapping("select/index")
    public List<Product> indexSelector(){
        return mapper.indexSelector();
    }

    @RequestMapping("select/order")
    public List<Product> orderSelector(){
        List<Product> list = mapper.orderSelector();
        for (Product product : list) {
            if (product.getTitle().length() > 3) {
                String title = product.getTitle().substring(0,3) + " ... ";
                product.setTitle(title);
            }
        }
        return list;
    }

    @RequestMapping("select/category")
    public List<Product> selectByCid(int cid){
        return mapper.selectByCid(cid);
    }

    @RequestMapping("select/search")
    public List<Product> selectByWord(String wd){
        return  mapper.selectByWord(wd);
    }

    @RequestMapping("select/detail")
    public Product selectById(int id){
        mapper.updateViewCount(id);
        return mapper.selectById(id);
    }
}
