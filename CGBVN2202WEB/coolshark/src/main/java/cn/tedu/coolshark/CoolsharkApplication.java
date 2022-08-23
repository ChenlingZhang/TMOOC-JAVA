package cn.tedu.coolshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ServletComponentScan
@SpringBootApplication
public class CoolsharkApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(CoolsharkApplication.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 表示允许所有路径
                .allowedOriginPatterns("*") // 允许任何方法源
                .allowedMethods("*") // 允许所有请求方法
                .allowedHeaders("*") // 允许任何请求头信息
                .allowCredentials(true)
                .maxAge(3600);

    }
}
