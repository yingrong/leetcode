package org.example.array_and_string;

public class GcdOfString {

    /**
     * 给定两个字符串：A与B，假设B的长度不小于A。
     * 枚举:如果存在最大公约字符串，肯定是B的前几个字符。
     * 1. 从B开始循环，如果恰巧是B，直接返回
     * 2. 循环的条件：只有长度可被AB整除的，才有可能是答案，其他的直接跳过
     * 3. 判断子串是否是约数
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings1(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String divisor = str1.substring(0, i);
                if (isDivisor(divisor, str1) && isDivisor(divisor, str2)) {
                    return divisor;
                }
            }
        }
        return "";
    }

    /*
    判断是否是约数：将字串拼接起来，是否和被除数相等。
     */
    private boolean isDivisor(String divisor, String dividend) {
        int lenx = dividend.length() / divisor.length();

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < lenx; i++) {
            stringBuffer.append(divisor);
        }
        return stringBuffer.toString().equals(dividend);
    }

    /*
    * 1. 如果 str1 和 str2 连接不等，无解
    * 2. 如果有解，答案是最大公因数长度的字串
     */
    public String gcdOfStrings2(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd1(str1.length(), str2.length()));
    }

    private int gcd(int len1, int len2) {
        return len2 == 0 ? len1 : gcd(len2, len1 % len2);
    }

    private int gcd1(int a, int b) {

        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
