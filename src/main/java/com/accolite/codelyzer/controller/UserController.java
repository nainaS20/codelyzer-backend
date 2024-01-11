package com.accolite.codelyzer.controller;

import com.accolite.codelyzer.model.User;
import com.accolite.codelyzer.requestbody.UserBody;
import com.accolite.codelyzer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
//    @GetMapping("/users")
//    public String listUsers(Model model) {
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "users/list";
//    }
    @PostMapping("/users/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/users/create")
    public String createUser(@RequestBody UserBody body) {
        User user = new User();
        user.setEmail(body.getEmail());
        user.setName(body.getName());
        userService.createUser(user);
        return "user created";
    }
}
