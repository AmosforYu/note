package com.yyb.learn.jarea.entity;

/**
 * @author Yamos
 * @description Area2Province
 * @date 2020/12/24 0024 14:58
 */
public class ProvinceCityDO {
    /*中国，省名，市名*/
    private String mergerName;
    /*市名*/
    private String cityName;
    /*省码*/
    private String provinceCode;
    /*市码*/
    private String cityCode;
    /*邮编*/
    private String zipCode;

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
