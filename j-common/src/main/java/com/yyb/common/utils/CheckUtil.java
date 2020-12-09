/*
 * This software is the confidential and proprietary information of
 * XXXX Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.yyb.common.utils;

import com.yyb.common.dtos.error.Error;
import com.yyb.common.dtos.error.MyException;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

/**
 * @Type ParamCheckUtil.java
 * @Desc 
 * @author wangfeng
 * @date 2018年8月24日 下午4:59:57
 * @version 
 */
public class CheckUtil {

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^1\\d{10}$";

    public static boolean isPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            throw new MyException(Error.PARAM_ERROR, "手机号不可以为空 ");
        }

        if (phone.length() > 20) {
            throw new MyException(Error.PARAM_ERROR, "号码长度最多20位 ");
        }

        return Pattern.matches(REGEX_MOBILE, phone);
    }


}