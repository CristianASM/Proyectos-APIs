package com.api.exceptions.Controller;

import com.api.exceptions.Model.User;
import com.api.exceptions.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.allUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User userById = userService.userById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }
    @PostMapping("/new")
    public ResponseEntity<User> newUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User modifyUser = userService.updateUser(id, user);
        return new ResponseEntity<>(modifyUser, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
