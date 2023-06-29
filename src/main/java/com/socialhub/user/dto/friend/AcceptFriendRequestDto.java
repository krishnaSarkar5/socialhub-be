package com.socialhub.user.dto.friend;

import com.socialhub.common.exception.ServiceException;
import com.socialhub.common.utility.DtoValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AcceptFriendRequestDto {

    private Long requestSentByUserId;


    public void validate(){

        Map<String, Object> errorMap = new HashMap<>();

        DtoValidation.mandatoryCheck("requestSentByUserId",requestSentByUserId,errorMap);

        if(errorMap.size()>0){
            throw new ServiceException(errorMap);
        }

    }
}
