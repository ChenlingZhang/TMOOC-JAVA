package cn.tedu.csmall.sever;

import cn.tedu.csmall.sever.Controller.BrandController;
import cn.tedu.csmall.sever.Repo.IBrandRepository;
import cn.tedu.csmall.sever.Service.IBrandService;
import cn.tedu.csmall.sever.Service.Impl.BrandServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandTest {
    @Autowired
    BrandController brandController;
    @Autowired
    IBrandService brandService;
    @Autowired
    BrandServiceImpl brandServiceImpl;

    @Autowired
    IBrandRepository brandRepository;

    @Test
    public void testBrandControllor(){
        System.out.println("控制器："  + brandController);
        System.out.println("业务层" + brandService);
        System.out.println("业务层" + brandController.brandService);
        System.out.println("数据访问层："+brandRepository);
        System.out.println("数据访问层："+brandServiceImpl.brandRepository);
    }
}
