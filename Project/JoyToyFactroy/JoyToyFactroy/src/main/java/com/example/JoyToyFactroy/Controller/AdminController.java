package com.example.JoyToyFactroy.Controller;

import com.example.JoyToyFactroy.Model.Admin;
import com.example.JoyToyFactroy.Model.Product;
import com.example.JoyToyFactroy.Repository.AdminRepository;
import com.example.JoyToyFactroy.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Controller
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private ProductRepository productRepo;

    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/product-images";

    // Serve Registration Form Page
    @GetMapping("/registerasadmin")
    public String showRegisterForm() {
        return "registerasadmin";  // your registerasadmin.html template
    }

    // Handle Admin Registration POST
    @PostMapping("/registerasadmin")
    public String registerAdmin(@RequestParam String email,
                                @RequestParam String password,
                                Model model) {
        if (adminRepo.findByEmail(email) != null) {
            model.addAttribute("error", "Admin already exists");
            return "registerasadmin";
        }

        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);
        adminRepo.save(admin);

        return "redirect:/login1";
    }

    // Show Login Page
    @GetMapping("/login1")
    public String showLoginPage() {
        return "login1";
    }
     @GetMapping("/loginadmin")
    public String showLoginAdminPage() {
        return "loginadmin";
    }

    // Handle Admin Login
    @PostMapping("/loginadmin")
    public String loginAdmin(@RequestParam String email,
                             @RequestParam String password,
                             Model model) {
        Admin admin = adminRepo.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            return "redirect:/add-product";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login1";
        }
    }

    // Show Add Product Form
    @GetMapping("/add-product")
    public String showAddProductPage() {
        return "add-product";
    }

    // Handle Product Submission with Image Upload
    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product,
                             @RequestParam("imageFile") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());
            product.setImageUrl("/product-images/" + fileName);
        }

        productRepo.save(product);
        return "redirect:/admin-products";
    }

    // Show Admin Product List Page
    @GetMapping("/admin-products")
    public String showAdminProductsPage(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "admin-products";
    }
}
