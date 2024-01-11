package com.accolite.codelyzer.serviceimpl;

import com.accolite.codelyzer.model.User;
import com.accolite.codelyzer.repository.UserRepo;
import com.accolite.codelyzer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
