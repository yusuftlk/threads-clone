package com.project.threadsclone.controller;

import com.project.threadsclone.dto.AuthRequest;
import com.project.threadsclone.dto.UserDto;
import com.project.threadsclone.dto.request.CreateUserRequest;
import com.project.threadsclone.dto.request.UpdateUserRequest;
import com.project.threadsclone.model.User;
import com.project.threadsclone.service.JwtService;
import com.project.threadsclone.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{userName}")
    public ResponseEntity<UserDto> getUserByUserName(@PathVariable String userName){
        return ResponseEntity.ok(userService.getUserByUserName(userName));
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<?> getUserProfileImage(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(userService.getImageData(id));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @PostMapping("/login")
    public String logIn(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.username());
        }
        throw new UsernameNotFoundException("invalid username {} " + request.username());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest,
                                              @PathVariable Long id){
        return ResponseEntity.ok(userService.updateUser(updateUserRequest, id));
    }

    @PutMapping("/imageUpload/{id}")
    public ResponseEntity<UserDto> updateUserProfileImage(@RequestParam("image") MultipartFile file,
                                              @PathVariable Long id) throws IOException {
        return ResponseEntity.ok(userService.updateUserProfileImage(file, id));
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<UserDto> activeUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.activeUser(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){

        userService.deleteUserById(id);
    }
}








