package com.example.week_8;

public class modelClass {
    String searchItemName;
    String searchItemNum;
    String searchDetail;
    int img;

    public String getSearchDetail() {
        return searchDetail;
    }
    public void setSearchDetail(String searchDetail) { this.searchDetail = searchDetail; }

    public String getSearchItemName() {
        return searchItemName;
    }
    public void setSearchItemName(String searchItemName) {
        this.searchItemName = searchItemName;
    }
    public String getSearchItemNum() {
        return searchItemNum;
    }

    public void setSearchItemNum(String searchItemNum) {
        this.searchItemNum = searchItemNum;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
