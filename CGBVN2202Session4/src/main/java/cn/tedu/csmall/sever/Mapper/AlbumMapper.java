package cn.tedu.csmall.sever.Mapper;

import cn.tedu.csmall.sever.POJO.Entity.Album;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumMapper {
    int insert(Album album);
}
