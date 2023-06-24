package com.socialhub.post.serviceimpl.post;

import com.socialhub.dto.ResponseData;
import com.socialhub.post.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {



    private GetPostService getPostService;


    public PostServiceImpl(GetPostService getPostService) {
        this.getPostService = getPostService;
    }

    @Override
    public ResponseData createPost() {
        return null;
    }

    @Override
    public ResponseData getPostById() {
        return null;
    }

    @Override
    public ResponseData getAllPostByUserId() {
        return null;
    }

    @Override
    public ResponseData getAllPostForCurrentLoggedInUser() {
        return getPostService.getAllPostForCurrentLoggedInUser();
    }
}
