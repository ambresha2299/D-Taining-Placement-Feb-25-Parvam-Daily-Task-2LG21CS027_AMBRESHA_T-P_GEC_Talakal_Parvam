package com.example.JoyToyFactroy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String blogPage(Model model) {
        model.addAttribute("pageTitle", "Blog - JoyToy Factory");
        // You can add more attributes if your about.html uses dynamic data
        return "blog"; // This corresponds to templates/about.html in Thymeleaf
    }
}



