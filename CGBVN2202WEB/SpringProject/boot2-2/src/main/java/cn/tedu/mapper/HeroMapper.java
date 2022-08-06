package cn.tedu.mapper;

import cn.tedu.entity.Hero;
import org.apache.ibatis.annotations.*;

import java.sql.ResultSet;
import java.util.List;

@Mapper
public interface HeroMapper {
    /*
        #{}会从下面方法参数列表中找到同名变量，若没有同名变量则进入对象中寻找同名的get方法
        Mybatis框架会根据Insert注解声明生成具体的实现类的方法，方法内部就是JDBC方法
     */
    @Insert("insert into hero(id,name,money) values(null,#{name},#{money})")
    void insert(Hero hero);

    @Delete("delete from hero where name=#{name}")
    void deleteByName(String name);

    @Update("update hero set name=#{name},money=#{money} where id=#{id} ")
    void update(Hero hero);

    @Select("select * from hero")
    List<Hero> select();
}
