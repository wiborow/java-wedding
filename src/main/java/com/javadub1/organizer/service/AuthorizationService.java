package com.javadub1.organizer.service;

import com.javadub1.organizer.model.authorization.User;

public class AuthorizationService {
    public User findUser(String userName, String password) {

        if(userName.equals("user") && password.equals("user")) {
            return new User("user", "user", "USER");
        } else if(userName.equals("admin") && password.equals("admin")) {
            return new User("admin", "admin", "ADMIN");
        } else {
            return null;
        }
    }
}
