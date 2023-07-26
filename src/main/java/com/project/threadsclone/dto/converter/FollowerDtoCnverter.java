package com.project.threadsclone.dto.converter;

import com.project.threadsclone.dto.FollowerDto;
import com.project.threadsclone.model.Follower;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FollowerDtoCnverter {
    public FollowerDto convert(Follower follower){
        return new FollowerDto(follower.getId(), follower.getUserName());
    }

    public List<FollowerDto> convert(List<Follower> followers){
        return followers.stream().map(this::convert).collect(Collectors.toList());
    }
}
