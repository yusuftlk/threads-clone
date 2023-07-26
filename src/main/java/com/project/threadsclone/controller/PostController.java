package com.project.threadsclone.controller;

import com.project.threadsclone.dto.PostDto;
import com.project.threadsclone.dto.request.CreatePostRequest;
import com.project.threadsclone.dto.request.UpdatePostRequest;
import com.project.threadsclone.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts (@RequestParam Optional<Long> userId){
        return ResponseEntity.ok(postService.getAllPosts(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody CreatePostRequest createPostRequest){
        return ResponseEntity.ok(postService.createPost(createPostRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody UpdatePostRequest updatePostRequest,
                                              @PathVariable Long id){
        return ResponseEntity.ok(postService.updatePost(updatePostRequest, id));
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }



}
