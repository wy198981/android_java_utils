package com.example.administrator.myparkingos.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017-02-17.
 */
public class RegexUtil
{
    /**
     * ���email�ĺϷ���
     * @param email
     * @return
     */
    public static boolean checkEmail(String email)
    {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        /**
         * \\w: [\:ת��] [\w: ƥ������»��ߵ��κε����ַ����ȼ��ڡ�[A-Za-z0-9_]����] [+:ƥ��ǰ����ӱ��ʽһ�λ���]
         * @ ��ͨ�ַ�
         * \\. ��ʾȡ��ת�弴\�� \��������ʾ�������ⵥ��һ���ַ������⺬�壻�����ַ�
         * [a-z]+��ʾa,z��һ���ַ�
         * \w+@\w+\.[a-z]+(\.[a-z]+)?���ַ���
         * ���ӣ�13265539954@163.com
         */
        return Pattern.matches(regex, email);
    }

    /**
     * ���card�Ƿ����ĳһ���淶
     * @param idCard
     * @return
     */
    public static boolean checkIdCard(String idCard)
    {
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        /**
         * [1-9]\d{13,16}[a-zA-Z0-9]{1}
         * ����
         */
        return Pattern.matches(regex, idCard);
    }

    /**
     * ���绰�ĺϷ���
     * @param mobile
     * @return
     */
    public static boolean checkMobile(String mobile)
    {
        String regex = "(\\+\\d+)?1[3458]\\d{9}$";
        /**
         * (\+\d+)?1[3458]\d{9}$
         * ()��ʾ����
         * ��Ϊ����һЩ�����ַ������Լ���\����ʾ�����ַ�
         */
        return Pattern.matches(regex, mobile);
    }

    /**
     * ���绰����
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone)
    {
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
        return Pattern.matches(regex, phone);
    }

    /**
     * ������� \-?[1-9]\d+
     * @param digit
     * @return
     */
    public static boolean checkDigit(String digit)
    {
        String regex = "\\-?[1-9]\\d+";
        return Pattern.matches(regex, digit);
    }

    /**
     * ���С��
     * @param decimals
     * @return
     */
    public static boolean checkDecimals(String decimals)
    {
        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
        return Pattern.matches(regex, decimals);
    }

    /**
     * ��� ƥ���κβ��ɼ��ַ��������ո��Ʊ������ҳ���ȵ�
     * @param blankSpace
     * @return
     */
    public static boolean checkBlankSpace(String blankSpace)
    {
        String regex = "\\s+";
        return Pattern.matches(regex, blankSpace);
    }

    /**
     * �������
     * @param chinese
     * @return
     */
    public static boolean checkChinese(String chinese)
    {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex, chinese);
    }

    /**
     * �������
     * @param birthday
     * @return
     */
    public static boolean checkBirthday(String birthday)
    {
        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
        return Pattern.matches(regex, birthday);
    }

    /**
     * ���url�ĺϷ���
     * @param url
     * @return
     */
    public static boolean checkURL(String url)
    {
//        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
        String regex = "(http|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
        return Pattern.matches(regex, url);
    }

    /**
     * ��������ĺϷ���
     * @param url
     * @return
     */
    public static String getDomain(String url)
    {
        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
        // ��ȡ����������
        // Pattern p=Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        return matcher.group();
    }

    /**
     * ����ʱ�
     * @param postcode
     * @return
     */
    public static boolean checkPostcode(String postcode)
    {
        String regex = "[1-9]\\d{5}";
        return Pattern.matches(regex, postcode);
    }

    /**
     * ���ip��ַ
     * @param ipAddress
     * @return
     */
    public static boolean checkIpAddress(String ipAddress)
    {
        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
        return Pattern.matches(regex, ipAddress);
    }

    /**
     * ���� str �Ƿ�ֻ������ĸ������
     *
     * @param str
     * @return
     */
    public static boolean IsLetterOrFigure(String str)
    {
        Matcher matcher = Pattern.compile("^[a-zA-Z0-9]+$").matcher(str);
        return matcher.matches();
//        return Pattern.matches(str, "^[a-zA-Z0-9]+$");

    }

    /**
     * ���� str �Ƿ�ֻ������ĸ
     *
     * @param str
     * @return
     */
    public static boolean IsLetter(String str)
    {
        Matcher matcher = Pattern.compile("^[a-zA-Z]+$").matcher(str);
        return matcher.matches();
//        return Pattern.matches(str, "^[a-zA-Z]+$");
    }

    /**
     * ���� str �Ƿ�ֻ������ĸ���Ҳ�����[i][o]���ַ�
     *
     * @param str
     * @return
     */
    public static boolean IsLetterNotIO(String str)
    {
        Matcher matcher = Pattern.compile("[a-hj-np-zA-HJ-NP-Z0]+$").matcher(str);
        return matcher.matches();
//        return Pattern.matches(str, "[a-hj-np-zA-HJ-NP-Z0]+$");
    }

    /**
     * ���� str �Ƿ�ֻ������ĸ�������֣��Ҳ�����[i][o]���ַ�
     *
     * @param str
     * @return
     */
    public static boolean IsLetterOrFigureNotIO(String str)
    {
        Matcher matcher = Pattern.compile("^[a-hj-np-zA-HJ-NP-Z0-9]+$").matcher(str);
        return matcher.matches();
//        return Pattern.matches(str, "^[a-hj-np-zA-HJ-NP-Z0-9]+$");
    }

}
