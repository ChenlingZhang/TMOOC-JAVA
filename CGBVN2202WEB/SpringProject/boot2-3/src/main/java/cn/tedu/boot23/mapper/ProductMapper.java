package cn.tedu.boot23.mapper;

import cn.tedu.boot23.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product(id,title,price,sale_Count) values (null,#{title},#{price},#{saleCount})")
    void insert(Product product);

    // 数据库中字段为sale_count，实体类中属性为saleCount
    @Select("select * from product")
    @Result(column = "sale_count", property = "saleCount")
    List<Product> select();

    @Delete("delete from product where id=#{id}")
    void delete(int id);

    @Update("update product set title=#{title}, price=#{price},sale_count=#{saleCount} where id=#{id}")
    void update(Product product);
}
