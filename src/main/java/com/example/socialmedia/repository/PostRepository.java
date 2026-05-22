package com.example.socialmedia.repository;

import com.example.socialmedia.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
    Page<Post> findByUserIdInOrderByCreatedAtDesc(
            List<Long> userIds,
            Pageable pageable
    );


    @Query("""
    SELECT p
    FROM Post p
    JOIN FETCH p.user
    WHERE p.user.id IN :userIds
    ORDER BY p.createdAt DESC
""")
    Page<Post> findFeedWithUser(
            List<Long> userIds,
            Pageable pageable
    );

    Page<Post> findByUserIdOrderByCreatedAtDesc(
            Long userId,
            Pageable pageable
    );


}
