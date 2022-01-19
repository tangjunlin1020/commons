package com.wondersgroup.commons.io.audio;

/**
 * TODO
 *
 * @author tangjunlin
 * @date 2021/9/9 13:56
 * @since
 */

import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        createFile3();//先创建文件夹
        createFile2();//再创建文件
        createFile();//文件处理等
    }

    /**
     * 文件处理示例
     */
    public static void createFile() {
        File f = new File("D:/垃圾桶/file/test.txt");
        try {
            f.createNewFile();  //当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。  例如有D:/垃圾桶目录但是没有D:/垃圾桶/files。则File f=new File("D:/垃圾桶/files/create.txt")创建失败
            System.out.println("该分区大小" + f.getTotalSpace() / (1024 * 1024 * 1024) + "G"); //返回由此抽象路径名表示的文件或目录的名称。
            f.mkdirs();  //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
//            f.delete(); //  删除此抽象路径名表示的文件或目录
            System.out.println("文件名  " + f.getName());  //  返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("文件父目录字符串 " + f.getParent());// 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断文件是否存在，不存在则创建
     */
    private static void createFile2() {
        File file = new File("D:\\垃圾桶\\file\\test2.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();

            }

            System.out.println("文件已创建");

        } else {
            System.out.println("文件已存在");

        }
    }

    private static void createFile3() {
        File folder = new File("D:\\垃圾桶\\file");

        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();

            System.out.println("创建文件夹");

        } else {
            System.out.println("文件夹已存在");

        }
    }

}
