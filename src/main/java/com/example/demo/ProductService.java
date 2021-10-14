package com.example.demo;

import java.util.Collection;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public Product createProduct(String name, String description, Category category, double price) {
        Product product = new Product(name, description, category, price);

        repository.addProduct(product);

        return product;
    }

    public Collection<Product> getAllProducts() {
        return repository.getProducts();
    }

    public Product getProduct(String name) {
        return repository.getProduct(name);
    }

    public boolean deleteProduct(String name) {
        if (repository.getProduct(name) == null)
            return false;

        repository.removeProduct(name);
        return true;
    }

    public boolean updateProduct(String name, String description, Category category, double price) {
        Product product = repository.getProduct(name);
        if (product == null)
            return false;


        product.setPrice(price);
        product.setDescription(description);
        product.setCategory(category);

        return true;
    }

}
