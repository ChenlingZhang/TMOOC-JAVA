package cn.tedu.boot41.Mapper;

import cn.tedu.boot41.Eneity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null, #{title}, #{price},#{saleCount})")
    void insert (Product product);

    @Select("select * from product")
    @Result(property = "saleCount", column = "sale_count")
    List<Product> select();

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @Select("select * from product where id=#{id}")
    @Result(property = "saleCount", column = "sale_count")
    Product selectById(int id);

    @Update("update product set title=#{title}, price=#{price}, sale_count=#{saleCount} where id=#{id}")
    void update(Product product);
}
