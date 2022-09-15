package cn.tedu.csmall.sever.Service.Impl;

import cn.tedu.csmall.sever.Exception.ServiceException;
import cn.tedu.csmall.sever.Mapper.BrandMapper;
import cn.tedu.csmall.sever.POJO.DTO.BrandAddNewDTO;
import cn.tedu.csmall.sever.POJO.Entity.Brand;
import cn.tedu.csmall.sever.Repo.IBrandRepository;
import cn.tedu.csmall.sever.Service.IBrandService;
import cn.tedu.csmall.sever.Web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrandServiceImpl implements IBrandService {
    @Autowired
    public IBrandRepository brandRepository;
    @Autowired
    public BrandMapper brandMapper;

    public BrandServiceImpl(){
        System.out.println("创建数据访问对象：BrandRepository");
    }

    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        String name = brandAddNewDTO.getName();
        int count = brandMapper.countByName(name);
        if (count > 0) {
            String Message = "添加失败，品牌名称已经存在";
            log.debug(Message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,Message);
        }
        // 创建实体Entity对象,需要将从前端获取的DTO对象转换成Entity对象
        Brand brand = new Brand();
        // 通过Spring提供的BeanUtils将brandAddNewDTO转换为brand
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        brand.setSales(0);
        brand.setPositiveCommentCount(0);
        brand.setCommentCount(0);
        brand.setEnable(1);
        int rows = brandMapper.insert(brand);
        if (rows != 1){
            String message = "插入失败，服务器忙！";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_INSERT,message);
        }
    }
}
