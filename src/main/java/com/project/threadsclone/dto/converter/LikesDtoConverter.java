package com.project.threadsclone.dto.converter;

import com.project.threadsclone.dto.LikesDto;
import com.project.threadsclone.model.Likes;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LikesDtoConverter {
    private final UserDtoConverter userDtoConverter;

    public LikesDtoConverter(UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }

    public LikesDto convert(Likes likes){
        return new LikesDto(likes.getId(), userDtoConverter.convert(likes.getUser()), likes.getCreatedAt());
    }

    public List<LikesDto> convert(List<Likes> likesList){
        return likesList.stream().map(likes -> this.convert(likes)).collect(Collectors.toList());
    }
}
