package com.example.server.helper;

public class UserFoundException extends Exception{
    public UserFoundException () {
        super("User with this username not found in DB !!");
    }
    public  UserFoundException(String msg){
        super(msg);
    }
}
