/**
 * Copyright (c) 2016-2017, ByteLee (bytelee@vip.sohu.net)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * <p>
 * Copyright (c) 2016-2017, ByteLee (bytelee@vip.sohu.net)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * <p>
 * Copyright (c) 2016-2017, ByteLee (bytelee@vip.sohu.net)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Copyright (c) 2016-2017, ByteLee (bytelee@vip.sohu.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ygbc.brain.common.utils;

import com.ygbc.brain.common.utils.matcher.PatternMatcher;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用公共函数
 *
 * @author ByteLee
 *
 */
public class CommonUtils {

    /**
     * 常用正则表达式
     */
    public final static String regExp_integer_1 = "^\\d+$"; // 匹配非负整数（正整数 + 0）
    public final static String regExp_integer_2 = "^[0-9]*[1-9][0-9]*$"; // 匹配正整数
    public final static String regExp_integer_3 = "^((-\\d+) ?(0+))$"; // 匹配非正整数（负整数  + 0）
    public final static String regExp_integer_4 = "^-[0-9]*[1-9][0-9]*$"; // 匹配负整数
    public final static String regExp_integer_5 = "^-?\\d+$"; // 匹配整数

    public final static String regExp_float_1 = "^\\d+(\\.\\d+)?$"; // 匹配非负浮点数（正浮点数 + 0）
    public final static String regExp_float_2 = "^(([0-9]+\\.[0-9]*[1-9][0-9]*) ?([0-9]*[1-9][0-9]*\\.[0-9]+) ?([0-9]*[1-9][0-9]*))$"; // 匹配正浮点数
    public final static String regExp_float_3 = "^((-\\d+(\\.\\d+)?) ?(0+(\\.0+)?))$"; // 匹配非正浮点数（负浮点数 + 0）
    public final static String regExp_float_4 = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*) ?([0-9]*[1-9][0-9]*\\.[0-9]+) ?([0-9]*[1-9][0-9]*)))$"; // 匹配负浮点数
    public final static String regExp_float_5 = "^(-?\\d+)(\\.\\d+)?$"; // 匹配浮点数

    public final static String regExp_letter_1 = "^[A-Za-z]+$";// 匹配由26个英文字母组成的字符串
    public final static String regExp_letter_2 = "^[A-Z]+$";// 匹配由26个英文字母的大写组成的字符串
    public final static String regExp_letter_3 = "^[a-z]+$";// 匹配由26个英文字母的小写组成的字符串
    public final static String regExp_letter_4 = "^[A-Za-z0-9]+$";// 匹配由数字和26个英文字母组成的字符串
    public final static String regExp_letter_5 = "^\\w+$";// 匹配由数字、26个英文字母或者下划线组成的字符串

    public final static String regExp_email = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$"; // 匹配email地址

    public final static String regExp_url_1 = "^[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$"; // 匹配url
    public final static String regExp_url_2 = "[a-zA-z]+://[^\\s]*"; // 匹配url

    public final static String regExp_chinese_1 = "[\\u4e00-\\u9fa5]"; // 匹配中文字符
    public final static String regExp_chinese_2 = "[^\\x00-\\xff]"; // 匹配双字节字符(包括汉字在内)

    public final static String regExp_line = "\\n[\\s ? ]*\\r"; // 匹配空行：

    public final static String regExp_html_1 = "/ <(.*)>.* <\\/\\1> ? <(.*) \\/>/"; // 匹配HTML标记
    public final static String regExp_startEndEmpty = "(^\\s*) ?(\\s*$)"; // 匹配首尾空格

    public final static String regExp_accountNumber = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$"; //匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)

    public final static String regExp_telephone = "\\d{3}-\\d{8} ?\\d{4}-\\d{7}"; //匹配国内电话号码，匹配形式如 0511-4405222 或 021-87888822 

    public final static String regExp_qq = "[1-9][0-9]{4,}"; // 腾讯QQ号, 腾讯QQ号从10000开始

    public final static String regExp_postbody = "[1-9]\\d{5}(?!\\d)"; // 匹配中国邮政编码

    public final static String regExp_idCard = "\\d{15} ?\\d{18}"; // 匹配身份证, 中国的身份证为15位或18位

    public final static String regExp_ip = "\\d+\\.\\d+\\.\\d+\\.\\d+";//IP

    /**
     * 字符编码
     */
    public final static String encoding = "UTF-8";
    private static final char SEPARATOR = '_';

    public static String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }

    /**
     * 保留几位小数
     *
     * @param n 浮点数
     * @param k 保留位数
     * @return
     */
    public static Double keepDecimal(Double n, int k) {
        BigDecimal bd = new BigDecimal(n);
        return bd.setScale(k, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 数组转字符串
     *
     * @param arrs
     * @return
     */
    public static String printArray(String[] arrs) {
        StringBuilder str = new StringBuilder("");
        if (arrs.length > 0) {
            for (String arr : arrs) {
                str.append(arr).append("|");
            }
            str.deleteCharAt(str.length() - 1);
        }
        return str.toString();
    }

    /**
     * 验证字符串是否匹配指定正则表达式
     *
     * @param content
     * @param regExp
     * @return
     */
    public static boolean regExpValid(String content, String regExp) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }

    /**
     * Url Base64编码
     *
     * @param data 待编码数据
     * @return String 编码数据
     * @throws Exception
     */
    public static String encode(String data) throws Exception {
        // 执行编码
        byte[] b = Base64.encodeBase64URLSafe(data.getBytes(encoding));

        return new String(b, encoding);
    }

    /**
     * Url Base64解码
     *
     * @param data 待解码数据
     * @return String 解码数据
     * @throws Exception
     */
    public static String decode(String data) throws Exception {
        // 执行解码
        byte[] b = Base64.decodeBase64(data.getBytes(encoding));

        return new String(b, encoding);
    }

    /**
     * URL编码（utf-8）
     *
     * @param source
     * @return
     */
    public static String urlEncode(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据内容类型判断文件扩展名
     *
     * @param contentType 内容类型
     * @return
     */
    public static String getFileExt(String contentType) {
        String fileExt = "";
        if (null != contentType) {
            switch (contentType) {
                case "image/jpeg":
                    fileExt = ".jpg";
                    break;
                case "audio/mpeg":
                    fileExt = ".mp3";
                    break;
                case "audio/amr":
                    fileExt = ".amr";
                    break;
                case "video/mp4":
                    fileExt = ".mp4";
                    break;
                case "video/mpeg4":
                    fileExt = ".mp4";
                    break;
                default:
                    break;
            }
        }
        return fileExt;
    }

    /**
     * 获取bean名称
     *
     * @param bean
     * @return
     */
    public static String beanName(Object bean) {
        String fullClassName = bean.getClass().getName();
        String classNameTemp = fullClassName.substring(fullClassName.lastIndexOf(".") + 1, fullClassName.length());
        return classNameTemp.substring(0, 1) + classNameTemp.substring(1);
    }

    /**
     * 数组转字符串 用|分割
     *
     * @param arrs
     * @return
     */
    public static String arrayToString(String[] arrs) {
        return arrayToString(arrs, "|");
    }

    /**
     * 数组转字符串 用自定义 分割
     *
     * @param arrs
     * @return
     */
    public static String arrayToString(String[] arrs, String excision) {
        StringBuilder str = new StringBuilder();
        if (arrs.length > 0) {
            for (String arr : arrs) {
                str.append(arr).append(excision);
            }
            str.deleteCharAt(str.length() - 1);
        }
        return str.toString();
    }

    /**
     * 去掉小数后面多余的0
     *
     * @param number
     * @return
     */
    public static String subZeroAndDot(String number) {
        if (number.indexOf(".") > 0) {
            number = number.replaceAll("0+?$", "");//去掉多余的0
            number = number.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return number;
    }

    /**
     * 计算采用utf-8编码方式时字符串所占字节数
     *
     * @param content
     * @return
     */
    public static int getByteSize(String content) {
        int size = 0;
        if (null != content) {
            try {
                // 汉字采用utf-8编码时占3个字节
                size = content.getBytes("utf-8").length;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return size;
    }

    /**
     * 方法描述：判断字符串是否为空
     *
     * @author YongLiang.Wang
     * @time 2011-4-9 上午11:11:25
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        return str == null || "".equals(str) || "null".equalsIgnoreCase(str); // 为空返回true
        // 不为空返回false
    }

    /**
     * 判断是否为INT
     *
     * @param expression
     * @return
     */
    public static boolean isInteger(Object expression) {
        if (expression != null) {
            try {
                Integer.parseInt(expression.toString());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判读是否为DOUBLE
     *
     * @param expression
     * @return
     */
    public static boolean isDouble(Object expression) {
        if (expression != null) {
            try {
                Double.parseDouble(expression.toString());
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断给定的字符串数组中的数据是不是都为数值型
     *
     * @param array 字符串数组
     * @return 是否成功
     */
    public static boolean isNumArray(String[] array) {
        if (array == null) {
            return false;
        }
        if (array.length < 1) {
            return false;
        }
        for (String string : array) {
            if (isInteger(string) || isDouble(string)) {
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法描述：判断字符串是否为数字
     *
     * @author YongLiang.Wang
     * @time Apr 16, 2011 1:22:17 PM
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        return isInteger(str) || isDouble(str);
    }

    /**
     * 方法描述：判断是否为正整数
     *
     * @author YongLiang.Wang
     * @time 2011-5-11 下午03:05:59
     * @param s
     * @return
     */
    public static boolean isPositiveInt(String s) {
        boolean b = true;
        try {
            while (b) {
                for (int j = 0; j < s.length(); j++) {
                    if (!(s.charAt(j) >= 48 && s.charAt(j) <= 57)) {
                        return false;
                    } else {
                        b = false;
                    }
                }
                if (!b) {
                    int i = Integer.parseInt(s);
                    return i != 0;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static Integer compareVersion(String versionA, String versionB, String versionSplit) {

        if (versionA.equals("") || versionB.equals("")) {
            return versionA.compareTo(versionB);
        }

        if (!Pattern.compile(versionSplit, Pattern.LITERAL).matcher(versionA + versionB).replaceAll("").matches("\\d+")) {
            // throw new RuntimeException( "Version format error: " + versionA +
            // ", " + versionB );
            return null;
        }
        String[] volumnsA = Pattern.compile(versionSplit, Pattern.LITERAL).split(versionA);
        String[] volumnsB = Pattern.compile(versionSplit, Pattern.LITERAL).split(versionB);

        int aVolSize = volumnsA.length;
        int bVolSize = volumnsB.length;

        int aIndex = -1;
        int bIndex = -1;
        while (++aIndex < aVolSize && ++bIndex < bVolSize) {
            int vA = Integer.parseInt(volumnsA[bIndex]);
            int vB = Integer.parseInt(volumnsB[bIndex]);
            System.out.println(vA + "-" + vB);

            if (vA != vB) {
                return vA - vB;
            }
        }
        return aVolSize - bVolSize;
    }

    /**
     *
     * 方法描述：生成订单号
     *
     * @author David
     * @param userId
     * @time 2013-3-26 上午10:02:12
     *
     * @return
     */
    public static synchronized String createOrderNumber(String userId) {
        Long d = System.currentTimeMillis();
        return userId + d.toString();
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String firstUpperCamelCase(String tableName) {
        return tableName.substring(0, 1).toUpperCase() + format(tableName.substring(1));
    }

    public static String toCamelCase(String tableName) {
        return format(tableName);
    }

    public static String toLowerCaseAll(String tableName) {
        return format(tableName).toLowerCase();
    }

    private static String format(String field) {
        if (field == null) {
            return null;
        }
        String[] strs = field.split("_");
        field = "";
        for (int m = 0, length = strs.length; m < length; m++) {
            if (m > 0) {
                String tempStr = strs[m].toLowerCase();
                tempStr = tempStr.substring(0, 1).toUpperCase() + tempStr.substring(1, tempStr.length());
                field += tempStr;
            } else {
                field += strs[m].toLowerCase();
            }
        }
        return field;
    }

    public static boolean notNull(Object... paras) {
        if (paras == null) {
            return false;
        }
        for (Object obj : paras) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static String join(String[] stringArray) {
        StringBuilder sb = new StringBuilder();
        for (String s : stringArray) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String join(String[] stringArray, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            if (i > 0) {
                sb.append(separator);
            }
            sb.append(stringArray[i]);
        }
        return sb.toString();
    }

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
     * case-when to CaseWhen
     *
     * @return
     */
    public static String toUpperCamelCase(String str) {
        str = format(str.replaceAll("-", "_"));
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String concat(String... strings) {
        String str = "";
        for (String string : strings) {
            str = str.concat(string);
        }
        return str;
    }

    /**
     * list转字符串
     *
     * @param list
     * @param separator:分隔符，默认为“,”
     * @return
     */
    public static String listToString(List<Integer> list, String separator) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (separator == null) {
            separator = ",";
        }
        StringBuilder result = new StringBuilder();
        for (Integer str : list) {
            result.append(str);
            result.append(separator);
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    /**
     * 去除两端的空格 半角和全角空格都可以去除
     *
     * @param textContent
     * @return 新字符串
     */
    public static String removeSpace(String textContent) {
        if (textContent == null) {
            return textContent;
        }
        textContent = textContent.trim();
        while (textContent.startsWith("　")) {// 这里判断是不是全角空格
            textContent = textContent.substring(1, textContent.length()).trim();
        }
        while (textContent.endsWith("　")) {
            textContent = textContent.substring(0, textContent.length() - 1).trim();
        }
        return textContent;
    }

    /**
     * 丨字符串ID 分隔 的形式,去重组装
     *
     * @param str
     * @param ids
     * @return
     */
    public static String interval(String str, String ids) {
        if (CommonUtils.isNotEmpty(str)) {
            ids = str.concat("|").concat(ids);
        }
        Set<String> courseSet = new HashSet<>();
        CollectionUtils.addAll(courseSet, ids.trim().split("\\|"));
        ids = "";

        for (String cid : courseSet) {
            if (CommonUtils.isNotEmpty(cid) && !cid.contains("|")) {
                ids = ids.concat(cid).concat("|");
            }
        }
        return ids.substring(0, ids.length() - 1);
    }

    /**
     * 判断字符串是否为空
     *
     * @param val
     * @return
     */
    public static boolean isEmpty(String val) {
        return PatternMatcher.isBlank(val);
    }

    /**
     * 随机获取UUID字符串(无中划线)
     *
     * @return UUID字符串
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
    }

    /**
     * 随机获取字符串
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String getRandomString(int length) {
        if (length <= 0) {
            return "";
        }
        char[] randomChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd',
                'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
        }
        return stringBuffer.toString();
    }

    /**
     * 根据指定长度 分隔字符串
     *
     * @param str 需要处理的字符串
     * @param length 分隔长度
     * @return 字符串集合
     */
    public static List<String> splitString(String str, int length) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i += length) {
            int endIndex = i + length;
            if (endIndex <= str.length()) {
                list.add(str.substring(i, i + length));
            } else {
                list.add(str.substring(i, str.length() - 1));
            }
        }
        return list;
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !CommonUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(List list) {
        return list != null && list.size() > 0;
    }

    public static boolean isNotEmpty(Map map) {
        return map != null && map.size() > 0;
    }

    public static boolean isNotEmpty(Object[] objects) {
        return objects != null && objects.length > 0;
    }

    public static boolean isNullOrEmpty(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNullOrEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNullOrEmpty(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    /**
     * 将字符串List转化为字符串，以分隔符间隔.
     *
     * @param list 需要处理的List.
     *
     * @param separator 分隔符.
     *
     * @return 转化后的字符串
     */
    public static String toString(List<String> list, String separator) {
        StringBuilder stringBuffer = new StringBuilder();
        for (String str : list) {
            stringBuffer.append(separator).append(str);
        }
        stringBuffer.deleteCharAt(0);
        return stringBuffer.toString();
    }

    /**
     * 首字母变小写
     */
    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 首字母变大写
     */
    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 字符串为 null 或者内部字符全部为 ' ' '\t' '\n' '\r' 这四类字符时返回 true
     */
    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        int len = str.length();
        if (len == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            switch (str.charAt(i)) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    // case '\b':
                    // case '\f':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean notBlank(String str) {
        return !isBlank(str);
    }

    public static boolean notBlank(String... strings) {
        if (strings == null) {
            return false;
        }
        for (String str : strings) {
            if (isBlank(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(String a, String b) {
        return a == null ? b == null : a.equals(b);
    }

    public static String getRandomUUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 首字母转小写
     *
     * @param name 转换前的字符串
     * @return 转换后的字符串
     */
    public static String firstLowerCase(String name) {
        byte[] items = name.getBytes();
        items[0] = (byte) ((char) items[0] + ('a' - 'A'));
        return new String(items);
    }

    /**
     * 首字母转大写
     *
     * @param name 转换前的字符串
     * @return 转换后的字符串
     */
    public static String firstUpperCase(String name) {
        byte[] items = name.getBytes();
        items[0] = (byte) ((char) items[0] + ('A' - 'a'));
        return new String(items);
    }

    /**
     * 将驼峰式命名的字符串转换为下划线方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
     * 例如：HelloWorld->hello_world
     *
     * @param name 转换前的驼峰式命名的字符串
     * @return 转换后下划线大写方式命名的字符串
     */
    public static String underlineCase(String name) {
        if (name == null) {
            return null;
        }
        if (name.contains("_")) {
            return name;
        } else {
            StringBuilder sb = new StringBuilder();
            boolean upperCase = false;
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                boolean nextUpperCase = true;
                if (i < (name.length() - 1)) {
                    nextUpperCase = Character.isUpperCase(name.charAt(i + 1));
                }
                if ((i >= 0) && Character.isUpperCase(c)) {
                    if (!upperCase || !nextUpperCase) {
                        if (i > 0) {
                            sb.append(SEPARATOR);
                        }
                    }
                    upperCase = true;
                } else {
                    upperCase = false;
                }
                sb.append(Character.toLowerCase(c));
            }
            return sb.toString();
        }
    }

    /**
     * 将下划线方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
     * 例如：hello_world->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String camelCase(String name) {
        if (name == null) {
            return null;
        }
        if (name.contains("_")) {
            name = name.toLowerCase();

            StringBuilder sb = new StringBuilder(name.length());
            boolean upperCase = false;
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);

                if (c == SEPARATOR) {
                    upperCase = true;
                } else if (upperCase) {
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        } else {
            return name;
        }
    }

    /**
     * 根据行数返回字符串的子集。</br>
     *
     * @param objString 原字符串
     * @param begin 字符串开始行数（从0开始）
     * @param count 获取行数
     * @return 转换后的驼峰式命名的字符串
     */
    public static String getLine(String objString, int begin, int... count) {
        String result = "";
        String[] obj = objString.split("\r");
        if (obj.length <= 1)
            obj = objString.split("\n");  //适配\r 和\n 作为换行符的类型
        if (obj.length < begin) {
            return result;
        } else {
            if (count == null || count.length < 1) {
                result = obj[begin];
            } else {
                String cr = "";
                for (int i = 0; i < count[0]; i++) {
                    result = result + cr + obj[begin + i];
                    cr = "\n";
                }
            }
            return result;
        }
    }

}
