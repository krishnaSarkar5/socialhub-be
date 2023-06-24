package com.socialhub.post.service;

import com.socialhub.dto.ResponseData;

public interface CommentService {


    ResponseData createComment();

    ResponseData getCommentsByPostId();


}
