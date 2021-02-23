package com.yyb.learn.jarea.service;

import com.alibaba.fastjson.JSONObject;
import com.yyb.common.dtos.response.RespBody;
import com.yyb.learn.jarea.dao.AreaDao;
import com.yyb.learn.jarea.entity.AreaInfoDto;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Yamos
 * @description AreaService
 * @date 2020/12/24 0024 14:46
 */
@Service
public class AreaService {

    private static final Logger LOG = LoggerFactory.getLogger(AreaService.class);

    @Autowired
    private AreaDao areaDao;

    @Async("area-executor")
    public void getAreaInfoByPhone(DeferredResult<JSONObject> deferredResult, String phone) {
        try {
            JSONObject result = getAreaInfoResult(phone);
            deferredResult.setResult(result);
        } catch (Exception e) {
            deferredResult.setErrorResult(e);
        }
    }

    private JSONObject getAreaInfoResult(String phone) {
        if (isNotPhone(phone)) {
            return RespBody.failCodeMsg(10001, "请传入正确手机号");
        }

        String phonePre = formatPhonePre(phone);

        String cacheValue = getAreaInfoFromCache(phonePre);
        if (StringUtils.isNotEmpty(cacheValue)) {
            return RespBody.successData(parseCacheToAreaInfo(cacheValue));
        }

        AreaInfoDto areaInfo = getAreaInfoFromDB(phonePre);

        if (null == areaInfo) {
            areaInfo = getAreaFromAliyun(phone);
        }

        if (null == areaInfo) {
            return RespBody.failCodeMsg(10002, "未查到对应的归属地信息");
        }

        storeAreaToCache(phonePre, areaInfo);

        return RespBody.successData(areaInfo);
    }

    private void storeAreaToCache(String phonePre, AreaInfoDto areaInfo) {
        //todo: 将号段信息保存到缓存中
    }

    private AreaInfoDto getAreaFromAliyun(String phone) {
        //todo: 缺失号段信息可通过其他平台获取补充
        return null;
    }

    private AreaInfoDto getAreaInfoFromDB(String phonePre) {
        return areaDao.getAreaInfoByPhone(phonePre);
    }

    private AreaInfoDto parseCacheToAreaInfo(String cacheValue) {

        //todo: 缓存取出的数据格式化成封装对象
        return null;
    }

    private String getAreaInfoFromCache(String phonePre) {

        return "";
    }

    private String formatPhonePre(String phone) {
        return phone.substring(0, 7);
    }

    private boolean isNotPhone(String phone) {
        return StringUtils.isEmpty(phone)
                || "-1".equals(phone)
                || phone.length() < 7
                || !phone.startsWith("1")
                || phone.startsWith("10")
                || phone.startsWith("11")
                || phone.startsWith("12");
    }
}
