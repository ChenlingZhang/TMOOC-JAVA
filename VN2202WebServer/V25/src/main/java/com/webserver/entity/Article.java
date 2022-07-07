package com.webserver.entity;

import java.io.Serializable;

/**
 * @author 老安
 * @data 2022/6/13 20:00
 * 文章信息
 */
public class Article implements Serializable {
    static final long serialVersionUID = 42L;
    private String title;
    private String author;
    private String content;
    //全参构造,get,set,toString
    public Article(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
