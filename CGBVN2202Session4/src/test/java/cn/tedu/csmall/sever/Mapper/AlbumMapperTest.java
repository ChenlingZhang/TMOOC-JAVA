package cn.tedu.csmall.sever.Mapper;

import cn.tedu.csmall.sever.POJO.Entity.Album;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AlbumMapperTest {
    @Autowired
    AlbumMapper mapper;
    @Test
    public void insertTest(){
        String name = "head";
        String description = "111";
        Album album = new Album();
        album.setName(name);
        album.setDescription(description);
        int row = mapper.insert(album);
        log.debug("插入成功，受影响的行数：" + row);
    }
}
