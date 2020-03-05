package com.izax.devs.wrap.Items;

/**
 * Created by Aws on 28/01/2018.
 */

public class Book {

    private String Id;
    private String Title;
    private String Category ;
    private String Description ;
    private String Thumbnail ;

    public Book() {
    }

    public Book(String id, String title, String category, String description, String thumbnail) {
        Id = id;
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
    }

    public String getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }
}
