package com.project.threadsclone.dto.converter;

import com.project.threadsclone.dto.FollowDto;
import com.project.threadsclone.model.Follow;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FollowDtoConverter {

    public FollowDto convert(Follow follow){
        return new FollowDto(follow.getId(), follow.getFollowerId(), follow.getFollowingId(), follow.getCreatedAt());
    }

    public List<FollowDto> convert(List<Follow> followList){
        return followList.stream().map(this::convert).collect(Collectors.toList());
    }

}
