package com.example.SpringDBExample.Config;


import com.example.SpringDBExample.model.User;
import com.example.SpringDBExample.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserDBload implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("John", "Doe"));
        userRepository.save(new User("Jane", "Doe"));
        userRepository.save(new User("Alice", "Smith"));
        userRepository.save(new User("Bob", "Brown"));
    }
}
