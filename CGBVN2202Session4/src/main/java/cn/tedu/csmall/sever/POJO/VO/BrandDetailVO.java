package cn.tedu.csmall.sever.POJO.VO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class BrandDetailVO implements Serializable {
    private Long id;                   //记录id
    private String name;               //品牌记录
    private String pinyin;             //品牌名称的拼音
    private String logo;               //品牌Logo的URL
    private String description;        //品牌介绍
    private String keywords;           //关键词列表
    private Integer sort;              //自定义排序序号
    private Integer sales;             //销量
    private Integer productCount;      //商品种类数量总和
    private Integer commentCount;      //买家评论数量
    // 总和
    private Integer positiveCommentCount; //买家好评数量总和
    private Integer enable;            //是否启用
    private LocalDateTime gmtCreate;   //创建时间
    private LocalDateTime gmtModified; //修改时间
}
