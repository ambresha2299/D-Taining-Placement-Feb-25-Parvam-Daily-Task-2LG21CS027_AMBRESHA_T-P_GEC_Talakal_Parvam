package com.example.JoyToyFactroy.Controller;

import com.example.JoyToyFactroy.Model.User;
import com.example.JoyToyFactroy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ========== LOGIN SECTION ==========

    // Show login page for users
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html
    }
 // Process login for users
    @PostMapping("/login")
    public String processLogin(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("User login successful: " + email);
            return "redirect:/shop"; // Redirect to shop page
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; 
        }// Show login page again with error
        }

    // API-style login (optional)
    @PostMapping("/user-login")
    @ResponseBody
    public String loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return "Login successful! Welcome, " + user.getEmail();
        } else {
            return "Login failed: Invalid email or password!";
        }
    }

    // ========== REGISTER SECTION ==========

    // Show register page for users
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register"; // register.html
    }

    // Register normal user and redirect to login
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/login"; // Redirect to user login
    }
     @GetMapping("/contact")
     public String showContactPage() {
    return "contact"; // This assumes contact.html is in templates folder
}
}

