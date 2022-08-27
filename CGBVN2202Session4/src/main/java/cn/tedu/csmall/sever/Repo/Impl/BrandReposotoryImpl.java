package cn.tedu.csmall.sever.Repo.Impl;

import cn.tedu.csmall.sever.Repo.IBrandRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BrandReposotoryImpl implements IBrandRepository {
    public BrandReposotoryImpl(){
        System.out.println("创建数据访问对象：BrandRepositoryImpl");
    }
}
