package com.project.threadsclone.service;

import com.project.threadsclone.dto.UserDto;
import com.project.threadsclone.dto.converter.UserDtoConverter;
import com.project.threadsclone.dto.request.CreateUserRequest;
import com.project.threadsclone.dto.request.UpdateUserRequest;
import com.project.threadsclone.model.User;
import com.project.threadsclone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers() {

        return userDtoConverter.convert(userRepository.findAll());
    }

    public UserDto getUserByUserName(String userName) {
        return userDtoConverter.convert(userRepository.findByUserName(userName));
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        User user =  new User(createUserRequest.getName(),createUserRequest.getSurname(),
                createUserRequest.getUserName(), createUserRequest.getMail(),
                createUserRequest.getPassword(), LocalDateTime.now());

        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(UpdateUserRequest updateUserRequest, Long id) {
        User user = findUserById(id);

        user.setName(updateUserRequest.getName());
        user.setSurname(updateUserRequest.getSurname());
        user.setUserName(updateUserRequest.getUserName());
        user.setPassword(updateUserRequest.getPassword());

        return userDtoConverter.convert(userRepository.save(user));
    }

    protected User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(null);
    }

    public void deleteUserById(Long id) {
        findUserById(id);

        userRepository.deleteById(id);
    }
}
