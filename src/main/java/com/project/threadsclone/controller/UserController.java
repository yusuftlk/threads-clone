package com.project.threadsclone.controller;

import com.project.threadsclone.dto.UserDto;
import com.project.threadsclone.dto.request.CreateUserRequest;
import com.project.threadsclone.dto.request.UpdateUserRequest;
import com.project.threadsclone.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{userName}")
    public ResponseEntity<UserDto> getUserByUserName(@PathVariable String userName){
        return ResponseEntity.ok(userService.getUserByUserName(userName));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UpdateUserRequest updateUserRequest,
                                              @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUser(updateUserRequest, id));
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id){

        userService.deleteUserById(id);
    }
}








