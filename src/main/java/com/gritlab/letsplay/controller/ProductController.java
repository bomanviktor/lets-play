package com.gritlab.letsplay.controller;

import com.gritlab.letsplay.model.Product;

import com.gritlab.letsplay.model.ProductUpdate;
import com.gritlab.letsplay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private @Autowired ProductService service;


    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody @Validated ProductUpdate product) {
        String id = "FakeIDForNow";
        Product newProduct = service.createProduct(id, product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = service.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        Product product = service.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<?> getProductByProductName(@PathVariable String productName) {
        Product product = service.getProductByProductName(productName);
        if (product == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @PutMapping("/id/{id}/update")
    public ResponseEntity<?> updateProductById(@PathVariable String id, @RequestBody ProductUpdate update) {
        Product product = service.updateProductById(id, update);
        if (product == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

}
