package cn.tedu.coolshark.Mapper;

import cn.tedu.coolshark.Entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Insert("insert into product values(null,#{title},#{url},#{price},#{oldPrice},0,#{saleCount},#{created},#{categoryId})")
    void insert(Product product);

    @Select("select id, title, price, sale_count, url from product")
    @Result(property = "saleCount", column = "sale_count")
    List<Product> select();

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

    @Select("select url from product where id=#{id}")
    String selectUrlById(int id);

    @Select("select id, title, price, old_price, sale_count, url from product")
    @Result(property = "saleCount", column = "sale_count")
    @Result(property = "oldPrice", column = "old_price")
    List<Product> indexSelector();

    @Select("select title, sale_count from product order by sale_count desc")
    @Result(property = "saleCount", column = "sale_count")
    List<Product> orderSelector();

    @Select("select id, title, url, price, old_price, sale_count from product where category_id = #{cid}")
    @Result(property = "saleCount", column = "sale_count")
    @Result(property = "oldPrice", column = "old_price")
    List<Product> selectByCid(int cid);

    @Select("select id, title, url, price, old_price, sale_count from product where title like concat('%',#{word},'%')")
    @Result(property = "saleCount", column = "sale_count")
    @Result(property = "oldPrice", column = "old_price")
    List<Product> selectByWord(String word);

    @Select("select id, title, url, price, old_price, sale_count, view_count, created from product where id=#{id}")
    @Result(property = "saleCount", column = "sale_count")
    @Result(property = "oldPrice", column = "old_price")
    @Result(property = "viewCount", column = "view_count")
    Product selectById(int id);

    @Update("update product set view_count=view_count+1 where id = #{id}")
    void updateViewCount(int id);

    @Delete("delete from product where category_id=#{id}")
    void deleteByCid(int id);
}
