package com.example.JoyToyFactroy.Controller;

import com.example.JoyToyFactroy.Service.ProductService;
import com.example.JoyToyFactroy.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/shop")
    public String showProductsToClient(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "shop"; // Renders shop.html
    }
}
