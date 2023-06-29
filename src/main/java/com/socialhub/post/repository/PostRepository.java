package com.socialhub.post.repository;

import com.socialhub.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {


    public List<Post> findByCreatedByIdInAndStatusOrderByCreatedAtDesc(List<Long> userId, Integer status);

}
