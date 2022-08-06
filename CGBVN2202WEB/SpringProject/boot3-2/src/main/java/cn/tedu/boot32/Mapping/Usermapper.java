package cn.tedu.boot32.Mapping;

import cn.tedu.boot32.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Usermapper {
    /**
     * 在数据库中用户名只能至多出现1次
     * 用对象接收数据，如果查询除了大于1条记录则会抱错
     */
    @Select("select * from user where username=#{username}")
    User selectByUserName(String username);

    @Insert("insert into user values(null,#{username},#{password},#{nick})")
    void insert(User user);
}
