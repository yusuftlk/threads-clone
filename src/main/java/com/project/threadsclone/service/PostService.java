package com.project.threadsclone.service;

import com.project.threadsclone.dto.PostDto;
import com.project.threadsclone.dto.converter.PostDtoConverter;
import com.project.threadsclone.dto.request.CreatePostRequest;
import com.project.threadsclone.dto.request.UpdatePostRequest;
import com.project.threadsclone.exception.PostNotFoundException;
import com.project.threadsclone.model.Post;
import com.project.threadsclone.model.User;
import com.project.threadsclone.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostDtoConverter postDtoConverter;
    private final UserService userService;


    public PostService(PostRepository postRepository, PostDtoConverter postDtoConverter, UserService userService) {
        this.postRepository = postRepository;
        this.postDtoConverter = postDtoConverter;
        this.userService = userService;
    }

    public List<PostDto> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()){
            return postDtoConverter.convert(postRepository.findByUserId(userId));

        }else return postDtoConverter.convert(postRepository.findAll());
    }

    public PostDto createPost(CreatePostRequest createPostRequest) {
        User user = userService.findUserById(createPostRequest.getUserId());
        Post post = new Post(user, createPostRequest.getTitle(), createPostRequest.getImage(), LocalDateTime.now());

        return postDtoConverter.convert(postRepository.save(post));
    }

    public PostDto getPostById(Long id) {

        return postDtoConverter.convert(findPostById(id));
    }

    public PostDto updatePost(UpdatePostRequest updatePostRequest, Long id) {
        Post post = findPostById(id);

        post.setTitle(updatePostRequest.getTitle());
        post.setImage(updatePostRequest.getImage());

        return postDtoConverter.convert(postRepository.save(post));
    }
    public void deletePost(Long id) {
        findPostById(id);

        postRepository.deleteById(id);
    }
    protected Post findPostById(Long id){

        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post not found with id: " + id));
    }
}
