package cn.tedu.boot51.Mapper;

import cn.tedu.boot51.Entity.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeiboMapper {
    @Insert("insert into weibo values (null, #{content}, #{url}, #{nickname}, #{created}, #{userID}")
    void insert(Weibo weibo);

    @Select("select id, content, url, nick from weibo order by created desc")
    @Result(property = "nickname", column = "nick")
    List<Weibo> select();
}
