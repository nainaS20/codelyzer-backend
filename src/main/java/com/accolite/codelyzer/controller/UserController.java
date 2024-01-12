package com.accolite.codelyzer.controller;

import com.accolite.codelyzer.model.Group;
import com.accolite.codelyzer.model.Question;
import com.accolite.codelyzer.model.User;
import com.accolite.codelyzer.requestbody.QuestionBody;
import com.accolite.codelyzer.requestbody.UserBody;
import com.accolite.codelyzer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PostMapping("/users/createUser")
    public String createUser(@RequestBody UserBody body) {
        User user = new User();
        user.setEmail(body.getEmail());
        user.setName(body.getName());
        userService.createUser(user);
        return "user created";
    }
    @PostMapping("/users/createTag/{tagName}")
    public String createTag(@PathVariable String tagName) {
        userService.createTag(tagName);
        return "tag created";
    }
    @PostMapping("/users/createQuestion")
    public String createQuestion(@RequestBody QuestionBody questionBody) {
        userService.createQuestion(questionBody);
        return "question created";
    }
}
