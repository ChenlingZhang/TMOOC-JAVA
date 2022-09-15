package cn.tedu.csmall.sever.POJO.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class AlbumAddNewDTO implements Serializable {
    @ApiModelProperty(value = "相册名称")
    private String name;
    @ApiModelProperty(value = "相册描述")
    private String description;

}
