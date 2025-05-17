package com.example.JoyToyFactroy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JoyToyFactroy.Model.Contact;
import com.example.JoyToyFactroy.Repository.ContactRepository;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void saveMessage(Contact contact) {
        // This saves the contact; already done in controller, but keeps service logic here
        contactRepository.save(contact);
    }
}