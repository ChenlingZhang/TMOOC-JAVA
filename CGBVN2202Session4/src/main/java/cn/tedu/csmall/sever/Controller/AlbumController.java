package cn.tedu.csmall.sever.Controller;

import cn.tedu.csmall.sever.POJO.DTO.AlbumAddNewDTO;
import cn.tedu.csmall.sever.Service.IAlbumService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "3.相册管理模块")
@RestController
@RequestMapping("/albums")
@Slf4j
public class AlbumController {
    @Autowired
    private IAlbumService service;
    @PostMapping("/add-new")
    public String addAlbum(AlbumAddNewDTO albumAddNewDTO){
      log.trace("插入的数据：" + albumAddNewDTO);
      service.addNew(albumAddNewDTO);
      return "新增相册--待完成";
    }
}
