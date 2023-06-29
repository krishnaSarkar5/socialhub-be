package com.socialhub.user.dto.friend;


import com.socialhub.common.utility.CommonUtils;
import com.socialhub.user.entity.FriendLog;
import com.socialhub.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendRequestResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String profileImage;

    private Integer status;

    private String requestedAt;

    public FriendRequestResponseDto(User user, LocalDateTime requestedAt) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.profileImage = null; // to be done later
        this.status = user.getStatus();
        this.requestedAt= CommonUtils.getDateInFrontendDateTimeFormat(requestedAt);
    }
}
