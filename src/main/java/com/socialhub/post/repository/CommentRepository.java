package com.socialhub.post.repository;

import com.socialhub.post.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPostIdInAndStatus(List<Long> postIdList ,Integer status);

}
