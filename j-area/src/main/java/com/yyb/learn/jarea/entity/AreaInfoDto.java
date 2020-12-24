package com.yyb.learn.jarea.entity;

/**
 * @author Yamos
 * @description CityInfoDto
 * @date 2020/12/24 0024 15:51
 */
public class AreaInfoDto {
    /*省名*/
    private String provinceName;
    /*市名*/
    private String cityName;
    /*省码*/
    private String provinceCode;
    /*市码*/
    private String cityCode;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
