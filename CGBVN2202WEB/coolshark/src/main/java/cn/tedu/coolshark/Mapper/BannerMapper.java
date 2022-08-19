package cn.tedu.coolshark.Mapper;

import cn.tedu.coolshark.Entity.Banner;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BannerMapper {
    @Select("select * from banner")
    List<Banner> select();

    @Delete("delete from banner where id=#{id}")
    void deleteById(int id);

    @Select("select url from banner where id=#{id}")
    String selectById(int id);

    @Insert("insert into banner values(null, #{url})")
    void insert(Banner banner);
}
