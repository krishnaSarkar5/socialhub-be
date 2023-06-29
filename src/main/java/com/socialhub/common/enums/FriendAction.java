package com.socialhub.common.enums;

public enum FriendAction {

    FRIEND_REQUEST_SENT(1),
    FRIEND_REQUEST_ACCEPT(2),
    FRIEND_REQUEST_CANCELLED(3),
    FRIEND_REQUEST_DECLINED(4),

    UNFRIEND(5),

    FOLLOW(6),

    UNFOLLOW(7),

    BLOCKED(8)

    ;

    private Integer value;

    private FriendAction(Integer value){
        this.value=value;
    }


    public Integer getValue(){
        return this.value;
    }
}
