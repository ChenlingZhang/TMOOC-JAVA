package cn.tedu.csmall.sever.Mapper;

import cn.tedu.csmall.sever.POJO.Entity.AttributeTamplate;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeTamplateMapper {
    int insert(AttributeTamplate attributeTamplate);
}
