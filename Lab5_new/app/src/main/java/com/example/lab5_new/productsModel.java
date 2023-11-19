package com.example.lab5_new;

import java.util.List;

public class productsModel {
    List<SPModel> products;


    public productsModel(List<SPModel> products) {
        this.products = products;
    }

    public List<SPModel> getProducts() {
        return products;
    }

    public void setProducts(List<SPModel> products) {
        this.products = products;
    }
}
