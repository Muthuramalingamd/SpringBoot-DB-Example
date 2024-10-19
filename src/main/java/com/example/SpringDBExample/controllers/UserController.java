package com.example.SpringDBExample.controllers;


import com.example.SpringDBExample.model.User;
import com.example.SpringDBExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user")
    public List<User> getUser(){
       return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserByid(@PathVariable Integer id){
        return userRepository.findById(id);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable
                                      Integer id){
        if(userRepository.existsById(id)){
            userRepository.deleteAllById(Collections.singleton(id));
            ResponseEntity response = new ResponseEntity<>("Deleted SuccessFully", HttpStatusCode.valueOf(200));
            return response;
        }else{
            ResponseEntity response = new ResponseEntity<>("User is not found", HttpStatusCode.valueOf(500));
            return response;
        }

    }
    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody User user){
        System.out.println("hii"+user.toString());
        User userObj = new User();
        userObj.setFirstName(user.getFirstName());
        userObj.setLastName(user.getLastName());
        User resp = userRepository.save(userObj);
        ResponseEntity response = new ResponseEntity<>(resp, HttpStatusCode.valueOf(200));
        return response;
    }

    @PostMapping("/userupdate/{id}")
    public ResponseEntity updateUser(@RequestBody User user,@PathVariable Integer id){
        System.out.println("hii"+user.toString());

        User userObj = userRepository.getReferenceById(id);

        userObj.setFirstName(user.getFirstName());
        User resp = userRepository.save(userObj);
        ResponseEntity response = new ResponseEntity<>(resp, HttpStatusCode.valueOf(200));
        return response;
    }
}
