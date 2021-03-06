package com.gmself.bingobingo.function.weather.entity;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Component("hfCity")
@Alias(value = "hfCity")
public class HfCity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.City_ID
     *
     * @mbggenerated
     */
    private String cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.City_EN
     *
     * @mbggenerated
     */
    private String cityEn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.City_CN
     *
     * @mbggenerated
     */
    private String cityCn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.Country_code
     *
     * @mbggenerated
     */
    private String countryCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.Country_EN
     *
     * @mbggenerated
     */
    private String countryEn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.Country_CN
     *
     * @mbggenerated
     */
    private String countryCn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.Province_EN
     *
     * @mbggenerated
     */
    private String provinceEn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.Province_CN
     *
     * @mbggenerated
     */
    private String provinceCn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.Admin_district_EN
     *
     * @mbggenerated
     */
    private String adminDistrictEn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.Admin_district_CN
     *
     * @mbggenerated
     */
    private String adminDistrictCn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.Latitude
     *
     * @mbggenerated
     */
    private String latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.Longitude
     *
     * @mbggenerated
     */
    private String longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_city.AD_code
     *
     * @mbggenerated
     */
    private String adCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.id
     *
     * @return the value of hf_city.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.id
     *
     * @param id the value for hf_city.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.City_ID
     *
     * @return the value of hf_city.City_ID
     *
     * @mbggenerated
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.City_ID
     *
     * @param cityId the value for hf_city.City_ID
     *
     * @mbggenerated
     */
    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.City_EN
     *
     * @return the value of hf_city.City_EN
     *
     * @mbggenerated
     */
    public String getCityEn() {
        return cityEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.City_EN
     *
     * @param cityEn the value for hf_city.City_EN
     *
     * @mbggenerated
     */
    public void setCityEn(String cityEn) {
        this.cityEn = cityEn == null ? null : cityEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.City_CN
     *
     * @return the value of hf_city.City_CN
     *
     * @mbggenerated
     */
    public String getCityCn() {
        return cityCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.City_CN
     *
     * @param cityCn the value for hf_city.City_CN
     *
     * @mbggenerated
     */
    public void setCityCn(String cityCn) {
        this.cityCn = cityCn == null ? null : cityCn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.Country_code
     *
     * @return the value of hf_city.Country_code
     *
     * @mbggenerated
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.Country_code
     *
     * @param countryCode the value for hf_city.Country_code
     *
     * @mbggenerated
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.Country_EN
     *
     * @return the value of hf_city.Country_EN
     *
     * @mbggenerated
     */
    public String getCountryEn() {
        return countryEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.Country_EN
     *
     * @param countryEn the value for hf_city.Country_EN
     *
     * @mbggenerated
     */
    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn == null ? null : countryEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.Country_CN
     *
     * @return the value of hf_city.Country_CN
     *
     * @mbggenerated
     */
    public String getCountryCn() {
        return countryCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.Country_CN
     *
     * @param countryCn the value for hf_city.Country_CN
     *
     * @mbggenerated
     */
    public void setCountryCn(String countryCn) {
        this.countryCn = countryCn == null ? null : countryCn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.Province_EN
     *
     * @return the value of hf_city.Province_EN
     *
     * @mbggenerated
     */
    public String getProvinceEn() {
        return provinceEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.Province_EN
     *
     * @param provinceEn the value for hf_city.Province_EN
     *
     * @mbggenerated
     */
    public void setProvinceEn(String provinceEn) {
        this.provinceEn = provinceEn == null ? null : provinceEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.Province_CN
     *
     * @return the value of hf_city.Province_CN
     *
     * @mbggenerated
     */
    public String getProvinceCn() {
        return provinceCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.Province_CN
     *
     * @param provinceCn the value for hf_city.Province_CN
     *
     * @mbggenerated
     */
    public void setProvinceCn(String provinceCn) {
        this.provinceCn = provinceCn == null ? null : provinceCn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.Admin_district_EN
     *
     * @return the value of hf_city.Admin_district_EN
     *
     * @mbggenerated
     */
    public String getAdminDistrictEn() {
        return adminDistrictEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.Admin_district_EN
     *
     * @param adminDistrictEn the value for hf_city.Admin_district_EN
     *
     * @mbggenerated
     */
    public void setAdminDistrictEn(String adminDistrictEn) {
        this.adminDistrictEn = adminDistrictEn == null ? null : adminDistrictEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.Admin_district_CN
     *
     * @return the value of hf_city.Admin_district_CN
     *
     * @mbggenerated
     */
    public String getAdminDistrictCn() {
        return adminDistrictCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.Admin_district_CN
     *
     * @param adminDistrictCn the value for hf_city.Admin_district_CN
     *
     * @mbggenerated
     */
    public void setAdminDistrictCn(String adminDistrictCn) {
        this.adminDistrictCn = adminDistrictCn == null ? null : adminDistrictCn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.Latitude
     *
     * @return the value of hf_city.Latitude
     *
     * @mbggenerated
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.Latitude
     *
     * @param latitude the value for hf_city.Latitude
     *
     * @mbggenerated
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.Longitude
     *
     * @return the value of hf_city.Longitude
     *
     * @mbggenerated
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.Longitude
     *
     * @param longitude the value for hf_city.Longitude
     *
     * @mbggenerated
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_city.AD_code
     *
     * @return the value of hf_city.AD_code
     *
     * @mbggenerated
     */
    public String getAdCode() {
        return adCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_city.AD_code
     *
     * @param adCode the value for hf_city.AD_code
     *
     * @mbggenerated
     */
    public void setAdCode(String adCode) {
        this.adCode = adCode == null ? null : adCode.trim();
    }
}