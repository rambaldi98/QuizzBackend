package com.example.server.controller;

import com.example.server.helper.UserFoundException;
import com.example.server.helper.UserNotFoundException;
import com.example.server.model.Role;
import com.example.server.model.User;
import com.example.server.model.UserRole;
import com.example.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    // creating user
    @PostMapping
    public User creatingUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role("NORMAL");

        user.setProfile("default.png");
        // encoder password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);
        return this.userService.createUser(user,roles);
    }

    //get user by username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUsername(username);

    }
    // delete user by id
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        this.userService.deleteUserById(id);
    }

    // update user

    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionhandler(UserNotFoundException ex){
        return (ResponseEntity<?>) ResponseEntity.notFound();
    }
}
