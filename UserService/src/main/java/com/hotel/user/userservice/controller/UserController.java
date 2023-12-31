package com.hotel.user.userservice.controller;

import com.hotel.user.userservice.modal.dao.UserDetail;
import com.hotel.user.userservice.modal.response.UserDetailsResponse;
import com.hotel.user.userservice.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping
    public ResponseEntity<UserDetail> createUser(@RequestBody UserDetail userDetail){
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.saveUser(userDetail));
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDetailsResponse> getUserById(@PathVariable String userId){
        return ResponseEntity.ok(userServices.getUserDetailsByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserDetailsResponse>> getAllUsers(){
        return ResponseEntity.ok(userServices.getAllUserDetails());
    }
}
