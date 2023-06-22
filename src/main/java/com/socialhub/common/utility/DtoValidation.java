package com.socialhub.common.utility;




import com.socialhub.common.enums.DateFormat;
import com.socialhub.common.enums.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DtoValidation {


    public static void validateGender(String gender,Map<String,Object > errorMap){

        mandatoryCheck("Gender",gender,errorMap );


        try {
            Gender g = Gender.valueOf(gender.trim().toUpperCase());
            if(Objects.isNull(g)){

                errorMap.put("Message","Invalid gender field "+gender);
//            throw new ServiceException(errorMap);
            }
        }catch (Exception e){
            errorMap.put("Message","Invalid gender field "+gender);
        }


    }

    public static void mandatoryCheck(String fieldName,String fieldValue,Map<String,Object > errorMap){



        if(Objects.isNull(fieldValue) || fieldValue.trim().equalsIgnoreCase("")){
            errorMap.put(fieldName,"Can not be empty");
//            throw new ServiceException(errorMap);
        }
    }

    public static void mandatoryCheck(String fieldName,Long fieldValue,Map<String,Object > errorMap){


        if(Objects.isNull(fieldValue) || fieldValue == 0l){
            errorMap.put(fieldName,"Can not be empty");
//            throw new ServiceException(errorMap);
        }
    }

    public static void validateDate(String fieldName,String date, Map<String,Object > errorMap){

        if(fieldName.equalsIgnoreCase("dob")){
            mandatoryCheck("Dob",date,errorMap);
        }


        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern(DateFormat.FRONT_END.getValue()));
        }catch (Exception e){

            errorMap.put(fieldName,"Invalid Date "+date);
//            throw new ServiceException(errorMap);
        }
    }

    public static void validateEmail(String email,Map<String,Object > errorMap)
    {
        mandatoryCheck("Email",email,errorMap);

        // String emailRegex = "[a-zA-Z0-9._]+[@]{1}[a-zA-Z]+[.]{1}[a-zA-Z]+";
        String emailRegex = "[a-zA-Z0-9._]+[@]{1}[a-zA-Z]+[.]{1}[a-zA-Z.]+";


        Pattern pat = Pattern.compile(emailRegex);

        boolean matches = pat.matcher(email).matches();

        if(!matches){
            errorMap.put("Email","Invalid email "+email);
//            throw new ServiceException(errorMap);
        }
    }

    public static void validateMobileNumber(String phone, Map<String,Object > errorMap)
    {
        mandatoryCheck("Phone",phone,errorMap);

        // Regex to check string contains only digits
        String regex = "[0-9/-]{7,16}";
        Pattern p = Pattern.compile(regex);


        Matcher m = p.matcher(phone);
        boolean matches = m.matches();

        if(!matches){
            errorMap.put("Phone","Invalid Phone no "+phone);
//            throw new ServiceException(errorMap);
        }
    }









}
