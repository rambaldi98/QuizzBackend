package com.example.server;

import com.example.server.helper.UserFoundException;
import com.example.server.helper.UserNotFoundException;
import com.example.server.model.Role;
import com.example.server.model.User;
import com.example.server.model.UserRole;
import com.example.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@SpringBootApplication

public class ServerApplication implements CommandLineRunner  {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);


    }


    @Override
    public void run(String... args) throws Exception {
        try {


            System.out.println("starting code ");
//        if(this.userService.getUsername("rambaldi") == null){
            User user = new User();
            user.setFirstName("cong");
            user.setLastName("dien van");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setUsername("rambaldi");

            Role role = new Role();
            role.setRoleName("ADMIN");

            Set<UserRole> userRoles = new HashSet<>();
            UserRole userRole = new UserRole();
            userRole.setRole(role);
            userRole.setUser(user);
            userRoles.add(userRole);
            User user1 = this.userService.createUser(user, userRoles);
            System.out.println(user1.getUsername());
//        }

        } catch (UserFoundException e){
            e.printStackTrace();
        }
    }
}

