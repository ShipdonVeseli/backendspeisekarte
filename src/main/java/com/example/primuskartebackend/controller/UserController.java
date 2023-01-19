package com.example.primuskartebackend.controller;

import com.example.primuskartebackend.entity.Users;
import com.example.primuskartebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping()
    public ResponseEntity<Boolean> checkUser(@RequestBody Users users){
        return new ResponseEntity<>(userService.checkUserData(users), HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<Boolean> changePWD(@RequestBody Users users){
        return new ResponseEntity<>(userService.changePwd(users), HttpStatus.OK);
    }

}
