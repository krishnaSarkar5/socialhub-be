package com.socialhub.post.service;

import com.socialhub.dto.ResponseData;

public interface PostService {

    ResponseData createPost();

    ResponseData getPostById();

    ResponseData getAllPostByUserId();


    ResponseData getAllPostForCurrentLoggedInUser();

}
