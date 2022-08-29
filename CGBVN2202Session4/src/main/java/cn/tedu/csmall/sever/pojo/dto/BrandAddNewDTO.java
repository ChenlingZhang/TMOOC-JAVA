package cn.tedu.csmall.sever.pojo.dto;

import java.io.Serializable;
import java.util.Objects;

/*
* 1. 增加序列化接口
* 2. 添加 属性，get，set，hashcode，equals， tostring
* */
public class BrandAddNewDTO implements Serializable {
    private String name;             //名字
    private String pingyin;          //拼音
    private String logo;             //logo
    private Long categoryID;         //类别
    private String description;      //描述
    private String keywords;         //关键词
    private Integer sort;            //排序值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandAddNewDTO that = (BrandAddNewDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(pingyin, that.pingyin) && Objects.equals(logo, that.logo) && Objects.equals(categoryID, that.categoryID) && Objects.equals(description, that.description) && Objects.equals(keywords, that.keywords) && Objects.equals(sort, that.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pingyin, logo, categoryID, description, keywords, sort);
    }

    @Override
    public String toString() {
        return "BrandAddNewDTO{" +
                "name='" + name + '\'' +
                ", pingyin='" + pingyin + '\'' +
                ", logo='" + logo + '\'' +
                ", categoryID=" + categoryID +
                ", description='" + description + '\'' +
                ", keywords='" + keywords + '\'' +
                ", sort=" + sort +
                '}';
    }
}
