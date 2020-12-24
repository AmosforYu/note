package com.yyb.learn.jarea.dao;

import com.yyb.learn.jarea.entity.AreaInfoDto;
import com.yyb.learn.jarea.entity.PhoneAreaDO;
import com.yyb.learn.jarea.entity.ProvinceCityDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author Yamos
 * @description AreaDao
 * @date 2020/12/24 0024 14:45
 */
@Mapper
public interface AreaDao {

    /* 数据库area字段为普通索引 */
    @Select("SELECT merger_name mergerName,name cityName,province provinceCode,area areaCode,zip_code zipCode " +
            "FROM area2province WHERE area=#{cityCode}")
    ProvinceCityDO getAreaInfoByCityCode(@Param("cityCode") String cityCode);

    /* 数据库phone字段为普通索引 */
    @Select("SELECT province provinceName, province_code provinceCode, city cityName, area_code cityCode, isp " +
            "FROM phone WHERE phone=#{phone}")
    PhoneAreaDO getArea(@Param("phone") String phone);

    /* 数据库phone字段为普通索引 */
    @Select("SELECT province provinceName, province_code provinceCode, city cityName, area_code cityCode " +
            "FROM phone WHERE phone=#{phone}")
    AreaInfoDto getAreaInfoByPhone(@Param("phone") String phone);
}
