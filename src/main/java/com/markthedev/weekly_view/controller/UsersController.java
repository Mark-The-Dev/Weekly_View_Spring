package com.markthedev.weekly_view.controller;

import com.markthedev.weekly_view.exception.ResourceNotFoundException;
import com.markthedev.weekly_view.model.Users;
import com.markthedev.weekly_view.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    // get user
    @GetMapping("users")
    public List<Users> getAllUsers(){
        return this.usersRepository.findAll();
    }

    // get user by id

    @GetMapping("users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable(value="id") Long userId)
        throws ResourceNotFoundException {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by this id: " + userId));
        return ResponseEntity.ok().body(user);


    }
    // save user

    // update user

    // delete user
}
