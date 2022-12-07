package com.wondersgroup.commons.util.demo.other.java8New;

/**
 * Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 * 使用 Lambda 表达式可以使代码变的更加简洁紧凑。
 * <p>
 * ambda 表达式的语法格式如下：
 * <p>
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 * <p>
 * 以下是lambda表达式的重要特征:
 * <p>
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定表达式返回了一个数值。
 *
 * @author tangjunlin
 * @date 2022/1/25 14:01
 */
public class LambdaDemo {
    /**
     * // 1. 不需要参数,返回值为 5
     * () -> 5
     * <p>
     * // 2. 接收一个参数(数字类型),返回其2倍的值
     * x -> 2 * x
     * <p>
     * // 3. 接受2个参数(数字),并返回他们的差值
     * (x, y) -> x – y
     * <p>
     * // 4. 接收2个int型整数,返回他们的和
     * (int x, int y) -> x + y
     * <p>
     * // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
     * (String s) -> System.out.print(s)
     *
     * @author tangjunlin
     * @date: 2022/1/25
     */

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();


    }
}

  abstract interface MathOperation {//abstract可以不加，默认加上的， 其实无论接口和接口中的方法如何声明,都是抽象的。即使在声明接口时，并没有用abstract修饰，但是在编译的时候编译器会自动加上abstract。所以根本没有实质意义上的区分，只不过在写法上有所不同而已。接口中方法都是抽象的，这个无论用不用修饰符abstract都是一样的。
          abstract   int operation();//abstract可以不加，默认加上的
}
