package cn.tedu.coolshark.Controller;

import ch.qos.logback.core.util.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @Value("${dirPath}")
    private String localPath;

    @RequestMapping("upload")
    public String upload(MultipartFile picFile) throws IOException {
        System.out.println("picFile:" + picFile);
        //得到文件原始文件名 a.jpg
        String filename = picFile.getOriginalFilename();
        //得到文件后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));
        //得到一个文件名
        filename = UUID.randomUUID()+suffix;
        //准备保存文件的路径
        File dirFile = new File(localPath);
        if (!dirFile.exists()){
            dirFile.mkdirs(); // 创建文件夹
        }
        String filePath = localPath+"/"+filename;
        picFile.transferTo(new File(filePath));

        System.out.println("文件保存完成");
        return filename ;
    }

    @RequestMapping("remove")
    public void remove(String name){
        String filePath = localPath+"/"+name;
        System.out.println(filePath);
        new File(filePath).delete(); // 删除文件
    }
}
