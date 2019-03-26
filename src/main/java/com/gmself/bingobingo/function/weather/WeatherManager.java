//
//  Created by  fred on 2016/10/26.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.gmself.bingobingo.function.weather;

import com.alibaba.cloudapi.sdk.constant.SdkConstant;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import java.io.IOException;



//_墨迹天气天气信息服务cityid免费版
public class WeatherManager{

    private static String token = "677282c2f1b3d718152c4e25ed434bc4";

    static{
        //HTTP Client init
        HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
        httpParam.setAppKey("25890866");
        httpParam.setAppSecret("739aac87a6c6a4566adccc794be5bd3e");
        HttpApiClient.getInstance().init(httpParam);

    }

    /**
     * 精简预报3天
     * */
    public static void HttpTestJJ3(){
        HttpApiClient.getInstance().JJYB3(token , "2" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * 精简预报3天
     * */
    public static void HttpSyncTestJJ3(){
        ApiResponse response = HttpApiClient.getInstance().JJYB3_syncMode(token , "2");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    /**
     * 精简实况
     * */
    public static void HttpTestJJSK(){
        HttpApiClient.getInstance().JJSK(token , "2" , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * 精简实况
     * */
    public static void HttpSyncTestJJSK(){
        ApiResponse response = HttpApiClient.getInstance().JJSK_syncMode(token , "2");
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    /**
     * 精简AQI
     * */
    public static void HttpTestJJAQI(){
        HttpApiClient.getInstance().JJ_AQI("2" , token , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {
                try {
                    System.out.println(getResultString(response));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * 精简AQI
     * */
    public static void HttpSyncTestJJAQI(){
        ApiResponse response = HttpApiClient.getInstance().JJ_AQI_syncMode("2" , token);
        try {
            System.out.println(getResultString(response));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }




    private static String getResultString(ApiResponse response) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("Response from backend server").append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        result.append("ResultCode:").append(SdkConstant.CLOUDAPI_LF).append(response.getCode()).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        if(response.getCode() != 200){
            result.append("Error description:").append(response.getHeaders().get("X-Ca-Error-Message")).append(SdkConstant.CLOUDAPI_LF).append(SdkConstant.CLOUDAPI_LF);
        }

        result.append("ResultBody:").append(SdkConstant.CLOUDAPI_LF).append(new String(response.getBody() , SdkConstant.CLOUDAPI_ENCODING));

        return result.toString();
    }

}
