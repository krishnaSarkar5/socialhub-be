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
public class IdDto {

    private Long id;


    public void validate(){

        Map<String,Object> errorMap = new HashMap<>();

        DtoValidation.mandatoryCheck("Id",id,errorMap);

        if(errorMap.size()>0){
            throw  new ServiceException(errorMap);
        }
    }
}
