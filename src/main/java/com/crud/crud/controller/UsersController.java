package com.crud.crud.controller;

import com.crud.crud.models.Post;
import com.crud.crud.models.Users;
import com.crud.crud.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users users){
        Users newUser  = usersService.registerUser(users);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

}
