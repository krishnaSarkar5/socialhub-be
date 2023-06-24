package com.socialhub.post.serviceimpl.post;

import com.socialhub.common.utility.AuthenticationUtil;
import com.socialhub.common.utility.ResponseUtil;
import com.socialhub.dto.ResponseData;
import com.socialhub.post.dto.CommentDto;
import com.socialhub.post.dto.PostDto;
import com.socialhub.post.entity.Comment;
import com.socialhub.post.entity.Post;
import com.socialhub.post.serviceimpl.daoservice.CommentDaoService;
import com.socialhub.post.serviceimpl.daoservice.PostDaoService;
import com.socialhub.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class GetPostService {

    private PostDaoService postDaoService;
    
    
    private CommentDaoService commentDaoService;


    private AuthenticationUtil authenticationUtil;


    private ResponseUtil responseUtil;

    public GetPostService(PostDaoService postDaoService,AuthenticationUtil authenticationUtil,CommentDaoService commentDaoService,ResponseUtil responseUtil) {
        this.postDaoService = postDaoService;
        this.authenticationUtil=authenticationUtil;
        this.commentDaoService=commentDaoService;
        this.responseUtil=responseUtil;
    }

    public ResponseData getAllPostForCurrentLoggedInUser(){

        List<PostDto> postDtoList = getPostDtoListForCurrentLoggedInUser();

        return responseUtil.successResponse(postDtoList);
    }



    private User getCurrentLoggedInUser(){
        return (User) authenticationUtil.currentLoggedInUser().getUser();
    }


    private List<Long> getFriendIdList(Long userId){
        return List.of(2L,3L,4L,5L);  // currently hard coded
    }


    private List<Post> getAllPostForUserIdList(List<Long> userIdList){
        return postDaoService.getAllPostByUserIdList(userIdList);
    }


    private List<Comment> getAllCommentsByPostIdList(List<Long> postIdList){
        return commentDaoService.getAllCommentsForPostIdList(postIdList);
    }

    
    private List<PostDto> getPostDtoListForCurrentLoggedInUser(){


        User loggedInUser = getCurrentLoggedInUser();

        List<Long> friendIdList = getFriendIdList(loggedInUser.getId());

        List<Post> allPostForFriendIdList = getAllPostForUserIdList(friendIdList);

        Set<Long> postIdSet = allPostForFriendIdList.stream().map(post -> post.getId()).collect(Collectors.toSet());

        List<Long> postIdList = new ArrayList<>(postIdSet);

        List<Comment> allCommentsOfPostList = getAllCommentsByPostIdList(postIdList);

        Map<Post, List<Comment>> postCommentsMap = getPostCommentsMap(allPostForFriendIdList, allCommentsOfPostList);


       return getPostDtoFromPostAndCommentMap(postCommentsMap);

    }


    private Map<Post,List<Comment>> getPostCommentsMap(List<Post> allPost,List<Comment> allComments){

        Map<Post,List<Comment>> postCommentsMap = new HashMap<>();

        for(Post post : allPost){

            List<Comment> comments = allComments.stream().filter(comment -> comment.getPostId().equals(post.getId())).collect(Collectors.toList());

            postCommentsMap.put(post,comments);

        }

        return postCommentsMap;
    }


    private List<CommentDto> getCommentDtoFromCommentListForAPost(List<Comment> allComments){

        List<Comment> rootComments = allComments.stream().filter(comment -> comment.getCommentRefId().equals(-1l)).collect(Collectors.toList());

        return getReplies(rootComments, allComments);

    }

    // Recursive function to generate nested replies
    private List<CommentDto> getReplies(List<Comment> comments,List<Comment> allComments){

        List<CommentDto> list1 = new ArrayList<>();

        for(Comment comment : comments){

            CommentDto cmDto = new CommentDto(comment);

            List<Comment> replies = allComments.stream().filter(cm -> cm.getCommentRefId().equals(comment.getId())).collect(Collectors.toList());

            if(replies.size()==0){
                list1.add(cmDto);
            }else {
                List<CommentDto> replies1 = getReplies(replies, allComments);
                cmDto.setReplies(replies1);
                list1.add(cmDto);
            }

        }
        return  list1;
    }


    private List<PostDto> getPostDtoFromPostAndCommentMap(Map<Post, List<Comment>> postCommentsMap){

        List<PostDto> allPosts = new ArrayList<>();


        for(Map.Entry<Post,List<Comment>> entry : postCommentsMap.entrySet()){

            List<CommentDto> commentDtoList = getCommentDtoFromCommentListForAPost(entry.getValue());

            PostDto postDto = new PostDto(entry.getKey());

            postDto.setComments(commentDtoList);

            allPosts.add(postDto);

        }


        return allPosts;
    }
}
