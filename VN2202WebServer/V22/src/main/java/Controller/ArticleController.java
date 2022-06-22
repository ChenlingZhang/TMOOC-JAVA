package Controller;

import Entity.Article;
import annotation.Controller;
import annotation.RequestMapping;
import core.ClientHandle;
import http.HTTPServletRequest;
import http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;

@Controller
public class ArticleController {
    private static File ARTICLE_DIR = new File("./articles");
    private static File STATIC_DIR;
    static {
        if (!ARTICLE_DIR.exists()) {
            ARTICLE_DIR.mkdirs(); // 创建users目录
        }
        try{
            STATIC_DIR = new File(ClientHandle.class.getClassLoader().getResource("./static").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/MyWeb/writeArticle")
    public void writeArticle(HTTPServletRequest request, HttpServletResponse response){
        String title = request.getParameters("title");
        String author = request.getParameters("author");
        String article = request.getParameters("article");

        if (title == null || author == null || article == null){
            File file = new File(STATIC_DIR,"/MyWeb/writeArticle_info_error.html");
            response.setContentFile(file);
            return;
        }
        File file = new File(ARTICLE_DIR, title+".obj");
        try(
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                )
        {
            if (!file.exists()){
                Article ar = new Article(title,author,article);
                oos.writeObject(ar);
                File articleFile = new File(STATIC_DIR,"/MyWeb/writeArticle_success.html");
                response.setContentFile(articleFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
