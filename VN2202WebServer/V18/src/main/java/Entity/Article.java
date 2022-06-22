package Entity;

import java.io.Serializable;

public class Article implements Serializable {
    static final long serialVersionUID = 42L;
    private String title;
    private String author;
    private String article;

    public Article(String title, String author, String article) {
        this.title = title;
        this.author = author;
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", article='" + article + '\'' +
                '}';
    }
}
