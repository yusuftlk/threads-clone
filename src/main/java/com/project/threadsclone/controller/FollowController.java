package com.project.threadsclone.controller;

import com.project.threadsclone.dto.FollowDto;
import com.project.threadsclone.dto.request.CreateFollowRequest;
import com.project.threadsclone.model.Follow;
import com.project.threadsclone.service.FollowService;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/follow")
public class FollowController {
    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/follow")
    public FollowDto createFollow(@Valid @RequestBody CreateFollowRequest createFollowRequest) {
        return followService.createFollow(createFollowRequest);
    }
    @DeleteMapping("/unfollow")
    public void deleteFollow(@RequestParam Long followerId, Long followingId) {

        followService.deleteFollow(followerId, followingId);
    }

    @GetMapping("/follower/{userId}")
    public List<FollowDto> getFollowers(@PathVariable Long userId) {
        return followService.getFollowers(userId);
    }
    @GetMapping("/following/{userId}")
    public List<FollowDto> getFollowing(@PathVariable Long userId) {

        return followService.getFollowing(userId);
    }
}
