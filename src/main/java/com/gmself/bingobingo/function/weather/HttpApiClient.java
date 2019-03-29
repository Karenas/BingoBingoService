//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package com.gmself.bingobingo.function.weather;
import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.alibaba.cloudapi.sdk.enums.ParamPosition;

/**
 * _墨迹天气天气信息服务cityid免费版
 * */
public class HttpApiClient extends ApacheHttpClient{

    public final static String HOST = "freecityid.market.alicloudapi.com";
    static HttpApiClient instance = new HttpApiClient();
    public static HttpApiClient getInstance(){return instance;}

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTP);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }




    public void JJYB3(String token , String cityId , ApiCallback callback) {
        String path = "/whapi/json/alicityweather/briefforecast3days";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM , path);
        request.addParam("token" , token , ParamPosition.BODY , false);
        request.addParam("cityId" , cityId , ParamPosition.BODY , true);
        sendAsyncRequest(request , callback);
    }

    public ApiResponse JJYB3_syncMode(String token , String cityId) {
        String path = "/whapi/json/alicityweather/briefforecast3days";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM , path);
        request.addParam("token" , token , ParamPosition.BODY , false);
        request.addParam("cityId" , cityId , ParamPosition.BODY , true);
        return sendSyncRequest(request);
    }
    public void JJSK(String token , String cityId , ApiCallback callback) {
        String path = "/whapi/json/alicityweather/briefcondition";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM , path);
        request.addParam("token" , token , ParamPosition.BODY , false);
        request.addParam("cityId" , cityId , ParamPosition.BODY , true);



        sendAsyncRequest(request , callback);
    }

    public ApiResponse JJSK_syncMode(String token , String cityId) {
        String path = "/whapi/json/alicityweather/briefcondition";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM , path);
        request.addParam("token" , token , ParamPosition.BODY , false);
        request.addParam("cityId" , cityId , ParamPosition.BODY , true);
        return sendSyncRequest(request);
    }
    public void JJ_AQI(String cityId , String token , ApiCallback callback) {
        String path = "/whapi/json/alicityweather/briefaqi";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM , path);
        request.addParam("cityId" , cityId , ParamPosition.BODY , true);
        request.addParam("token" , token , ParamPosition.BODY , false);
        sendAsyncRequest(request , callback);
    }

    public ApiResponse JJ_AQI_syncMode(String cityId , String token) {
        String path = "/whapi/json/alicityweather/briefaqi";
        ApiRequest request = new ApiRequest(HttpMethod.POST_FORM , path);
        request.addParam("cityId" , cityId , ParamPosition.BODY , true);
        request.addParam("token" , token , ParamPosition.BODY , false);
        return sendSyncRequest(request);
    }

}