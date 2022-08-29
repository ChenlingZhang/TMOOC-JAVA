package cn.tedu.csmall.sever;

import cn.tedu.csmall.sever.Controller.CategoryController;
import cn.tedu.csmall.sever.Repo.ICategoryRepository;
import cn.tedu.csmall.sever.Service.Impl.CategoryServiceImpl;
import cn.tedu.csmall.sever.Service.ICategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class ApplicationTests {
    // Spring Boot 对应的容器
    //@Autowired
    //public AnnotationConfigApplicationContext annotationContainer;

    // Spring MVC 对应的容器
    //@Autowired
    //public GenericWebApplicationContext annotationContainer;

    @Autowired
    public ApplicationContext annotationContainer;

    @Test
    void contextLoads() {
        CategoryController categoryController = annotationContainer.getBean(CategoryController.class);
        System.out.println(categoryController);

        ICategoryService service = annotationContainer.getBean(CategoryServiceImpl.class);
        System.out.println(service);

        Date date = annotationContainer.getBean(Date.class);
        System.out.println(date);

        LocalDateTime ldt = annotationContainer.getBean(LocalDateTime.class);
        System.out.println(ldt);

        Calendar calendar = annotationContainer.getBean(Calendar.class);
        System.out.println(calendar);
    }

    @Test
    public void testGetBensSingleton(){
        ICategoryService service1 = annotationContainer.getBean(CategoryServiceImpl.class);
        ICategoryService service2 = annotationContainer.getBean(CategoryServiceImpl.class);
        ICategoryService service3 = annotationContainer.getBean(CategoryServiceImpl.class);
        System.out.println(service1);
        System.out.println(service2);
        System.out.println(service3);
    }
    @Autowired
    CategoryController categoryController;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ICategoryRepository categoryRepository;

    @Test
    public void testAutoWired(){
        System.out.println(categoryController.categoryService);
        System.out.println(categoryController);
        System.out.println(categoryService);
        System.out.println(categoryRepository);
        //System.out.println(categoryController.categoryService.categoryRepository);
    }
}
