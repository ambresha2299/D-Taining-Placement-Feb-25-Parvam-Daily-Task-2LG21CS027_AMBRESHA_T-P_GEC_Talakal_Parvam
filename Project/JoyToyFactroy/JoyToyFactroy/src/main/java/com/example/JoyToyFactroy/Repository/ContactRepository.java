package com.example.JoyToyFactroy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.JoyToyFactroy.Model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
