package com.example.JoyToyFactroy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String indexPage(Model model) {
        model.addAttribute("pageTitle", "Index - JoyToy Factory");
        // You can add more attributes if your about.html uses dynamic data
        return "index"; // This corresponds to templates/about.html in Thymeleaf
    }
}

