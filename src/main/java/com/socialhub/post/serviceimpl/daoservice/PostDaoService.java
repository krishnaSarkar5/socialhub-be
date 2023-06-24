package com.socialhub.post.serviceimpl.daoservice;


import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import com.socialhub.post.entity.Post;
import com.socialhub.post.repository.PostRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDaoService {


    private PostRepository postRepository;

    private ActiveInactiveStatusUtil activeInactiveStatusUtil;


    public PostDaoService(PostRepository postRepository, ActiveInactiveStatusUtil activeInactiveStatusUtil) {
        this.postRepository = postRepository;
        this.activeInactiveStatusUtil = activeInactiveStatusUtil;
    }


    public List<Post>  getAllPostByUserIdList(List<Long> userIdList){
        return postRepository.findByCreatedByIdInAndStatus(userIdList,ActiveInactiveStatusUtil.getACTIVE());
    }






}
