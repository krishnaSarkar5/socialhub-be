package com.socialhub.user.dto.user;

import com.socialhub.common.utility.DtoValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDto {

    @NonNull
    private String email;

    @NonNull
    private String phone;

    @NonNull
    private  String password;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private String image;

    @NonNull
    private String gender;


    public void validate(){

        Map<String,Object> errorMap = new HashMap<>();

        DtoValidation.validateEmail(email,errorMap);

        DtoValidation.validateMobileNumber(phone,errorMap);

        DtoValidation.validateGender(gender,errorMap);

        DtoValidation.mandatoryCheck("firstName",firstName,errorMap);
        DtoValidation.mandatoryCheck("lastName",lastName,errorMap);
    }


}
