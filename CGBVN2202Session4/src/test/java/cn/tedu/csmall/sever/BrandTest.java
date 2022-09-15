package cn.tedu.csmall.sever;

import cn.tedu.csmall.sever.Controller.BrandController;
import cn.tedu.csmall.sever.Mapper.BrandMapper;
import cn.tedu.csmall.sever.POJO.DTO.BrandAddNewDTO;
import cn.tedu.csmall.sever.POJO.Entity.Brand;
import cn.tedu.csmall.sever.POJO.VO.BrandDetailVO;
import cn.tedu.csmall.sever.POJO.VO.BrandListItemVO;
import cn.tedu.csmall.sever.Repo.IBrandRepository;
import cn.tedu.csmall.sever.Service.IBrandService;
import cn.tedu.csmall.sever.Service.Impl.BrandServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Slf4j
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
        //System.out.println("业务层" + brandController.brandService);
        System.out.println("数据访问层："+brandRepository);
        System.out.println("数据访问层："+brandServiceImpl.brandRepository);
    }
    @Autowired
    DataSource dataSource;
    @Test
    public void testMysqlConnection() throws SQLException {
        dataSource.getConnection();
        System.out.println("properites配置成功！");
    }
    @Autowired
    BrandMapper mapper;
    @Test
    public void testBrandInsert() {
        Brand brand = new Brand();
        brand.setName("ROG");
        int row = mapper.insert(brand);
        log.info("受影响的行数:{},id:{},name:{}",row,brand.getId(),brand.getName());
    }

    @Test
    public void testBrandDelete(){
        System.out.println("受影响的行数字" + mapper.deleteById(5L));
    }

    @Test
    public void testBrandUpdate(){
        int row = mapper.updateNameById(4L,"OPPO");
        System.out.println("受影响的行数：" + row);
    }

    @Test
    public void testBrandDeletes(){
        int row = mapper.deleteByIds(6L,7L,8L,9L,10L,11L);
        System.out.println("受影响的行数：" + row);
    }

    @Test
    public void testBrandUpdateById(){
        Long id = 4L;
        String name = "黑鲨";
        String pinyin = "heisha";
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(name);
        brand.setPinyin(pinyin);
        int row = mapper.updateById(brand);
        System.out.println("受影响的行数：" + row);
    }

    @Test
    public void testBrandCount(){
        int row = mapper.count();
        System.out.println("一共有：" + row + " 条数据");
    }

    @Test
    public void testBrandDetailVoGet(){
        BrandDetailVO bvo = mapper.getById(2L);
        System.out.println(bvo.toString());
        log.info(bvo.toString());
    }

    @Test
    public void testBrandListItem(){
        List<BrandListItemVO> list = mapper.getAllBrands();
        list.forEach(brandListItemVO -> System.out.println(brandListItemVO.toString()));
    }

    @Test
    public void testLogLevel(){
        log.trace("trace log output");
        log.debug("debug log output");
        log.info("info log output");
        log.warn("warn log output");
        log.error("error log output");
    }

    @Test
    public void testBrandServiceImplAdd(){
        BrandAddNewDTO dto = new BrandAddNewDTO();
        dto.setName("test1");
        dto.setPingyin("test1");
        BrandServiceImpl service = new BrandServiceImpl();
        service.addNew(dto);
    }

    @Test
    public void testBrandCountByName(){
        int count = mapper.countByName("华为");
        log.info("查询到的行数: " + count);
    }
}
