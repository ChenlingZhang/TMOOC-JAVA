package cn.tedu.csmall.sever.Repo.Impl;

import cn.tedu.csmall.sever.Repo.ICategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {

    public CategoryRepositoryImpl() {
        System.out.println("创建数据访问对象：CategoryRepositoryImpl");
    }

}
