package com.example.lab5_new;

public class SanPham {

    private String _id;
    private String nameproduct;
    private String price;
    private String image;

    private String description;

    public SanPham(String nameproduct, String price, String image, String description) {

        this.nameproduct = nameproduct;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public void SanPhamxoa(String _id) {
        this._id = _id;
        
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
