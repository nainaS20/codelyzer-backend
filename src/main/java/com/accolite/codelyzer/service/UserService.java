package com.accolite.codelyzer.service;

import com.accolite.codelyzer.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    List<User> getAllUsers();
}
