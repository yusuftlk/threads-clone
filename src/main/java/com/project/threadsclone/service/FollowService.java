package com.project.threadsclone.service;


import com.project.threadsclone.dto.FollowDto;
import com.project.threadsclone.dto.converter.FollowDtoConverter;
import com.project.threadsclone.dto.request.CreateFollowRequest;
import com.project.threadsclone.exception.FollowAlreadyExistException;
import com.project.threadsclone.exception.FollowNotFoundException;
import com.project.threadsclone.model.Follow;
import com.project.threadsclone.repository.FollowRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FollowService {
    private final FollowRepository followRepository;
    private final FollowDtoConverter followDtoConverter;
    private final UserService userService;


    public FollowService(FollowRepository followRepository, FollowDtoConverter followDtoConverter, UserService userService) {

        this.followRepository = followRepository;
        this.followDtoConverter = followDtoConverter;
        this.userService = userService;
    }

    public FollowDto createFollow(CreateFollowRequest createFollowRequest) {
        FollowAlreadyExistOrNot(createFollowRequest);
        Follow follow = new Follow(createFollowRequest.getFollowerId(), createFollowRequest.getFollowingId(), LocalDateTime.now());
        return followDtoConverter.convert(followRepository.save(follow));

    }

    private void FollowAlreadyExistOrNot(CreateFollowRequest createFollowRequest) {
        Follow follow = followRepository.findByFollowerIdAndFollowingId(createFollowRequest.getFollowerId(), createFollowRequest.getFollowingId()).orElse(null);
        if (follow != null) {
            throw new FollowAlreadyExistException("Follow already exist");
        }
    }
    @Transactional
    public void deleteFollow(Long followerId, Long followingId) {

        Follow follow = followRepository.findByFollowerIdAndFollowingId(followerId, followingId).orElseThrow(() -> new FollowNotFoundException("Follow not found"));
        followRepository.deleteById(follow.getId());
    }
    public List<FollowDto> getFollowing(Long userId) {
        List<Follow> follow = followRepository.findByFollowerId(userId);
        List<Long> ids = new ArrayList<>();
        for(Follow f : follow){
            ids.add(f.getFollowingId());
        }
        List<Long> activeUsers = userService.getActiveUsers(ids);

        List<Follow> result = new ArrayList<>();
        for(Long id : activeUsers){
            result.add(followRepository.findByFollowerIdAndFollowingId(userId, id).orElse(null));
        }
        return followDtoConverter.convert(result);

    }
    public List<FollowDto> getFollowers(Long userId) {
        List<Follow> follow = followRepository.findByFollowingId(userId);
        List<Long> ids = new ArrayList<>();
        for(Follow f : follow){
            ids.add(f.getFollowerId());
        }
        List<Long> activeUsers = userService.getActiveUsers(ids);

        List<Follow> result = new ArrayList<>();
        for(Long id : activeUsers){
            result.add(followRepository.findByFollowerIdAndFollowingId(id, userId).orElse(null));
        }
        return followDtoConverter.convert(result);
    }

}
