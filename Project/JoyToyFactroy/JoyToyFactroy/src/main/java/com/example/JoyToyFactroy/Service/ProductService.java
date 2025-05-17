package com.example.JoyToyFactroy.Service;

import java.util.List;

import com.example.JoyToyFactroy.Model.Product;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
}