package com.socialhub.post.dto;

import com.socialhub.common.utility.CommonUtils;
import com.socialhub.post.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {


    private Long id;


    private String commentText;


    private String createdAt;


    private String updatedAt;


    private Long postId;


    private Long commentBy;


    private List<CommentDto> replies;



    public CommentDto(Comment comment){

        this.id=comment.getId();
        this.commentText=comment.getCommentText();
        this.createdAt= CommonUtils.getDateInFrontendDateFormat(comment.getCreatedAt());
        this.updatedAt= CommonUtils.getDateInFrontendDateFormat(comment.getUpdatedAt());
        this.postId= comment.getPostId();
        this.commentBy=comment.getCommentBy();

    }


}
