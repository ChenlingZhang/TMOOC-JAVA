package cn.tedu.csmall.sever.Service;

import cn.tedu.csmall.sever.POJO.DTO.AlbumAddNewDTO;
import cn.tedu.csmall.sever.POJO.Entity.Album;

public interface IAlbumService {
    void addNew(AlbumAddNewDTO albumAddNewDTO);
}
