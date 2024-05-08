package com.project.threadsclone.controller;

import com.project.threadsclone.dto.PostDto;
import com.project.threadsclone.dto.request.CreatePostRequest;
import com.project.threadsclone.dto.request.UpdatePostRequest;
import com.project.threadsclone.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @GetMapping("/getImage/{id}")
    public ResponseEntity<?> getUserProfileImage(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(postService.getImageData(id));
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PostDto> createPost(@Valid @ModelAttribute CreatePostRequest createPostRequest) throws IOException {

        if (createPostRequest.getFile() != null)
            return ResponseEntity.ok(postService.createPostWithImage(createPostRequest));

        return ResponseEntity.ok(postService.createPost(createPostRequest));

    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody UpdatePostRequest updatePostRequest,
                                              @PathVariable Long id){
        return ResponseEntity.ok(postService.updatePost(updatePostRequest, id));
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }



}
