package com.myapp.shopeeng;

public class CategoryModel {
    private String name;
    private int imageResId;

    public CategoryModel(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
