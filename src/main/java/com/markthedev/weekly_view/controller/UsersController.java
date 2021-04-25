package com.markthedev.weekly_view.controller;

import com.markthedev.weekly_view.exception.ResourceNotFoundException;
import com.markthedev.weekly_view.model.Users;
import com.markthedev.weekly_view.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PostMapping("users")
    public Users createUser(@RequestBody Users user){
        return this.usersRepository.save(user);

    }

    // update user
    @PatchMapping("users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value ="id") Long userId, @Valid @RequestBody Users userDetails) throws ResourceNotFoundException{
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by this id: " + userId));
        user.setEmail(userDetails.getEmail());
        user.setFirst_name(userDetails.getFirst_name());
        user.setLast_name(userDetails.getLast_name());

        return ResponseEntity.ok(this.usersRepository.save(user));
    }

    @DeleteMapping("users/{id}")
    // delete user
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException{
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found by this id: " + userId));
        this.usersRepository.delete(user);

        Map<String, Boolean> responce = new HashMap<>();
        responce.put("deleted", Boolean.TRUE);

        return responce;

    }
}
