package cn.tedu.csmall.sever.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class BeanConfig {
    @Bean
    public Date date(){
        System.out.println("BeanConfig.date()");
        return new Date();
    }
}
