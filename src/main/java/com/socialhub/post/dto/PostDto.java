package com.socialhub.post.dto;

import com.socialhub.common.utility.CommonUtils;
import com.socialhub.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    private Long id;


    private String postText;


    private List<String> postImages;


    private Long postedBy;


    private String createdAt;


    private String updatedAt;


    private Integer status;


    private List<CommentDto> comments;


    public PostDto(Post post) {
        this.id = post.getId();
        this.postText = post.getPostText();
        this.postedBy = post.getCreatedBy().getId();
        this.createdAt = CommonUtils.getDateInFrontendDateTimeFormat(post.getCreatedAt());
        this.updatedAt = CommonUtils.getDateInFrontendDateTimeFormat(post.getUpdatedAt());
        this.status = post.getStatus();
    }
}
