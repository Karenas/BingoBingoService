package com.gmself.bingobingo.module.subject.constant;

/**
 * 打卡接口的返回结果码
 * */

public class RespCode_punch {

    public final static int SUCCESS = 0;
    public final static int NO_PHONE_NUMBER = SUCCESS+1;
    public final static int NO_DEVICE_ID = NO_PHONE_NUMBER+1;
    public final static int DATABASE_FAIL = NO_DEVICE_ID+1;

}
