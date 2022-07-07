package com.webserver.controller;

import com.webserver.annotation.Controller;
import com.webserver.annotation.RequestMapping;
import com.webserver.core.ClientHandler;
import com.webserver.entity.Article;
import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.annotation.Retention;
import java.net.URISyntaxException;

/**
 * @author 老安
 * @data 2022/6/13 19:56
 */
@Controller
public class ArticleController {
    /*
     * 该目录适用于存储所有文章信息的
     */
    private static File ARTICLE_DIR = new File("./articles");
    private static File staticDir;

    static {
        if (!ARTICLE_DIR.exists()) {//判断users目录如果不存在
            ARTICLE_DIR.mkdirs();//创建users目录
        }
        try {
            staticDir = new File(
                    ClientHandler.class.getClassLoader().getResource(
                            "./static"
                    ).toURI()
            );
        } catch (URISyntaxException e) {//静态代码块中有异常只能自己处理
            e.printStackTrace();
        }
    }
    @RequestMapping("/myweb/writeArticle")
    public void writeArticle(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameters("title");
        String author = request.getParameters("author");
        String content = request.getParameters("content");
        if (title == null || author == null || content == null) {
            //跳转到错误的页面
            File file = new File(staticDir, "/myweb/writeArticle_info_error.html");
            response.setContentFile(file);
            return;
        }
        File articleFile = new File(ARTICLE_DIR, title + ".obj");
        try (
                FileOutputStream fos = new FileOutputStream(articleFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            Article article = new Article(title, author, content);
            oos.writeObject(article);
            File file = new File(staticDir, "/myweb/writeArticle_success.html");
            response.setContentFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
