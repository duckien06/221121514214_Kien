package com.example.a221121514214_LeDucKien.model;

public class ContactModel_Advenced {
    private String name;
    private String phone;
    private int image;

    public ContactModel_Advenced(String name, String phone, int image){
        this.name = name;
        this.phone = phone;
        this.image = image;
    }

    public String getName1(){
        return name;
    }

    public String getPhone1(){
        return phone;
    }

    public int getImage1(){
        return image;
    }
}
