package com.wondersgroup.commons.util.demo.io.java8New;

import org.junit.Test;

import java.util.*;

/**
 * jdk8新特性
 *
 * @author tangjunlin
 * @date 2022/1/25 11:41
 */
public class Java8Test {
    /**
     * 排序的新写法
     *
     * @author tangjunlin
     * @date: 2022/1/25
     * @return:
     */
    @Test
    public void demo1() {
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        Java8Test tester = new Java8Test();
        System.out.println("使用 Java 7 语法: ");

        tester.sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("使用 Java 8 语法: ");

        tester.sortUsingJava8(names2);
        System.out.println(names2);
    }

    /**
     * jdk8新特性  方法引用实例
     *
     * @author tangjunlin
     * @date: 2022/1/25
     * @return:
     */
    @Test
    public void demo2() {
//        构造器引用：它的语法是Class::new，或者更一般的Class<T>::new实例如下：
        //jdk8写法
        final Car car = Car.create(Car::new);

        //jdk7写法
//        final Car car =Car.create(new Supplier<Car>() {
//            @Override
//            public Car get() {
//                return new Car();
//            }
//        });
        final List<Car> cars = Arrays.asList(car);

//        静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach(Car::collide);

//        特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach(Car::repair);

//        特定对象的方法引用：它的语法是instance::method实例如下：
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

//        实例中我们将 System.out::println 方法作为静态方法来引用。
        List<String> names = new ArrayList();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);

    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

}

/**********************************Java 8 方法引用 案例**********************************/
//方法引用通过方法的名字来指向一个方法。
//        方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
//        方法引用使用一对冒号 :: 。
//        下面，我们在 Car 类中定义了 4 个方法作为例子来区分 Java 中 4 种不同方法的引用。

@FunctionalInterface
interface Supplier<T> {
    T get();
}

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}

