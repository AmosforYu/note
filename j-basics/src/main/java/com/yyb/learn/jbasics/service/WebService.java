package com.yyb.learn.jbasics.service;

import com.alibaba.fastjson.JSONObject;
import com.yyb.common.dtos.error.Error;
import com.yyb.common.dtos.error.MyException;
import com.yyb.learn.jbasics.dao.WebDao;
import com.yyb.learn.jbasics.feign.AreaFeign;
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
public class WebService {
    private static final Logger LOG = LoggerFactory.getLogger(WebService.class);

    @Autowired
    private WebDao webDao;

    @Autowired
    private AreaFeign areaFeign;

    public String helloWorld() {
        return "HELLO WORLD !";
    }

    public Map<String, String> getAreaInfoByPhonePre(String phone) {
        Map<String, String> areaInfoByPhonePre = webDao.getAreaInfoByPhonePre(formatPhonePre(phone));
        return areaInfoByPhonePre;
    }

    private String formatPhonePre(String phone) {
        if ("".equals(phone) || null == phone) {
            throw new MyException(Error.PARAM_ERROR, "请传入正确手机号");
        }

        return phone.substring(0, 7);
    }

    public JSONObject getAreaDemo(String phone) {
        JSONObject areaInfo = areaFeign.getAreaInfoByPhone(phone);
        return areaInfo;
    }
}
