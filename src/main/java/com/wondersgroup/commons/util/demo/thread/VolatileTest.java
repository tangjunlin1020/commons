package com.wondersgroup.commons.util.demo.thread;

/**
 * 　volatile在java语言中是一个关键字，用于修饰变量。被volatile修饰的变量后，表示这个变量在不同线程中是共享，编译器与运行时都会注意到这个变量是共享的，因此不会对该变量进行重排序。上面这句话可能不好理解，但是存在两个关键，共享和重排序。
 *
 * @author tangjunlin
 * @date 2022/3/13 19:12
 */
public class VolatileTest {

    private volatile int lower = 0;
    private volatile int upper = 5;

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setLower(int lower) {
        if (lower > upper) {
            return;
        }
        this.lower = lower;
    }

    public void setUpper(int upper) {
        if (upper < lower) {
            return;
        }
        this.upper = upper;
    }

    public void test() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setLower(4);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setUpper(3);
            }
        };

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("(low:" + getLower() + ",upper:" + getUpper() + ")");

    }

    public static void main(String args[]) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            VolatileTest volaitil = new VolatileTest();
            volaitil.test();
        }







    }
}