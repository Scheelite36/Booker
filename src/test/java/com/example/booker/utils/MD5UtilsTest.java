package com.example.booker.utils;

import junit.framework.TestCase;

import java.security.NoSuchAlgorithmException;

/**
 * @author Scheelite
 * @date 2022/3/16
 * @email jwei.gan@qq.com
 * @description
 **/
public class MD5UtilsTest extends TestCase {
    public void testName() throws NoSuchAlgorithmException {
        System.out.println(MD5Utils.getMD5String("12139968678ajfidgasl"));
    }
}