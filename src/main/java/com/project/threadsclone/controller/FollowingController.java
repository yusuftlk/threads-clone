package com.project.threadsclone.controller;

import com.project.threadsclone.service.FollowingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/following")
public class FollowingController {
    private final FollowingService followingService;

    public FollowingController(FollowingService followingService) {
        this.followingService = followingService;
    }
}
