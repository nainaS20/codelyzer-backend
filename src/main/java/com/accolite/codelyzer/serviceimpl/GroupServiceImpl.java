package com.accolite.codelyzer.serviceimpl;

import com.accolite.codelyzer.model.Group;
import com.accolite.codelyzer.model.User;
import com.accolite.codelyzer.repository.GroupRepo;
import com.accolite.codelyzer.repository.UserRepo;
import com.accolite.codelyzer.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public List<Group> getAllGroups() {
        return groupRepo.findAll();
    }

    @Override
    public void createGroup(Group group) {
        groupRepo.save(group);
    }

    @Override
    public void findGroup(String groupName) {
        System.out.println(groupRepo.findByGroupName(groupName));
    }

    @Override
    public void addUser(String groupName, String userEmail) {
        Group group = groupRepo.findByGroupName(groupName);
        User user = userRepo.findByEmail(userEmail);
        group.getUsers().add(user);
        user.getGroups().add(group);
        groupRepo.save(group);
        userRepo.save(user);
    }

    @Override
    public void removeUser(String groupName, String userEmail) {

    }
}
