package com.project.threadsclone.service;


import com.project.threadsclone.dto.request.CreateFollowRequest;
import com.project.threadsclone.model.Follow;
import com.project.threadsclone.repository.FollowRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FollowService {
    private final FollowRepository followRepository;

    public FollowService(FollowRepository followRepository) {

        this.followRepository = followRepository;
    }

    public Follow createFollow(CreateFollowRequest createFollowRequest) {

        Follow follow = new Follow(createFollowRequest.getUserId(), createFollowRequest.getFollowingId(), LocalDateTime.now());
        return followRepository.save(follow);

    }
    @Transactional
    public void deleteFollow(Long userId, Long followingId) {
        followRepository.deleteByFollowerIdAndFollowingId(userId, followingId);
    }
    public List<Follow> getFollowing(Long userId) {

        return followRepository.findByFollowerId(userId);
    }
    public List<Follow> getFollowers(Long userId) {
        return followRepository.findByFollowingId(userId);
    }

}
