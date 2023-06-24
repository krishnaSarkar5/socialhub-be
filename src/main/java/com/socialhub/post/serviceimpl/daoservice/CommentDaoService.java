package com.socialhub.post.serviceimpl.daoservice;

import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import com.socialhub.post.entity.Comment;
import com.socialhub.post.repository.CommentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentDaoService {

    private CommentRepository commentRepository;


    private ActiveInactiveStatusUtil activeInactiveStatusUtil;


    public CommentDaoService(CommentRepository commentRepository, ActiveInactiveStatusUtil activeInactiveStatusUtil) {
        this.commentRepository = commentRepository;
        this.activeInactiveStatusUtil = activeInactiveStatusUtil;
    }


    public List<Comment> getAllCommentsForPostIdList(List<Long> postIdList){
       return commentRepository.findByPostIdInAndStatus(postIdList,ActiveInactiveStatusUtil.getACTIVE());
    }
}
