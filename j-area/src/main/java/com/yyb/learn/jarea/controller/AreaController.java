package com.yyb.learn.jarea.controller;

import com.alibaba.fastjson.JSONObject;
import com.yyb.learn.jarea.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yamos
 * @description AreaController
 * @date 2020/12/24 0024 14:47
 */
@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;

    /**
     * 根据手机号获取归属地信息
     * @param phone
     * @return
     */
    @RequestMapping(value ="/phone/area", method = RequestMethod.GET)
    public JSONObject getAreaInfoByPhone(@RequestParam("phone") String phone) {
        return areaService.getAreaInfoByPhone(phone);
    }


}
