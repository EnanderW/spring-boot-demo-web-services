package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getName().toLowerCase(), product);
    }

    public Collection<Product> getProducts() {
        return products.values();
    }

    public void removeProduct(String name) {
        products.remove(name.toLowerCase());
    }

    public Product getProduct(String name) {
        return products.get(name.toLowerCase());
    }

}
