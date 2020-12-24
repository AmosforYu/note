package com.yyb.learn.jarea.entity;

/**
 * @author Yamos
 * @description PhoneAreaDO
 * @date 2020/12/24 0024 15:47
 */
public class PhoneAreaDO {
    /*号段*/
    private String phone;
    /*省名*/
    private String provinceName;
    /*市名*/
    private String cityName;
    /*省码*/
    private String provinceCode;
    /*市码*/
    private String cityCode;
    /*邮编*/
    private String zipCode;
    /*运营商名称*/
    private String isp;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }
}
