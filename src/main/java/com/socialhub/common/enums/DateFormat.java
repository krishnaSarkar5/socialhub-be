package com.socialhub.common.enums;

public enum DateFormat {

    DB_FORMAT("yyyy/MM/dd"),
    FRONT_END("dd/MM/yyyy");

    private final String value;

    private DateFormat(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}
