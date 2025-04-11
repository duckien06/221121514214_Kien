package com.example.a221121514214_LeDucKien.model;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("id")
    private String id;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("originalTitle")
    private String originalTitle;
    @SerializedName("description")
    private String description;
    @SerializedName("primaryImage")
    private String  primaryImage;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getDate(){
        return releaseDate;
    }

    public String getTitle(){
        return originalTitle;
    }

    public void setTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }

    public String getContent(){
        return description;
    }

    public void setContent(String description){
        this.description = description;
    }

    public String getImage(){
        return primaryImage;
    }

    public void setImage(String primaryImage){
        this.primaryImage = primaryImage;
    }

}

