package com.example.SpringDBExample.repository;



import com.example.SpringDBExample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    //List<User> findAll(String lastName);
}
