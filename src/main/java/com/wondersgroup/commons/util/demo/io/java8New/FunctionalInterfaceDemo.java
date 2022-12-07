package com.wondersgroup.commons.util.demo.io.java8New;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * TODO
 * java8新特性  函数式接口
 * 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * <p>
 * 函数式接口可以被隐式转换为 lambda 表达式。
 * <p>
 * Lambda 表达式和方法引用（实际上也可认为是Lambda表达式）上。
 *
 * @author tangjunlin
 * @date 2022/1/25 10:36
 */
public class FunctionalInterfaceDemo {
    /**
     * jdk1.8前后使用方式比对
     *
     * @author tangjunlin
     * @date: 2022/1/25
     * @return:
     */
    @Test
    public void demo1() {
        //jdk1.8之前的方式
        GreetingService oldGreetingService = new GreetingService() {
            @Override
            public void sayMessage(String message) {
                System.out.println(message);
            }
        };

        //jdk1.8以后的方式
        GreetingService newGreetingService = (String message) -> {
            System.out.println(message);
        };
        GreetingService newGreetingService2 = (message) -> {
            System.out.println(message);
        };
        GreetingService newGreetingService3 = message -> {
            System.out.println(message);
        };
        GreetingService newGreetingService4 = message ->
                System.out.println(message);

        oldGreetingService.sayMessage("老的方式");
        newGreetingService.sayMessage("新的方式");
        newGreetingService2.sayMessage("新的方式2");
        newGreetingService3.sayMessage("新的方式3");
        newGreetingService4.sayMessage("新的方式4");
    }

    /**
     * JDK 1.8 新增加的函数接口：java.util.function
     *
     * @author tangjunlin
     * @date: 2022/1/25
     * @return:
     */

    @Test
    public void demo2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true
        System.out.println("输出所有数据:");
        // 传递参数 n
        eval(list, n -> true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true

        System.out.println("输出所有偶数:");
        eval(list, n -> n % 2 == 0);

        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true

        System.out.println("输出大于 3 的所有数字:");
        eval(list, n -> n > 3);

    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {

            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}

@FunctionalInterface
interface GreetingService {
    void sayMessage(String message);
}