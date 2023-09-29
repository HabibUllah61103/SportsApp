package com.example.week_8;

public class Search_item {
    private String Search_name;
    private int Image;

    public Search_item(String search_name, int image) {
        this.Search_name = search_name;
        this.Image = image;
    }

    public String getSearch_name(){
        return Search_name;
    }
    public int getImage() {
        return Image;
    }
}
