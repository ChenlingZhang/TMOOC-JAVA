package cn.tedu.csmall.sever.pojo.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class BrandEditorDTO implements Serializable {
    private String name;                // 属性名称
    private String category;            // 属性分类
    private int searchRule;             // 能否解锁
    private boolean isRelated;         // 是否相关
    private int[] chooseMethod;        // 是否可选
    private int enterMethod;           // 输入规则
    private String[] chooseList;      // 选择列表
    private int sortIndex;              // 排序

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSearchRule() {
        return searchRule;
    }

    public void setSearchRule(int searchRule) {
        this.searchRule = searchRule;
    }

    public boolean isRelated() {
        return isRelated;
    }

    public void setRelated(boolean related) {
        isRelated = related;
    }

    public int[] getChooseMethod() {
        return chooseMethod;
    }

    public void setChooseMethod(int[] chooseMethod) {
        this.chooseMethod = chooseMethod;
    }

    public int getEnterMethod() {
        return enterMethod;
    }

    public void setEnterMethod(int enterMethod) {
        this.enterMethod = enterMethod;
    }

    public String[] getChooseList() {
        return chooseList;
    }

    public void setChooseList(String[] chooseList) {
        this.chooseList = chooseList;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrandEditorDTO)) return false;
        BrandEditorDTO that = (BrandEditorDTO) o;
        return searchRule == that.searchRule && isRelated == that.isRelated && enterMethod == that.enterMethod && sortIndex == that.sortIndex && Objects.equals(name, that.name) && Objects.equals(category, that.category) && Arrays.equals(chooseMethod, that.chooseMethod) && Arrays.equals(chooseList, that.chooseList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, category, searchRule, isRelated, enterMethod, sortIndex);
        result = 31 * result + Arrays.hashCode(chooseMethod);
        result = 31 * result + Arrays.hashCode(chooseList);
        return result;
    }

    @Override
    public String toString() {
        return "BrandEditorDTO{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", searchRule=" + searchRule +
                ", isRelated=" + isRelated +
                ", chooseMethod=" + Arrays.toString(chooseMethod) +
                ", enterMethod=" + enterMethod +
                ", chooseList=" + Arrays.toString(chooseList) +
                ", sortIndex=" + sortIndex +
                '}';
    }
}
