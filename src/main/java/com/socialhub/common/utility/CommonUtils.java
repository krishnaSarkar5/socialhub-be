package com.socialhub.common.utility;

import com.socialhub.common.enums.DateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtils {

    public static String getDateInFrontendDateFormat(LocalDateTime date){
       return date.format(DateTimeFormatter.ofPattern(DateFormat.FRONT_END.getValue()));
    }
}
