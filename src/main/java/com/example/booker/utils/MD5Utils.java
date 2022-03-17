package com.example.booker.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Scheelite
 * @date 2022/3/15
 * @email jwei.gan@qq.com
 * @description
 **/
public class MD5Utils {
    public static String getMD5String(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // 进行hash计算，生成长度16的字节数组
        byte[] digest = md5.digest(str.getBytes());
        StringBuffer sb = new StringBuffer(digest.length*2);
        for (byte b : digest) {
//            将byte转化为32位的int类型，byte&0xff目的是为了保持其二进制数据的一致性
//            然后将int转换16进制 字符串
            String string = Integer.toHexString(b & 0xff);
//            int是32位, char是16位，转过去需要由两个char组成，不足补0
            if (string.length() < 2) {
                sb.append(0);
            }
            sb.append(string);
        }
        return sb.toString();
    }
}
