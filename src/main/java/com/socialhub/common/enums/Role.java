package com.socialhub.common.enums;

public enum Role {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String value;
    private Role(String value){
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }

}
