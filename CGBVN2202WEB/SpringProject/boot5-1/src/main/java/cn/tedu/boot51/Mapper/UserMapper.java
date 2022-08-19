package cn.tedu.boot51.Mapper;

import cn.tedu.boot51.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    @Result(property = "nickname", column = "nick")
    User selectByName(String name);

    @Insert("insert into user values(null, #{username}, #{password}, #{nickname})")
    void insert(User user);


}
