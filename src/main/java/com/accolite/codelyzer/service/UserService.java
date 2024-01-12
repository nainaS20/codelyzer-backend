package com.accolite.codelyzer.service;

import com.accolite.codelyzer.model.Question;
import com.accolite.codelyzer.model.Tag;
import com.accolite.codelyzer.model.User;
import com.accolite.codelyzer.requestbody.QuestionBody;

import java.util.List;

public interface UserService {
    void createUser(User user);
    void createTag(String tagName);
    void createQuestion(QuestionBody questionBody);
    List<User> getAllUsers();
}
