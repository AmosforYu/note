package com.yyb.learn.jbusine.service;

import com.alibaba.fastjson.JSONObject;
import com.yyb.learn.jbusine.dao.BusinessDao;
import com.yyb.learn.jbusine.feign.AreaFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private AreaFeign areaFeign;

    public JSONObject getAreaInfoFromArea(String phone) {
        LOG.info("[{}] Enter get area info from area ", phone);
        JSONObject areaInfoByPhone = getAreaInfo(phone);
        if (!areaInfoByPhone.containsKey("provinceCode")) {
            return areaInfoByPhone;
        }

        areaInfoByPhone.put("busineDesc", "feign调用area模块查询归属地信息服务");
        return areaInfoByPhone;
    }

    private JSONObject getAreaInfo(String phone) {
        JSONObject areaInfo = areaFeign.getAreaInfoByPhone(phone);
        int respCode = areaInfo.getIntValue("respCode");
        if (0 != respCode) {
            areaInfo.remove("data");
            return areaInfo;
        }

        return areaInfo.getJSONObject("data");
    }

    public JSONObject getAreaDemo(String phone) {
        JSONObject areaInfo = areaFeign.getAreaInfoByPhone(phone);
        return areaInfo;
    }

}
