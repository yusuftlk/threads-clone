package com.project.threadsclone.service;

import com.project.threadsclone.repository.FollowerRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    private final FollowerRepository followerRepository;

    public FollowerService(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }
}
