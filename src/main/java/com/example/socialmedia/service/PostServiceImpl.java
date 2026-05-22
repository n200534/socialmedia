package com.example.socialmedia.service;

import com.example.socialmedia.dto.PostResponse;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.exception.UserNotFoundException;
import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository,
                           UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    @CacheEvict(value = "feeds", allEntries = true)
    public Post createPost(@NotBlank  String request,
                           String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));

        Post post = new Post();
        post.setContent(request);
        post.setUser(user);

        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<PostResponse> getMyPosts(
            String userEmail,
            int page,
            int size
    ) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException(userEmail));

        Page<Post> postPage =
                postRepository.findByUserIdOrderByCreatedAtDesc(
                        user.getId(),
                        PageRequest.of(page, size)
                );

        return postPage.getContent()
                .stream()
                .map(post -> new PostResponse(
                        post.getId(),
                        post.getContent(),
                        post.getUser().getUsername(),
                        post.getCreatedAt()
                ))
                .toList();
    }

    @Override
    public List<PostResponse> getPostsByUserId(
            Long userId,
            int page,
            int size
    ) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Page<Post> postPage =
                postRepository.findByUserIdOrderByCreatedAtDesc(
                        user.getId(),
                        PageRequest.of(page, size)
                );

        return postPage.getContent()
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
