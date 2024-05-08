package com.project.threadsclone.dto.converter;

import com.project.threadsclone.dto.PostDto;
import com.project.threadsclone.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostDtoConverter {

    private final CommentDtoConverter commentDtoConverter;
    private final LikesDtoConverter likesDtoConverter;

    public PostDtoConverter(CommentDtoConverter commentDtoConverter, LikesDtoConverter likesDtoConverter) {
        this.commentDtoConverter = commentDtoConverter;
        this.likesDtoConverter = likesDtoConverter;
    }

    public PostDto convert(Post post){
        return new PostDto(post.getId(), post.getTitle(), post.getTotalLike(), post.getTotalComment(),
                post.getCreatedAt(), commentDtoConverter.convert(post.getComments()),
                likesDtoConverter.convert(post.getLikes()),post.getPostImage());
    }

    public List<PostDto> convert(List<Post> postList){
        return postList.stream().map(this::convert).collect(Collectors.toList());
    }
}
