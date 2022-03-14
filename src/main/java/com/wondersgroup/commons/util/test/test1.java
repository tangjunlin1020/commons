package com.wondersgroup.commons.util.test;

import java.util.Base64;

/**
 * TODO
 *
 * @author tangjunlin
 * @date 2021/11/11 17:05
 * @since
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new test1().ss();

    }
    private  void ss(){
        System.out.println(Thread.currentThread().getName());
    }
}
