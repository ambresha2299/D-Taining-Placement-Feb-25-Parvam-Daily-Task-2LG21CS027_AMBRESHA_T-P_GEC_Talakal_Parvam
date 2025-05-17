package com.example.JoyToyFactroy.Repository;

import com.example.JoyToyFactroy.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
