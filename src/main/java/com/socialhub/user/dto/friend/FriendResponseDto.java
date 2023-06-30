package com.socialhub.user.dto.friend;

import com.socialhub.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendResponseDto {

    private Long id;

    private String profileImage;

    private String firstName;

    private String lastName;

    private Integer status;


    public FriendResponseDto(User user){
        this.id=user.getId();
        this.firstName= user.getFirstName();
        this.lastName= user.getLastName();
        this.status= user.getStatus();
    }
}
