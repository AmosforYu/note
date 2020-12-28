package com.yyb.learn.jbusine.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @author Yamos
 * @description AreaFeignFallBack
 * @date 2020/12/28 0028 15:08
 */
@Component
public class AreaFeignFallBack implements AreaFeign{

    @Override
    public JSONObject getAreaInfoByPhone(String phone) {
        JSONObject fallback = new JSONObject();
        fallback.put("desc","让请求飞一会儿");

        return fallback;
    }
}
