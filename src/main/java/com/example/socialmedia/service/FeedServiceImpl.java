package com.example.socialmedia.service;

import com.example.socialmedia.dto.PostResponse;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.exception.UserNotFoundException;
import com.example.socialmedia.repository.FollowRepository;
import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(
            value = "feeds",
            key = "#userEmail + ':' + #page + ':' + #size"
    )
    public List<PostResponse> getFeed(
            String userEmail,
            int page,
            int size
    ) {

        System.out.println("Fetching feed from DB...");
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException(userEmail));

        List<Long> followedUserIds =
                followRepository.findFollowingUserIds(user.getId());

        followedUserIds.add(user.getId());

        Page<Post> feedPage = postRepository.findFeedWithUser(
                followedUserIds,
                PageRequest.of(page, size)
        );

        return feedPage.getContent()
                .stream()
                .map(post -> new PostResponse(
                        post.getId(),
                        post.getContent(),
                        post.getUser().getUsername(),
                        post.getCreatedAt()
                ))
                .toList();
    }

}
