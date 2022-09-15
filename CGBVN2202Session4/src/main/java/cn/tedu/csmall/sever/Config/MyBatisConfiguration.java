package cn.tedu.csmall.sever.Config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.csmall.sever.Mapper")
public class MyBatisConfiguration {
}
