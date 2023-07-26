package com.project.threadsclone.dto.converter;

import com.project.threadsclone.dto.CommentDto;
import com.project.threadsclone.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentDtoConverter {
    private final UserDtoConverter userDtoConverter;

    public CommentDtoConverter(UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }

    public CommentDto convert(Comment comment){
        return new CommentDto(comment.getId(), userDtoConverter.convert(comment.getUser()),
                comment.getComment(), comment.getCreatedAt());
    }

    public List<CommentDto> convert(List<Comment> commentList){
        return commentList.stream().map(this::convert).collect(Collectors.toList());
    }
}
