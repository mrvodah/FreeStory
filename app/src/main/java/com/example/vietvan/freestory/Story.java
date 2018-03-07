package com.example.vietvan.freestory;

import java.io.Serializable;

/**
 * Created by VietVan on 04/03/2018.
 */

public class Story implements Serializable{
    int id;
    String image;
    String title;
    String description;
    String content;
    String author;
    int bookmark;

    public Story(int id, String image, String title, String description, String content, String author, int bookmark) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "Story{" +
                "title='" + title + '\'' +
                '}';
    }
}
