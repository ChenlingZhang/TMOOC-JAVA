package cn.tedu.csmall.sever.Service.Impl;

import cn.tedu.csmall.sever.Repo.ICategoryRepository;
import cn.tedu.csmall.sever.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype") //默认情况下是单例模式即每次取到的对象都是同一个，若需要定制化需要配置prototype原形模式
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    public ICategoryRepository categoryRepository;

    public CategoryServiceImpl(){
        System.out.println("Create Service Layer: CategoryService");
    }
}
