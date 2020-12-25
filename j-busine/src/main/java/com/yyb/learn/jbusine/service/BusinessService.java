package com.yyb.learn.jbusine.service;

import com.alibaba.fastjson.JSONObject;
import com.yyb.learn.jbusine.dao.BusinessDao;
import com.yyb.learn.jbusine.feign.AreaFeign;
import com.yyb.learn.jbusine.feign.BasicsFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description: 表现层service
 * @author: Mr.Yu
 * @date: 2020-08-14 15:36
 **/
@Service
public class BusinessService {
    private static final Logger LOG = LoggerFactory.getLogger(BusinessService.class);

    @Autowired
    private BusinessDao businessDao;

    @Autowired
    private BasicsFeign basicsFeign;

    @Autowired
    private AreaFeign areaFeign;

    public String helloWorld() {
        return "HELLO WORLD !";
    }

    public Map<Object, Object> getHealthInfoFromBasics(int code, String version) {
        JSONObject areaInfoByPhone = getAreaInfo("1823922xxxx");
        Map<Object, Object> map = basicsFeign.basicsHealth(code, areaInfoByPhone.get("provinceCode"));
        return map;
    }

    private JSONObject getAreaInfo(String phone) {
        JSONObject areaInfo = areaFeign.getAreaInfoByPhone(phone);
        int respCode = areaInfo.getIntValue("respCode");
        if (0 != respCode) {
            areaInfo.remove("data");
            return areaInfo;
        }

        return (JSONObject) areaInfo.get("data");
    }

}
