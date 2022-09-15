package cn.tedu.csmall.sever.Service.Impl;

import cn.tedu.csmall.sever.Mapper.AlbumMapper;
import cn.tedu.csmall.sever.POJO.DTO.AlbumAddNewDTO;
import cn.tedu.csmall.sever.POJO.Entity.Album;
import cn.tedu.csmall.sever.Service.IAlbumService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements IAlbumService {
    @Autowired
    private AlbumMapper mapper;
    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO) {
        Album album = new Album();
        BeanUtils.copyProperties(albumAddNewDTO,album);
        mapper.insert(album);
    }
}
