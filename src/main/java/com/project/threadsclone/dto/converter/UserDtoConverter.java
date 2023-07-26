package com.project.threadsclone.dto.converter;

import com.project.threadsclone.dto.FollowingDto;
import com.project.threadsclone.dto.UserDto;
import com.project.threadsclone.model.Follower;
import com.project.threadsclone.model.Following;
import com.project.threadsclone.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    private final FollowerDtoCnverter followerDtoCnverter;
    private final FollowingDtoConverter followingDtoConverter;

    public UserDtoConverter(FollowerDtoCnverter followerDtoCnverter, FollowingDtoConverter followingDtoConverter) {
        this.followerDtoCnverter = followerDtoCnverter;
        this.followingDtoConverter = followingDtoConverter;
    }
    public UserDto convert(User user){
        return new UserDto(user.getId(), user.getName(), user.getSurname(), user.getUserName(),
                user.getCreatedAt(),
                followerDtoCnverter.convert(user.getFollowers()),
                followingDtoConverter.convert(user.getFollowings()));
    }
    public List<UserDto> convert(List<User> userList){
        return userList.stream().map(this::convert).collect(Collectors.toList());
    }
}
