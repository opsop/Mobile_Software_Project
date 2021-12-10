package com.course.ice;

public class Shoes {
    String brand;
    String shoes_name;
    int image_logo;
    int image_id1;
    int image_id2;
    String shoes_detail;
    String shoes_price;
    String shoes_url;
    public Shoes(String brand, int logo, int id1, int id2, String name, String detail, String price, String url) {
        this.brand = brand;
        this.image_logo = logo;
        this.image_id1 = id1;
        this.image_id2 = id2;
        this.shoes_name = name;
        this.shoes_detail = detail;
        this.shoes_price = price;
        this.shoes_url = url;
    }

    public String getBrand() { return brand; }

    public String getShoesName() {
        return shoes_name;
    }

    public int getImageLogo() { return image_logo; }

    public int getImageID1() {
        return image_id1;
    }

    public int getImageID2() { return image_id2; }

    public String getShoesDetail() {
        return shoes_detail;
    }

    public String getShoesPrice() {
        return shoes_price;
    }

    public String getShoesUrl() {
        return shoes_url;
    }
}
