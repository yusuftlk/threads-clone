package com.project.threadsclone.dto.converter;

import com.project.threadsclone.dto.UserDto;
import com.project.threadsclone.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {
    public UserDto convert(User user){
        return new UserDto(user.getId(), user.getName(), user.getSurname(), user.getUsername(), user.getCreatedAt(), user.getUserProfileImage(), user.isActive(), user.getAuthorities());
    }
    public List<UserDto> convert(List<User> userList){
        return userList.stream().map(this::convert).collect(Collectors.toList());
    }
}
