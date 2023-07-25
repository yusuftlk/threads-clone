package com.project.threadsclone.service;

import com.project.threadsclone.repository.LikesRepository;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    private final LikesRepository likesRepository;

    public LikesService(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }
}
