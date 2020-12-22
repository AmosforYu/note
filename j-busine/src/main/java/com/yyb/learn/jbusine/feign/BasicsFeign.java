package com.yyb.learn.jbusine.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Yamos
 * @description BasicsFeign
 * @date 2020/12/17 0017 15:42
 */
@FeignClient(value = "jbasics")
public interface BasicsFeign {

    @RequestMapping(path = "/learn/basics/basicsHealth", method = RequestMethod.GET)
    Map<Object, Object> basicsHealth(@RequestParam("errorNum") Integer errorNum,
                                            @RequestParam(value = "version", required = false) String version);
}
