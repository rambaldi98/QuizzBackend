package com.example.server.service.impl;

import com.example.server.helper.UserFoundException;
import com.example.server.model.User;
import com.example.server.model.UserRole;
import com.example.server.repository.RoleRepository;
import com.example.server.repository.UserRepository;
import com.example.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;



    // creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
       User local =  this.userRepository.findByUsername(user.getUsername());
        if(local!= null){
            System.out.println("user is already there !!");
            throw new UserFoundException();
        } else {
            for (UserRole u : userRoles){
                roleRepository.save(u.getRole());
            }
            user.getUserRoleSet().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }
    //
    @Override
    public User getUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

}
