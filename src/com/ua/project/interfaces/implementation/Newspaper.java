package com.ua.project.interfaces.implementation;

import com.ua.project.interfaces.HasTitle;
import com.ua.project.interfaces.Printable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Newspaper implements Printable, HasTitle {
    private String title;
    private Date publishDate;
    private List<String> headlinesList;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public Newspaper(String title, Date publishDate, List<String> headlinesList) {
        this.title = title;
        this.publishDate = publishDate;
        this.headlinesList = headlinesList;
    }
    public  Newspaper() {
        this("PaperTitle", new Date(), new ArrayList<String>());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public List<String> getHeadlinesList() {
        return headlinesList;
    }

    public void setHeadlinesList(List<String> headlinesList) {
        this.headlinesList = headlinesList;
    }

    @Override
    public void print() {
        System.out.println(" Printing Newspaper \"" + this.title + "\"...");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(" Newspaper Title: " + this.getTitle() + "\n Publish Date: " +  DATE_FORMAT.format(this.getPublishDate()) + "\n Headlines List:");

        headlinesList.forEach((value) -> {
            builder.append("\n  - ").append(value);
        });

        return builder.toString();
    }
}
