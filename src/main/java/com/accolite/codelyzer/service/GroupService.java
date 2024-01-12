package com.accolite.codelyzer.service;

import com.accolite.codelyzer.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    void createGroup(Group group);
    void findGroup(String groupName);
    void addUser(String groupName, String userEmail);
    void removeUser(String groupName, String userEmail);
}
