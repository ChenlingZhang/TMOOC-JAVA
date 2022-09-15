package cn.tedu.csmall.sever.POJO.Entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttributeTamplate {
    private Integer id;
    private String name;
    private String pinyin;
    private String keywords;
    private Integer sort;
    private LocalDateTime gmtCreate;   //创建时间
    private LocalDateTime gmtModified; //修改时间


}
