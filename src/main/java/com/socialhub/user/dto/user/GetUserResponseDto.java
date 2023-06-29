package com.socialhub.user.dto.user;

import com.socialhub.common.utility.CommonUtils;
import com.socialhub.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponseDto {


    private String email;


    private String phone;


    private String createdAt;

    private Integer status;


    private String gender;


    private List<String> images;


    public GetUserResponseDto(User user){
        this.email= user.getEmail();
        this.phone= user.getPhone();
        this.createdAt= CommonUtils.getDateInFrontendDateFormat(user.getCreatedAt());
        this.status=user.getStatus();
        this.gender=user.getGender();
        this.images=user.getImages().stream().map(image->image.getImage()).collect(Collectors.toList());
    }
}
