package com.example.socialmedia.repository;

import com.example.socialmedia.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);

    long countByFollowerId(Long followerId);

    long countByFollowingId(Long followingId);

    @Query("select f.following.id from Follow f where f.follower.id = :followerId")
    List<Long> findFollowingUserIds(Long followerId);
}
