package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class Article {

    private String id;
    private String title;
    private String imgPath;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM—dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private String publishDate;
    private String guru_id;

    public Article() {
    }

    public Article(String id, String title, String imgPath, String content, String publishDate, String guru_id) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.publishDate = publishDate;
        this.guru_id = guru_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(String guru_id) {
        this.guru_id = guru_id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", content='" + content + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", guru_id='" + guru_id + '\'' +
                '}';
    }
}
