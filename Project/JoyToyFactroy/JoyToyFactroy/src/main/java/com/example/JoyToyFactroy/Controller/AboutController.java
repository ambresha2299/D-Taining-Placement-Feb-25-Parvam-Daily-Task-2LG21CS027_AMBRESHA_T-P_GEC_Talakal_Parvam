package com.example.JoyToyFactroy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("pageTitle", "About Us - JoyToy Factory");
        // You can add more attributes if your about.html uses dynamic data
        return "about"; // This corresponds to templates/about.html in Thymeleaf
    }
}

