package com.example.JoyToyFactroy.Controller;

import com.example.JoyToyFactroy.Model.Contact;
import com.example.JoyToyFactroy.Repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/joytoyfactory")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    // Show contact form page
    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";  // contact.html template
    }

    // Handle contact form submission
    @PostMapping("/submitContact")
    public String submitContact(@ModelAttribute Contact contact) {
        contactRepository.save(contact);
        return "redirect:/joytoyfactory/contact?success";
    }

    // Show all submitted contacts
    @GetMapping("/viewContacts")
    public String showViewContactsPage(Model model) {
        model.addAttribute("contacts", contactRepository.findAll());
        return "view-contacts";  // view-contacts.html template
    }
}
