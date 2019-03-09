package com.ygbc.brain.common.utils;

public class InviteCodeUtils {
    // 邀请码的长度
    private static int LENGTH = 6;

    private static String generateInviteCode() {
        String strMills = String.valueOf(System.currentTimeMillis());
        return strMills.substring(strMills.length() - InviteCodeUtils.LENGTH,strMills.length());
    }

}
