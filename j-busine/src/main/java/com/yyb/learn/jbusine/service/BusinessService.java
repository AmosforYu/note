package com.yyb.learn.jbusine.service;

import com.yyb.learn.jbusine.dao.BusinessDao;
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

    public String helloWorld() {
        return "HELLO WORLD !";
    }

    public Map<Object, Object> getHealthInfoFromBasics(int code, String version) {
        Map<String, String> areaInfoByPhonePre = businessDao.getAreaInfoByPhonePre("1823922");
        Map<Object, Object> map = basicsFeign.basicsHealth(code, areaInfoByPhonePre.get("provinceCode"));
        return map;
    }

}
