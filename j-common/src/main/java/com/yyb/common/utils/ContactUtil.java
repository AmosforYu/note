package com.yyb.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class ContactUtil.
 */
public class ContactUtil {

    /** The Constant R_CONTACT_SPEC_CHAR. */
    private static final String R_CONTACT_SPEC_CHAR = "[- _`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\\\\n|\\\\r|\\\\t|[\\u4e00-\\u9fa5_a-zA-Z]+";

    /** The Constant P_CONTACT_SPEC_CHAR. */
    private static final Pattern P_CONTACT_SPEC_CHAR = Pattern.compile(R_CONTACT_SPEC_CHAR);

    /**
     * Process contact spec char.
     *
     * @param input
     *            the input
     * @return the string
     */
    public static String processContactSpecChar(String input) {
        if (input == null) {
            return null;
        }
        Matcher matcher = P_CONTACT_SPEC_CHAR.matcher(input);
        String result=matcher.find() ? input.replaceAll(R_CONTACT_SPEC_CHAR, "") : input;
        if (result.length()>17){
            result=result.substring(0,17);
        }
        return result;
    }

    /**
     * Hanyu2 pinyin.
     *
     * @param src
     *            the src
     * @return the string
     */
    public static String hanyu2Pinyin(String src) {
        char[] nums = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        char[] fonts = new char[] { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };

        char[] t1 = null;
        t1 = src.toCharArray();
        for (int i = 0; i < t1.length; i++) {
            if (Character.toString(t1[i]).matches("[0-9]")) {
                for (int j = 0; j < nums.length; j++) {
                    if (t1[i] == nums[j]) {
                        t1[i] = fonts[j];
                        break;
                    }
                }
            }
        }
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuilder builder = new StringBuilder();
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    builder.append(t2[0]).append(" ");
                } else {
                    builder.append(t1[i]);
                }
            }
            return builder.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return builder.toString();
    }

    /*
     * public static void main(String[] args) {
     * 
     * testRCONTACTSPECCHAR(); }
     */

    /**
     * Test rcontactspecchar.
     *
     * @param chineseLanguage the chinese language
     * @return the first letter
     */
    /*
     * private static void testRCONTACTSPECCHAR() { String str1 = "188 6710 3877"; Matcher matcher = P_CONTACT_SPEC_CHAR.matcher(str1);
     * System.out.println(matcher.find()); System.out.println(str1.replaceAll(P_CONTACT_SPEC_CHAR.pattern(), ""));
     * 
     * String str2 = "188-6710 3877"; Matcher matcher2 = P_CONTACT_SPEC_CHAR.matcher(str2); System.out.println(matcher2.find());
     * System.out.println(str2.replaceAll(P_CONTACT_SPEC_CHAR.pattern(), ""));
     * 
     * String str3 = "-188,6710,3877"; Matcher matcher3 = P_CONTACT_SPEC_CHAR.matcher(str3); System.out.println(matcher3.find());
     * System.out.println(str3.replaceAll(P_CONTACT_SPEC_CHAR.pattern(), ""));
     * 
     * String str4 = "-*#188,6710,3877"; Matcher matcher4 = P_CONTACT_SPEC_CHAR.matcher(str4); System.out.println(matcher4.find());
     * System.out.println(str3.replaceAll(P_CONTACT_SPEC_CHAR.pattern(), "")); }
     */
    // 获取中文的首字母
    public static String getFirstLetter(String chineseLanguage) {
        char[] clchars = chineseLanguage.trim().toCharArray();

        String hanyupinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);// 输出拼音全部大写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        try {
            String str = String.valueOf(clchars[0]);
            if (str.matches("^[\u2E80-\u9FFF]+$")) {// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母 ^[\u2E80-\u9FFF]+$
                String[] chars = PinyinHelper.toHanyuPinyinStringArray(clchars[0], defaultFormat);
                if (chars == null) {
                    hanyupinyin = "#";
                } else {
                    hanyupinyin = chars[0].substring(0, 1);
                }
            } else if (str.matches("[0-9]+")) {// 如果字符是数字,取数字
                hanyupinyin += "*";
            } else if (str.matches("[a-zA-Z]+")) {// 如果字符是字母,取字母 [a-zA-Z]+

                hanyupinyin += (clchars[0]);
                hanyupinyin = hanyupinyin.toUpperCase();

            } else {// 否则不转换

                hanyupinyin += "#";
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return hanyupinyin;
    }
    
    /**
     * Checks for digit.
     *
     * @param content the content
     * @return true, if successful
     */
    public static boolean hasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }
    
    /**
     * Checks for letter.
     *
     * @param content the content
     * @return true, if successful
     */
    public static boolean hasLetter(String content) {
        Pattern p = Pattern.compile("[a-zA-z]");
        if(p.matcher(content).find()) {
        	return true;
        }
        return false;
    }

}
