package com.example.demo.Coding.MachineCoding.SplitWise;

import java.util.List;

public class UserService {

    List<User> userList;
    public UserService(List<User> userList) {
        this.userList = userList;
    }

    public User getUser(String user) {
        for(User u : userList) {
            if(u.getName().equals(user)) {
                return u;
            }
        }
        return null;
    }
}
