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
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gmself.bingobingo.function.weather.entity.Forecast;
import com.gmself.bingobingo.function.weather.entity.WeatherApiResult;
import com.gmself.bingobingo.function.weather.entity.WeatherData;
import com.gmself.bingobingo.function.weather.service.Impl.WeatherServiceImpl;
import com.gmself.bingobingo.function.weather.service.WeatherService;
import com.gmself.bingobingo.module.subject.db.dao.WeatherMapper;
import com.gmself.bingobingo.module.subject.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


//_墨迹天气天气信息服务cityid免费版
public class WeatherManager{

    private static String token = "677282c2f1b3d718152c4e25ed434bc4";

    private static WeatherManager instance;

    public static WeatherManager getInstance(){
        if (null == instance){
            instance = new WeatherManager();
        }
        return instance;
    }

    private WeatherService weatherService;


    public WeatherManager() {
        weatherService = new WeatherServiceImpl();

        HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
        httpParam.setAppKey("25890866");
        httpParam.setAppSecret("739aac87a6c6a4566adccc794be5bd3e");
        HttpApiClient.getInstance().init(httpParam);
    }



    /**
     * 精简预报3天
     * */
    public void HttpJJ3(String cityID){

//        String resBody = "{\"code\":0,\"data\":{\"city\":{\"cityId\":2,\"counname\":\"中国\",\"ianatimezone\":\"Asia\\/Shanghai\",\"name\":\"北京市\",\"pname\":\"北京市\",\"timezone\":\"8\"},\"forecast\":[{\"conditionDay\":\"啊啊啊啊多云\",\"conditionIdDay\":\"1\",\"conditionIdNight\":\"31\",\"conditionNight\":\"多云\",\"predictDate\":\"2019-03-28\",\"tempDay\":\"11\",\"tempNight\":\"2\",\"updatetime\":\"2019-03-28 14:05:00\",\"windDegreesDay\":\"180\",\"windDegreesNight\":\"180\",\"windDirDay\":\"南风\",\"windDirNight\":\"南风\",\"windLevelDay\":\"3\",\"windLevelNight\":\"3\"},{\"conditionDay\":\"多云\",\"conditionIdDay\":\"1\",\"conditionIdNight\":\"30\",\"conditionNight\":\"晴\",\"predictDate\":\"2019-03-29\",\"tempDay\":\"13\",\"tempNight\":\"4\",\"updatetime\":\"2019-03-28 14:05:00\",\"windDegreesDay\":\"315\",\"windDegreesNight\":\"315\",\"windDirDay\":\"西北风\",\"windDirNight\":\"西北风\",\"windLevelDay\":\"3-4\",\"windLevelNight\":\"3-4\"},{\"conditionDay\":\"晴\",\"conditionIdDay\":\"0\",\"conditionIdNight\":\"30\",\"conditionNight\":\"晴\",\"predictDate\":\"2019-03-30\",\"tempDay\":\"13\",\"tempNight\":\"2\",\"updatetime\":\"2019-03-28 14:05:00\",\"windDegreesDay\":\"315\",\"windDegreesNight\":\"0\",\"windDirDay\":\"西北风\",\"windDirNight\":\"北风\",\"windLevelDay\":\"4-5\",\"windLevelNight\":\"3-4\"}]},\"msg\":\"success\",\"rc\":{\"c\":0,\"p\":\"success\"}}";
//        WeatherApiResult weather = JSON.parseObject(resBody, WeatherApiResult.class);

        HttpApiClient.getInstance().JJYB3(token , cityID , new ApiCallback() {
            @Override
            public void onFailure(ApiRequest request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(ApiRequest request, ApiResponse response) {

                String resBody = new String(response.getBody() , SdkConstant.CLOUDAPI_ENCODING);
                WeatherApiResult weather = JSON.parseObject(resBody, WeatherApiResult.class);
            //{"code":0,"data":{"city":{"cityId":2,"counname":"中国","ianatimezone":"Asia\/Shanghai","name":"北京市","pname":"北京市","timezone":"8"},"forecast":[{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"31","conditionNight":"多云","predictDate":"2019-03-28","tempDay":"11","tempNight":"2","updatetime":"2019-03-28 14:05:00","windDegreesDay":"180","windDegreesNight":"180","windDirDay":"南风","windDirNight":"南风","windLevelDay":"3","windLevelNight":"3"},{"conditionDay":"多云","conditionIdDay":"1","conditionIdNight":"30","conditionNight":"晴","predictDate":"2019-03-29","tempDay":"13","tempNight":"4","updatetime":"2019-03-28 14:05:00","windDegreesDay":"315","windDegreesNight":"315","windDirDay":"西北风","windDirNight":"西北风","windLevelDay":"3-4","windLevelNight":"3-4"},{"conditionDay":"晴","conditionIdDay":"0","conditionIdNight":"30","conditionNight":"晴","predictDate":"2019-03-30","tempDay":"13","tempNight":"2","updatetime":"2019-03-28 14:05:00","windDegreesDay":"315","windDegreesNight":"0","windDirDay":"西北风","windDirNight":"北风","windLevelDay":"4-5","windLevelNight":"3-4"}]},"msg":"success","rc":{"c":0,"p":"success"}}
                if (weather!=null){
                    updateDB(weather.getData().getForecast(), weather.getData().getCity().getCityId());
                }
//                try {
//                    System.out.println(getResultString(response));
//                }catch (Exception ex){
//                    ex.printStackTrace();
//                }
            }
        });
    }

    @Transactional()
    public void updateDB(List<Forecast> weatherList, int cityID){
        if (weatherList == null){
            return;
        }

        Weather weather = null;
        for (Forecast bean : weatherList) {
            weather = new Weather();
            weather.setCityId(cityID);
            weather.setConditionDay(bean.getConditionDay());
            weather.setConditionIdDay(bean.getConditionIdDay());
            weather.setConditionIdNight(bean.getConditionIdNight());
            weather.setConditionNight(bean.getConditionNight());
            weather.setPredictDate(bean.getPredictDate());
            weather.setTempDay(bean.getTempDay());
            weather.setTempNight(bean.getTempNight());
            weather.setUpdateTime(bean.getUpdatetime());
            weather.setWindDirDay(bean.getWindDirDay());
            weather.setWindDirNight(bean.getWindDirNight());
            weather.setWindLevelDay(bean.getWindLevelDay());
            weather.setWindLevelNight(bean.getWindLevelNight());

            weatherService.insertWeather(weather);
        }





    }

//    /**
//     * 精简预报3天
//     * */
//    public static void HttpSyncTestJJ3(){
//        ApiResponse response = HttpApiClient.getInstance().JJYB3_syncMode(token , "2");
//        try {
//            System.out.println(getResultString(response));
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 精简实况
//     * */
//    public static void HttpTestJJSK(String cityID){
//        HttpApiClient.getInstance().JJSK(token , cityID , new ApiCallback() {
//            @Override
//            public void onFailure(ApiRequest request, Exception e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(ApiRequest request, ApiResponse response) {
//
//
//                try {
//                    System.out.println(getResultString(response));
//                }catch (Exception ex){
//                    ex.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * 精简实况
//     * */
//    public static void HttpSyncTestJJSK(){
//        ApiResponse response = HttpApiClient.getInstance().JJSK_syncMode(token , "2");
//        try {
//            System.out.println(getResultString(response));
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 精简AQI
//     * */
//    public static void HttpTestJJAQI(){
//        HttpApiClient.getInstance().JJ_AQI("2" , token , new ApiCallback() {
//            @Override
//            public void onFailure(ApiRequest request, Exception e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(ApiRequest request, ApiResponse response) {
//                try {
//                    System.out.println(getResultString(response));
//                }catch (Exception ex){
//                    ex.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * 精简AQI
//     * */
//    public static void HttpSyncTestJJAQI(){
//        ApiResponse response = HttpApiClient.getInstance().JJ_AQI_syncMode("2" , token);
//        try {
//            System.out.println(getResultString(response));
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }

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
