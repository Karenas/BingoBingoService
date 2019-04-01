package com.gmself.bingobingo.responseEntity;

public enum Resp_processWrongType {

    GENERAL("G"),

    WRONG_DATABASE("D"),

    ;

    private String value;

    Resp_processWrongType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
