package com.yyb.learn.jbasics.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 断路器使用-【服务降级】-1.Feign实现方式：实现Feign接口的函数，重写方法即为对应的fallback()
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
