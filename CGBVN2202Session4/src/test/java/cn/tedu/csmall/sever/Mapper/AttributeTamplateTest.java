package cn.tedu.csmall.sever.Mapper;

import cn.tedu.csmall.sever.POJO.Entity.AttributeTamplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AttributeTamplateTest {
    @Autowired
    AttributeTamplateMapper mapper;
    @Test
    public void insertTest(){
        AttributeTamplate at = new AttributeTamplate();
        String name = "黑米";
        String pinyin = "heimi";
        at.setName(name);
        at.setPinyin(pinyin);
        int row = mapper.insert(at);
        System.out.println(row);
    }
}
