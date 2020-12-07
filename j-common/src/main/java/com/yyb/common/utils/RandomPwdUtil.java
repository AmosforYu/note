package com.yyb.common.utils;

import org.apache.commons.lang.RandomStringUtils;

/**
 * The Class VirtualImsPasswordUtil.
 */
public class RandomPwdUtil {

    /** The Constant CANDIDATES. */
    private static final String CANDIDATES = "abcdefghijklmnopqrstuvwxyz0123456789";
    
    /** The Constant LENGTH. */
    private static final int LENGTH = 8;

    /**
     * New password.
     *
     * @param length the length
     * @return the string
     */
    public static String newPassword(int length) {
        if (length <= 0) {
            length = LENGTH;
        }

        return RandomStringUtils.random(length, CANDIDATES);
    }
}
