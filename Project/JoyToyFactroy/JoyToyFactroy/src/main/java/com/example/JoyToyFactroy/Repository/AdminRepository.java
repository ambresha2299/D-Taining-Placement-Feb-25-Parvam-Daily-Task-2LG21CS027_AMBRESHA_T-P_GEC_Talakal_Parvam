package com.example.JoyToyFactroy.Repository;

import com.example.JoyToyFactroy.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}
