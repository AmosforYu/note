package com.yyb.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

public class MD5 {

	/**
	 * 签名字符串.
	 *
	 * @param text
	 *            需要签名的字符串
	 * @param key
	 *            密钥
	 * @param inputCharset
	 *            编码格式
	 * @return 签名结果
	 */
	public static String sign(String text, String key, String inputCharset) {
		text = text + key;
		return DigestUtils.md5Hex(getContentBytes(text, inputCharset));
	}

	/**
	 * 签名字符串.
	 *
	 * @param text
	 *            需要签名的字符串
	 * @param sign
	 *            签名结果
	 * @param key
	 *            密钥
	 * @param inputCharset
	 *            编码格式
	 * @return 签名结果
	 */
	private static boolean verify(String text, String sign, String key,
			String inputCharset) {
		text = text + key;
		String mysign = DigestUtils.md5Hex(getContentBytes(text, inputCharset));
		return mysign.equals(sign);
	}

	/**
	 * 签名字符串.
	 *
	 * @param text
	 *            需要签名的字符串
	 * @param sign
	 *            签名结果
	 * @param key
	 *            密钥
	 * @return 签名结果
	 */
	public static boolean verify(String text, String sign, String key) {
		return verify(text, sign, key, "utf-8");
	}

	/**
	 * Gets the content bytes.
	 *
	 * @param content
	 *            the content
	 * @param charset
	 *            the charset
	 * @return the content bytes
	 */
	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:"
					+ charset);
		}
	}

}
