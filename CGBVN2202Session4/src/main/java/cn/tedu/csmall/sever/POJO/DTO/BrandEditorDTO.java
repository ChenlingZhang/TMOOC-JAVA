package cn.tedu.csmall.sever.POJO.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Data
public class BrandEditorDTO implements Serializable {
    private String name;                // 属性名称
    private String category;            // 属性分类
    private int searchRule;             // 能否解锁
    private boolean isRelated;         // 是否相关
    private int[] chooseMethod;        // 是否可选
    private int enterMethod;           // 输入规则
    private String[] chooseList;      // 选择列表
    private int sortIndex;              // 排序
}
