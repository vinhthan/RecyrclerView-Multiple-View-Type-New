package com.example.recyrclerviewmultipleviewtype;

public class User {
    private int image;
    private String name;
    private boolean isType;

    public User(int image, String name, boolean isType) {
        this.image = image;
        this.name = name;
        this.isType = isType;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isType() {
        return isType;
    }

    public void setType(boolean type) {
        isType = type;
    }
}
