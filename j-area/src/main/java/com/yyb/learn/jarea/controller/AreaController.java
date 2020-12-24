package com.yyb.learn.jarea.controller;

import com.yyb.learn.jarea.entity.AreaInfoDto;
import com.yyb.learn.jarea.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yamos
 * @description AreaController
 * @date 2020/12/24 0024 14:47
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value ="/phone/area", method = RequestMethod.GET)
    public AreaInfoDto getAreaInfoByPhone(@RequestParam("phone") String phone) {
        return areaService.getAreaInfoByPhone(phone);
    }


}
