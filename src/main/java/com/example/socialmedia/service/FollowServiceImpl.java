package com.example.socialmedia.service;

import com.example.socialmedia.entity.Follow;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.repository.FollowRepository;
import com.example.socialmedia.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public FollowServiceImpl(FollowRepository followRepository,
                             UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void followUser(Long userIdToFollow, String followerEmail) {

        User follower = userRepository.findByEmail(followerEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        User following = userRepository.findById(userIdToFollow)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (follower.getId().equals(following.getId())) {
            throw new RuntimeException("You cannot follow yourself");
        }

        if (followRepository.existsByFollowerIdAndFollowingId(
                follower.getId(), following.getId())) {
            throw new RuntimeException("Already following this user");
        }

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);

        followRepository.save(follow);
    }

    @Override
    public void unfollowUser(Long userIdToUnfollow, String followerEmail) {

        User follower = userRepository.findByEmail(followerEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        followRepository.findAll().stream()
                .filter(f ->
                        f.getFollower().getId().equals(follower.getId()) &&
                                f.getFollowing().getId().equals(userIdToUnfollow)
                )
                .findFirst()
                .ifPresentOrElse(
                        followRepository::delete,
                        () -> { throw new RuntimeException("Not following user"); }
                );
    }

    @Override
    public long getFollowersCount(Long userId) {
        return followRepository.countByFollowingId(userId);
    }

    @Override
    public long getFollowingCount(Long userId) {
        return followRepository.countByFollowerId(userId);
    }
}
