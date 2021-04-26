package com.markthedev.weekly_view.controller;

import com.markthedev.weekly_view.exception.ResourceNotFoundException;
import com.markthedev.weekly_view.model.User;
import com.markthedev.weekly_view.repository.UserRepository;
import com.markthedev.weekly_view.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@AllArgsConstructor
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @PostMapping("/sign-up")
    User signUp(User user) {

        userService.signUpUser(user);

        return user;
    }
}
