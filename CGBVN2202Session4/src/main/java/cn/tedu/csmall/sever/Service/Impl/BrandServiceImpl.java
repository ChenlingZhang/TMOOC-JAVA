package cn.tedu.csmall.sever.Service.Impl;

import cn.tedu.csmall.sever.Repo.IBrandRepository;
import cn.tedu.csmall.sever.Service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    public IBrandRepository brandRepository;

    public BrandServiceImpl(){
        System.out.println("创建数据访问对象：BrandRepository");
    }

}
