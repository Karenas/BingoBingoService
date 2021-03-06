package com.gmself.bingobingo.function.statistics.entity;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Component("userLocationStatistics")
@Alias(value = "userLocationStatistics")
public class UserLocationStatistics {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location_statistics.id_
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location_statistics.location_id_
     *
     * @mbggenerated
     */
    private String locationId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location_statistics.total_count_
     *
     * @mbggenerated
     */
    private Integer totalCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_location_statistics.valid_count_
     *
     * @mbggenerated
     */
    private Integer validCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_location_statistics.id_
     *
     * @return the value of user_location_statistics.id_
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_location_statistics.id_
     *
     * @param id the value for user_location_statistics.id_
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_location_statistics.location_id_
     *
     * @return the value of user_location_statistics.location_id_
     *
     * @mbggenerated
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_location_statistics.location_id_
     *
     * @param locationId the value for user_location_statistics.location_id_
     *
     * @mbggenerated
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId == null ? null : locationId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_location_statistics.total_count_
     *
     * @return the value of user_location_statistics.total_count_
     *
     * @mbggenerated
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_location_statistics.total_count_
     *
     * @param totalCount the value for user_location_statistics.total_count_
     *
     * @mbggenerated
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_location_statistics.valid_count_
     *
     * @return the value of user_location_statistics.valid_count_
     *
     * @mbggenerated
     */
    public Integer getValidCount() {
        return validCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_location_statistics.valid_count_
     *
     * @param validCount the value for user_location_statistics.valid_count_
     *
     * @mbggenerated
     */
    public void setValidCount(Integer validCount) {
        this.validCount = validCount;
    }
}