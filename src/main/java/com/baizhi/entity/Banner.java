package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Banner {
    private String id;
    private String title;
    private String imgPath;
    private String descend;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date date;

    public Banner() {
    }

    public Banner(String id, String title, String imgPath, String descend, String status, Date date) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.descend = descend;
        this.status = status;
        this.date = date;
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

    public String getDescend() {
        return descend;
    }

    public void setDescend(String descend) {
        this.descend = descend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", descend='" + descend + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
