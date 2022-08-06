package cn.tedu.boot23.controller;
/*
* 商品 controller
*/

import cn.tedu.boot23.entity.Product;
import cn.tedu.boot23.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*@Controller
@ResponseBody
*/
@RestController// 等于@Controller+@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;
    @RequestMapping("insert")
    public String insert(Product product){
        System.out.println("product: " + product);
        mapper.insert(product);
        return "添加完成 <a href='/'>返回首页</a>";
    }

    @RequestMapping("select")
    public String select(){
        List<Product> list = mapper.select();
        String html = "<table border=1>";
        html += "<caption>商品列表</caption>";
        html += "<tr><th>id</th><th>标题</th><th>价格</th><th>销量</th><th>操作</th></tr>";
        for (Product p:list) {
            html+="<tr><td>"+p.getId()+"</td><td>"+p.getTitle()+"</td><td>"+p.getPrice()+"</td><td>"+p.getSaleCount()+"</td>";
            html+="<td><a href='/delete?id="+p.getId()+"'>删除</a></td>";
            html+="</tr>";
        }
        html += "</table>";
        return html;
    }

    @RequestMapping("delete")
    public String delete(int id){
        System.out.println("id="+id);
        mapper.delete(id);
        return "删除完成 <a href='/select'>返回上一页</a>";
    }

    @RequestMapping("update")
    public String update(Product product){
        mapper.update(product);
        return "修改完成 <a href='/select'>返回上一页</a>";
    }
}
