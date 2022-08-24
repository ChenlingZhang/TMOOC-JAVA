package cn.tedu.csmall.sever;

import cn.tedu.csmall.sever.Controller.CategoryController;
import cn.tedu.csmall.sever.Service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class ApplicationTests {
    @Autowired
    public AnnotationConfigApplicationContext annotationContainer;

    @Test
    void contextLoads() {
        CategoryController categoryController = annotationContainer.getBean(CategoryController.class);
        System.out.println(categoryController);

        CategoryService service = annotationContainer.getBean(CategoryService.class);
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
        CategoryService service1 = annotationContainer.getBean(CategoryService.class);
        CategoryService service2 = annotationContainer.getBean(CategoryService.class);
        CategoryService service3 = annotationContainer.getBean(CategoryService.class);
        System.out.println(service1);
        System.out.println(service2);
        System.out.println(service3);
    }



}
