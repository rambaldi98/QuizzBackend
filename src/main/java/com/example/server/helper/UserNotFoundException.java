package com.example.server.helper;

public class UserNotFoundException extends Exception{
    public UserNotFoundException () {
        super("User with this Username is already in DB !! try  another one ");
    }
    public  UserNotFoundException(String msg){
        super(msg);
    }
}
