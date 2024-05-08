package com.project.threadsclone.service;

import com.project.threadsclone.Util.ImageUtils;
import com.project.threadsclone.dto.UserDto;
import com.project.threadsclone.dto.converter.UserDtoConverter;
import com.project.threadsclone.dto.request.CreateUserRequest;
import com.project.threadsclone.dto.request.UpdateUserRequest;
import com.project.threadsclone.exception.UserAlreadyExistException;
import com.project.threadsclone.exception.UserNotFoundException;
import com.project.threadsclone.model.User;
import com.project.threadsclone.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return userDtoConverter.convert(userRepository.findByUserName(userName).orElseThrow(() -> new UserNotFoundException("User Not Found userName : " + userName)));
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        userAlreadyExistOrNot(createUserRequest);

        User user =  new User(createUserRequest.getName(),createUserRequest.getSurname(),
                createUserRequest.getUserName(), createUserRequest.getMail(), createUserRequest.getNumber(),
                createUserRequest.getPassword(), LocalDateTime.now());

        return userDtoConverter.convert(userRepository.save(user));
    }

    private void userAlreadyExistOrNot(CreateUserRequest createUserRequest) {
        Optional<User> username = userRepository.findByUserName(createUserRequest.getUserName());
        if(username.isPresent()){
            throw new UserAlreadyExistException("User Already Exist userName : " + createUserRequest.getUserName());
        }

        Optional<User> mail = userRepository.findByMail(createUserRequest.getMail());
        if(mail.isPresent()){
            throw new UserAlreadyExistException("User Already Exist mail : " + createUserRequest.getMail());
        }
    }

    public UserDto updateUser(UpdateUserRequest updateUserRequest, Long id) {

        User user = findUserById(id);

        user.setName(updateUserRequest.getName());
        user.setSurname(updateUserRequest.getSurname());
        user.setUserName(updateUserRequest.getUserName());
        user.setNumber(updateUserRequest.getNumber());
        user.setPassword(updateUserRequest.getPassword());

        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUserProfileImage(MultipartFile file, Long id) throws IOException {
        User user = findUserById(id);
        user.setUserProfileImage(ImageUtils.compressImage(file.getBytes()));
        return userDtoConverter.convert(userRepository.save(user));
    }

    public byte[] getImageData(Long id){
        User user = findUserById(id);
        return ImageUtils.decompressImage(user.getUserProfileImage());
    }

    public void deleteUserById(Long id) {
        findUserById(id);

        userRepository.deleteById(id);
    }

    protected List<Long> getActiveUsers(List<Long> ids){

        List<Long> activeUsers = ids.stream()
                .map(this::findUserById)
                .filter(User::isActive)
                .map(User::getId)
                .collect(Collectors.toList());
        return activeUsers;
    }

    protected User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User Not Found id : " + id));
    }

    public UserDto activeUser(Long id) {
        User user = findUserById(id);
        if (user.isActive()) user.setActive(false);
        else user.setActive(true);
        return userDtoConverter.convert(userRepository.save(user));
    }
}
