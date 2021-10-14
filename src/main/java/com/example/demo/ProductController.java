package com.example.demo;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Date;

@CrossOrigin()
@RestController
public class ProductController {

    private ProductService service = new ProductService();

    @PutMapping("/products/create")
    public Product createProduct(@RequestBody CreateProduct createProduct) {
        return service.createProduct(createProduct.name, createProduct.description, createProduct.category, createProduct.price);
    }

    @GetMapping("/products/all")
    public Collection<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/products/single/{productName}")
    public Product getProduct(@PathVariable("productName") String productName, HttpServletResponse response) {
        Product product = service.getProduct(productName);
        if (product == null) {
            response.setStatus(404);
            return null;
        }

        return product;
    }

    @DeleteMapping("/products/delete/{productName}")
    public void deleteProduct(@PathVariable("productName") String productName, HttpServletResponse response) {
        if (!service.deleteProduct(productName))
            response.setStatus(404);

    }

    @PatchMapping("/products/update/{productName}")
    public Product updateProduct(
            @PathVariable("productName") String productName,
            @RequestBody UpdateProduct updateProduct,
            HttpServletResponse response) {

        if (!service.updateProduct(productName, updateProduct.description, updateProduct.category, updateProduct.price)) {
            response.setStatus(404);
            return null;
        }

        return service.getProduct(productName);
    }

    public static final class CreateProduct {
        public String name;
        public String description;
        public Category category;
        public double price;
    }

    public static final class UpdateProduct {
        public String description;
        public Category category;
        public double price;
    }
}
