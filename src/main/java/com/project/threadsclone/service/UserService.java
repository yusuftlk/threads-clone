package com.project.threadsclone.service;

import com.project.threadsclone.Util.ImageUtils;
import com.project.threadsclone.dto.AuthRequest;
import com.project.threadsclone.dto.UserDto;
import com.project.threadsclone.dto.converter.UserDtoConverter;
import com.project.threadsclone.dto.request.CreateUserRequest;
import com.project.threadsclone.dto.request.UpdateUserRequest;
import com.project.threadsclone.exception.IncorrectUserException;
import com.project.threadsclone.exception.UserAlreadyExistException;
import com.project.threadsclone.exception.UserImageNullException;
import com.project.threadsclone.exception.UserNotFoundException;
import com.project.threadsclone.model.User;
import com.project.threadsclone.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getAllUsers() {

        return userDtoConverter.convert(userRepository.findAll());
    }

    public UserDto getUserByUserName(String userName) {
        return userDtoConverter.convert(userRepository.findByUsername(userName).orElseThrow(() -> new UserNotFoundException("User Not Found userName : " + userName)));
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        userAlreadyExistOrNot(createUserRequest);

        User user =  new User(createUserRequest.getName(),createUserRequest.getSurname(),
                createUserRequest.getUsername(), createUserRequest.getMail(), createUserRequest.getNumber(),
                passwordEncoder.encode( createUserRequest.getPassword()), LocalDateTime.now(),
                true, true, true, true,createUserRequest.getAuthorities());

        return userDtoConverter.convert(userRepository.save(user));
    }

    private void userAlreadyExistOrNot(CreateUserRequest createUserRequest) {
        Optional<User> username = userRepository.findByUsername(createUserRequest.getUsername());
        if(username.isPresent()){
            throw new UserAlreadyExistException("User Already Exist userName : " + createUserRequest.getUsername());
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
        user.setUsername(updateUserRequest.getUserName());
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
        if (user.getUserProfileImage() == null) {
            throw new UserImageNullException("User image empty");
        }
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(() -> new UsernameNotFoundException("User Not Found username : " + username));
    }
}
