package com.dreamjournal.backendapi.controller;

import com.dreamjournal.backendapi.entity.User;
import com.dreamjournal.backendapi.model.response.ApiResponse;
import com.dreamjournal.backendapi.repository.UserRepository;
import com.dreamjournal.backendapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping(path = "/register")
    public @ResponseBody
    ResponseEntity register(@RequestBody User user) {
        ApiResponse validateUser = userService.validateUser(user);

        if(!validateUser.getSuccess()) {
            return ResponseEntity.ok(new ApiResponse(false, validateUser.getMessage()));
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(new ApiResponse(true, "User Added!", user));
    }
}
