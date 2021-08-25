package com.example.server.service;

import com.example.server.model.User;
import com.example.server.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
public interface UserService {
    // creating user
    public User createUser(User user, Set<UserRole>userRoles) throws Exception;
    // get user by username
    public User getUsername(String username);
    // delete user by id
    public void deleteUserById(Long id);
}
