package cn.tedu.csmall.sever.POJO.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/*
* 1. 增加序列化接口
* 2. 添加 属性，get，set，hashcode，equals， tostring
* */

@Data
public class BrandAddNewDTO implements Serializable {
    @ApiModelProperty(value = "品牌名称",required = true, example = "华为")
    private String name;             //名字
    @ApiModelProperty(value = "品牌名称",required = true, example = "huawei")
    private String pingyin;          //拼音
    @ApiModelProperty(value = "品牌logo",required = true)
    private String logo;             //logo
    @ApiModelProperty(value = "品牌类别")
    private Long categoryID;         //类别
    @ApiModelProperty(value = "品牌描述")
    private String description;      //描述
    @ApiModelProperty(value = "品牌关键词")
    private String keywords;         //关键词
    @ApiModelProperty(value = "品牌排序值")
    private Integer sort;            //排序值

}
