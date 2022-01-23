package com.wondersgroup.commons.util.test;

import java.util.Base64;

/**
 * TODO
 *
 * @author tangjunlin
 * @date 2021/11/11 17:05
 * @since
 */
public class test2 {
    public static void main(String[] args) {
        //Original byte[]
        byte[] bytes = "hello world s".getBytes();

        //Base64 Encoded
        String encoded = Base64.getEncoder().encodeToString(bytes);

        //Base64 Decoded
        byte[] decoded = Base64.getDecoder().decode(encoded);

        //Verify original content
        System.out.println(new String(bytes));
    }
}
