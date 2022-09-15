package cn.tedu.csmall.sever.Mapper;

import cn.tedu.csmall.sever.POJO.Entity.Brand;
import cn.tedu.csmall.sever.POJO.VO.BrandDetailVO;
import cn.tedu.csmall.sever.POJO.VO.BrandListItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品持久层
 */
@Repository
public interface BrandMapper {
    /**
     * @param brand 品牌数据
     * @return 受影响的行数，成功插入时将返回1
     */
    int insert(Brand brand);

    /**
     *
     * @param id
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 批量根据id删除品牌
     * @param id 多个品牌id
     * @return 受影响的行数
     * Long... 为不定参数列表
     */
    int deleteByIds(Long... id);

    /**
     *
     * @param id 品牌的id
     * @param name 品牌的名称
     * @return 受影响的行数
     */

    // 在JVM底层逻辑中，不会将parameter的局部变量进行保存，所以会导致报错
    // 在阿里云下创建的Spring boot脚手架项目没有对其进行修缮，所以需要当在两个或以上参数时候需要加入@Param注解保留参数名称
    int updateNameById(@Param("id") Long id, @Param("name") String name);

    /**
     * 修改品牌数据
     * @param brand 品牌数据
     * @return 受影响的行数
     */
    int updateById(Brand brand);

    /**
     * 统计品牌表中的数据的数量
     * @return 受影响的行数
     */
    int count();

    /**
     * 根据id 查询所有的字段
     * @param id
     * @return
     */
    BrandDetailVO getById(Long id);

    /**
     * 获取表中所有的数据
     * @return List
     */
    List<BrandListItemVO> getAllBrands();

    /**
     * 根据品牌名称统计该名称对应的品牌数据数量
     * @param name
     * @return
     */
    int countByName(String name);
}
