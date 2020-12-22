package com.yyb.learn.jbusine.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @description: 视图层dao
 * @author: Mr.Yu
 * @date: 2020-08-14 14:01
 **/
@Mapper
public interface BusinessDao {

    @Select("SELECT province provinceName, city cityName, isp, area_code areaCode, province_code provinceCode," +
            "post_code postCode FROM phone WHERE phone=#{phone} ")
    Map<String, String> getAreaInfoByPhonePre(@Param("phone") String phonePrefix);
}
