package com.socialhub.common.utility;

import com.socialhub.dto.ResponseData;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {


    private  final String SUCCESS_MESSAGE = "Successful";

    private  final String FAILED_MESSAGE = "Failure";


    public  ResponseData successResponse(String message,Object data){
        return ResponseData.builder()
                .message(message)
                .status(true)
                .data(data)
                .build();
    }


    public  ResponseData successResponse(Object data){
        return ResponseData.builder()
                .message(SUCCESS_MESSAGE)
                .status(true)
                .data(data)
                .build();
    }

    public  ResponseData failureResponse(String message,Object data){
        return ResponseData.builder()
                .message(message)
                .status(false)
                .data(data)
                .build();
    }
    public  ResponseData failureResponse(Object data){
        return ResponseData.builder()
                .message(FAILED_MESSAGE)
                .status(false)
                .data(data)
                .build();
    }

    public  ResponseData failureResponse(){
        return ResponseData.builder()
                .message(FAILED_MESSAGE)
                .status(false)
                .data(null)
                .build();
    }
}
