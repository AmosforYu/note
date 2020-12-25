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
    private static final Logger LOG = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    @RequestMapping(value ="/phone/area", method = RequestMethod.GET)
    public JSONObject getAreaInfoByPhone(@RequestParam("phone") String phone) {
        LOG.info("[{}] Enter AreaController.getAreaInfoByPhone ", phone);
        return areaService.getAreaInfoByPhone(phone);
    }


}
