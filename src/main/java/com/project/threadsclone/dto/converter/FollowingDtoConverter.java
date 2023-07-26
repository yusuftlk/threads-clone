package com.project.threadsclone.dto.converter;

import com.project.threadsclone.dto.FollowerDto;
import com.project.threadsclone.dto.FollowingDto;
import com.project.threadsclone.model.Follower;
import com.project.threadsclone.model.Following;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FollowingDtoConverter {
    public FollowingDto convert(Following following){
        return new FollowingDto(following.getId(), following.getUserName());
    }

    public List<FollowingDto> convert(List<Following> followings){
        return followings.stream().map(this::convert).collect(Collectors.toList());
    }
}
