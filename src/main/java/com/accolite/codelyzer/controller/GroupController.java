package com.accolite.codelyzer.controller;

import com.accolite.codelyzer.model.Group;
import com.accolite.codelyzer.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;
    @PostMapping("/groups/getAllGroup")
    public List<Group> listGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping("/groups/create/{groupName}")
    public String createGroup(@PathVariable String groupName) {
        Group group = new Group();
        group.setGroupName(groupName);
        groupService.createGroup(group);
        return "group created";
    }
    @PostMapping("/groups/addUser/{groupName}/{userEmail}")
    public String addUser(@PathVariable String groupName, @PathVariable String userEmail) {
        groupService.addUser(groupName, userEmail);
        return "user added";
    }
    @PostMapping("/groups/removeUser")
    public String removeUser() {
        return "user removed";
    }
}
