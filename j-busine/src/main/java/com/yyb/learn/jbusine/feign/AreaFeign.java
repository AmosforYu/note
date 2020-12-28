package com.yyb.learn.jbusine.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Yamos
 * @description AreaFeign
 * @date 2020/12/25 0025 17:51
 */
@FeignClient(name = "jarea", fallback = AreaFeignFallBack.class)
public interface AreaFeign {

    @RequestMapping(value ="/learn/area/phone/area", method = RequestMethod.GET)
    public JSONObject getAreaInfoByPhone(@RequestParam("phone") String phone);
}
