package com.wondersgroup.commons.util.test;

import java.util.Base64;

/**
 * TODO
 *
 * @author tangjunlin
 * @date 2021/11/11 17:05
 * @since
 */
public class test4 {
    public static void main(String[] args) {
        T1 t1 = new T1() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        };

        T2 t2 = new T2() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        };

//        TT1 tt1=new TT1();
//        A tt2 = new A();

        System.out.println(t1.add(3, 5));
        System.out.println(t2.add(3, 5));
//        System.out.println(tt1.add(3, 5));
//        System.out.println(tt2.add(3, 5));
    }
}

abstract class T1 {
    public abstract int add(int x, int y);//abstract不可以省略，因为是抽象方法

    int mul(int x, int y) {
        return x * y;
    }//不能加default，只能接口上使用

    public static int div(int x, int y) {//static定义的修饰的方法有多个
        return x / y;
    }//static修饰的方法有多个,jdk8以后才有
}

abstract class Y1 {
    abstract public void say();
}

@FunctionalInterface
//jdk8以后有的，如果不写默认会加，隐式的
abstract interface T2 {//abstract可以省略。默认会加extends上

    //    public void sayHello();
    public abstract int add(int x, int y);//abstract可以省略。默认会加上

    public default int mul(int x, int y) {
        return x * y;
    }//default修饰的方法有多个,jdk8以后才有

    public static int div(int x, int y) {//static定义的修饰的方法有多个
        return x / y;
    }//static修饰的方法有多个,jdk8以后才有
}

interface Y2 {
    void say2();
}

abstract class A extends T1 {
    public abstract int add2(int x, int y);//abstract不可以省略。因为是抽象方法
}

class B extends T1 {
    @Override
    public int add(int x, int y) {
        return 0;
    }
}

class C extends A {
    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int add2(int x, int y) {
        return 0;
    }
}

class D implements T2 {
    @Override
    public int add(int x, int y) {
        return x + y;
    }
}

class E extends T1 implements T2 {
    @Override
    public int add(int x, int y) {
        return 0;
    }

    @Override
    public int mul(int x, int y) {
        return 0;
    }
}

class F extends T1 implements T2, Y2 {
    @Override
    public int add(int x, int y) {
        return 0;
    }

    @Override
    public int mul(int x, int y) {
        return 0;
    }

    @Override
    public void say2() {

    }
}

class G extends E implements T2, Y2 {
    @Override
    public void say2() {

    }
}

class H extends Y1 implements T2, Y2 {
    @Override
    public int add(int x, int y) {
        return 0;
    }

    @Override
    public int mul(int x, int y) {
        return 0;
    }

    @Override
    public void say() {

    }

    @Override
    public void say2() {

    }
}

class I extends Y1 implements T2{
    @Override
    public int add(int x, int y) {
        return 0;
    }

    @Override
    public int mul(int x, int y) {
        return 0;
    }

    @Override
    public void say() {

    }

}

