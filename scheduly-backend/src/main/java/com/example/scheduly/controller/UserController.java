package com.example.scheduly.controller;

import com.example.scheduly.dbo.UserDTO;
import com.example.scheduly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> listAll() {
        return userService.listAllUsers();
    }

    @PostMapping
    public void insertUser(@RequestBody UserDTO userDTO) {
        userService.insert(userDTO);
    }

    @PutMapping
    public UserDTO changeUser(@RequestBody UserDTO userDTO) {
        return userService.change(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") UUID _id) {
        userService.delete(_id);
        return ResponseEntity.ok().build();
    }
}
