package com.socialhub.common.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ActiveInactiveStatusUtil {


    private static  Integer ACTIVE;

    private static  Integer INACTIVE;

    public ActiveInactiveStatusUtil(@Value("${status.active}") Integer ACTIVE,@Value("${status.inactive}") Integer INACTIVE) {
        this.ACTIVE = ACTIVE;
        this.INACTIVE = INACTIVE;
    }

    public static Integer getACTIVE() {
        return ACTIVE;
    }

    public  static Integer getINACTIVE() {
        return INACTIVE;
    }
}
