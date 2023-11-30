package com.gritlab.letsplay.service;

import java.util.List;
import com.gritlab.letsplay.model.Product;
import com.gritlab.letsplay.model.ProductUpdate;
import com.gritlab.letsplay.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Autowired
    ProductRepository repository;
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByProductName(String productName) {
        return repository.findByName(productName).orElse(null);
    }

    public Product createProduct(String userId, ProductUpdate product) {
        // TODO: Validate these fields
        Product newProduct = new Product(product.getName(), product.getDescription(), product.getPrice(), userId);
        repository.save(newProduct);

        return repository
                .findByName(product.getName())
                .orElse(null);
    }

    public Product updateProductById(String id, ProductUpdate productUpdate) {
        Product productToUpdate = repository.findById(id).orElse(null);
        if (productToUpdate == null) {
            return null;
        }

        String name = productUpdate.getName();
        if (name != null) {
            productToUpdate.setName(name);
        }

        String description = productUpdate.getDescription();
        if (description != null) {
            productToUpdate.setDescription(description);
        }

        Double price = productUpdate.getPrice();
        if (price != null) {
            productToUpdate.setPrice(price);
        }
        repository.save(productToUpdate);
        return productToUpdate;
    }
}
