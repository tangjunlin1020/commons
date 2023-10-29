package com.wondersgroup.commons.util.test;

import java.util.Scanner;

/**
 * TODO
 *
 * @author tangjunlin
 * @date 2023/5/9 22:36
 */
public class test11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String a = in.nextLine().toUpperCase().trim();
            String b = in.nextLine().toUpperCase().trim();

            String [] bb=a.split(b);
            System.out.println(bb.length);
        }

//        Scanner in = new Scanner(System.in);
//
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextLine()) {
//            String a = in.nextLine().toUpperCase().trim();
//            String b = in.nextLine().toUpperCase().trim();
//
//
//            int alen = a.length();
//            String[] aa = a.split(b);
//
//
//            if (aa.length > 0) {
//                if(a.lastIndexOf(b,a.length()-1)==a.length()-1){
//                    System.out.println(aa.length);
//                }else{
//                    System.out.println(aa.length - 1);
//                }
//            }
//
//
//        }
    }
}
