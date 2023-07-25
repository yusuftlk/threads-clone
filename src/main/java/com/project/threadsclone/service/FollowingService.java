package com.project.threadsclone.service;

import com.project.threadsclone.repository.FollowingRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowingService {
    private final FollowingRepository followingRepository;

    public FollowingService(FollowingRepository followingRepository) {
        this.followingRepository = followingRepository;
    }
}
