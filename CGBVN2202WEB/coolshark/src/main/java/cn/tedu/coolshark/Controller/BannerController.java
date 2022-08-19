package cn.tedu.coolshark.Controller;

import cn.tedu.coolshark.Entity.Banner;
import cn.tedu.coolshark.Mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Value("${dirPath}")
    String lcoalPath;
    @Autowired
    BannerMapper mapper;
    @RequestMapping("select")
    public List<Banner> select(){
        return mapper.select();
    }

    @RequestMapping("delete")
    public void delete(int id){
        // 删除文件路径
        String url = mapper.selectById(id);
        // 得到完整的磁盘路径
        String dirPath = lcoalPath + "/"+url;
        // 创建文件对象并进行删除
        new File(dirPath).delete();
        mapper.deleteById(id);
    }

    @RequestMapping("insert")
    public void insert(@RequestBody Banner banner){
        mapper.insert(banner);
    }
}
