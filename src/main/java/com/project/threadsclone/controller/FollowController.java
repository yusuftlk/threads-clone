package com.project.threadsclone.controller;

import com.project.threadsclone.dto.request.CreateFollowRequest;
import com.project.threadsclone.model.Follow;
import com.project.threadsclone.service.FollowService;
import jakarta.persistence.GeneratedValue;
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
    public Follow createFollow(@RequestBody CreateFollowRequest createFollowRequest) {
        return followService.createFollow(createFollowRequest);
    }
    @DeleteMapping("/unfollow")
    public void deleteFollow(@RequestParam Long userId, Long followingId) {

        followService.deleteFollow(userId, followingId);
    }

    @GetMapping("/follower/{userId}")
    public List<Follow> getFollowers(@PathVariable Long userId) {
        return followService.getFollowers(userId);
    }
    @GetMapping("/following/{userId}")
    public List<Follow> getFollowing(@PathVariable Long userId) {
        return followService.getFollowing(userId);
    }
}
