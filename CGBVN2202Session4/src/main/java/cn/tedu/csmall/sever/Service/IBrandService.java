package cn.tedu.csmall.sever.Service;

import cn.tedu.csmall.sever.POJO.DTO.BrandAddNewDTO;

public interface IBrandService {
    /**
     * 新增品牌功能
     * @param brandAddNewDTO 需要创建的品牌数据
     */
    void addNew(BrandAddNewDTO brandAddNewDTO);
}
