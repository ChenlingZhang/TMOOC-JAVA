package cn.tedu.csmall.sever.POJO.Entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Album implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer sort;
    private Data gmsCreated;
    private Data gmsModified;

}
