package com.yyb.learn.jbasics.utils;

import java.security.MessageDigest;

/**
 * @author yyb
 * @date 2019/12/4 15:02
 */
public class SHA1Encode {

    private static String token = "1d6c9bbe15ec4a09974cdef1c2e7543b";//online
//    private static String token = "7fcaa8f540fb4e048ed6a1fe9291e4b7";//test
//    private static String token = "38e599d280td403e8770534ccce3ade3";
    private static String timestamp = "";
    private static String param = "{\"msisdn\":\"17539273838\"}";

//    public static void main(String[] args) {
//        StringBuilder builder = new StringBuilder();
//        timestamp = String.valueOf(System.currentTimeMillis());
//        builder.append(token).append(timestamp).append(param);
//
//
//        System.out.println("timestam=" + timestamp);
//        System.out.println("builder=" + builder);
//        System.out.println("signature=" + getSha1(builder.toString()));
//    }

    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
}
