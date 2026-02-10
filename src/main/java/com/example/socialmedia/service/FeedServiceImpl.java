package com.example.socialmedia.service;

import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.repository.FollowRepository;
import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {

    private final FollowRepository followRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public FeedServiceImpl(FollowRepository followRepository,
                           PostRepository postRepository,
                           UserRepository userRepository) {
        this.followRepository = followRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<Post> getFeed(String userEmail, int page, int size) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Long> followedUserIds =
                followRepository.findFollowingUserIds(user.getId());

        if (followedUserIds.isEmpty()) {
            return Page.empty();
        }

        return postRepository.findByUserIdInOrderByCreatedAtDesc(
                followedUserIds,
                PageRequest.of(page, size)
        );
    }
}
