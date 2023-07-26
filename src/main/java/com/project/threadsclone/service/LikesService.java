package com.project.threadsclone.service;

import com.project.threadsclone.dto.LikesDto;
import com.project.threadsclone.dto.converter.LikesDtoConverter;
import com.project.threadsclone.dto.request.CreateLikesRequest;
import com.project.threadsclone.model.Likes;
import com.project.threadsclone.model.Post;
import com.project.threadsclone.model.User;
import com.project.threadsclone.repository.LikesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LikesService {
    private final LikesRepository likesRepository;
    private final LikesDtoConverter likesDtoConverter;
    private final PostService postService;
    private final UserService userService;


    public LikesService(LikesRepository likesRepository, LikesDtoConverter likesDtoConverter, PostService postService, UserService userService) {
        this.likesRepository = likesRepository;
        this.likesDtoConverter = likesDtoConverter;
        this.postService = postService;
        this.userService = userService;
    }

    public LikesDto createLikes(CreateLikesRequest createLikesRequest) {
        Post post = postService.findPostById(createLikesRequest.getPostId());
        User user = userService.findUserById(createLikesRequest.getUserId());

        Likes likes = new Likes(post, user, LocalDateTime.now());

        return likesDtoConverter.convert(likesRepository.save(likes));
    }

    public void deleteLikes(Long id) {
        findLikesById(id);

        likesRepository.deleteById(id);
    }

    protected Likes findLikesById(Long id){
        return likesRepository.findById(id).orElseThrow(null);
    }
}
