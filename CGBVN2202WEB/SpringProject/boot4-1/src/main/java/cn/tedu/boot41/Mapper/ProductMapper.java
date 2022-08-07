package cn.tedu.boot41.Mapper;

import cn.tedu.boot41.Eneity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null, #{title}, #{price},#{saleCount})")
    void insert (Product product);

    @Select("select * from product")
    @Result(property = "saleCount", column = "sale_count")
    List<Product> select();
}
