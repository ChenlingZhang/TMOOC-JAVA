package cn.tedu.coolshark.Mapper;

import cn.tedu.coolshark.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User selectByUserName(User user);
}
