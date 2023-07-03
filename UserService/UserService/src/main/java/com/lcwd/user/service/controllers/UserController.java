package com.lcwd.user.service.controllers;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  private UserService userService;




//create
  @PostMapping
  public ResponseEntity createUser(@RequestBody User user){
    User user1 =  userService.saveUser(user);

    return ResponseEntity.status(HttpStatus.CREATED).body(user1);
  }

  //single user get
    @GetMapping("/{userId}")
   public ResponseEntity getSingleUser(@PathVariable String userId){
   User user =  userService.getUser(userId);

        return ResponseEntity.ok(user);
    }

    //all user get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
       List<User> allUser =  userService.getAllUser();
       return new ResponseEntity<>(allUser,HttpStatus.OK);
    }
}
