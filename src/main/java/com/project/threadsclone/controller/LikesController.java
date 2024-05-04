package com.project.threadsclone.controller;

import com.project.threadsclone.dto.LikesDto;
import com.project.threadsclone.dto.converter.LikesDtoConverter;
import com.project.threadsclone.dto.request.CreateLikesRequest;
import com.project.threadsclone.model.Likes;
import com.project.threadsclone.model.Post;
import com.project.threadsclone.service.LikesService;
import com.project.threadsclone.service.PostService;
import com.project.threadsclone.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikesController {
    private final LikesService likesService;

    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping
    public LikesDto createLikes(@Valid  @RequestBody CreateLikesRequest createLikesRequest){
        return likesService.createLikes(createLikesRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteLikes(@PathVariable Long id){
        likesService.deleteLikes(id);
    }
}
