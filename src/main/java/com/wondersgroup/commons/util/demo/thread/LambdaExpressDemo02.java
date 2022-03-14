package com.wondersgroup.commons.util.demo.thread;

@FunctionalInterface
//jdk8以后有的，如果不写默认会加，隐式的
abstract interface Foo {//abstract可以省略。默认会加上
//    public void sayHello();
    public abstract int add(int x, int y);//abstract可以省略。默认会加上

    default  int mul(int x, int y) {
        return x * y;
    }//default修饰的方法有多个,jdk8以后才有。目的是

    public static int div(int x, int y) {//static定义的修饰的方法有多个
        return x / y;
    }//static修饰的方法有多个,jdk8以后才有

}


/**
 * @auther tangjunlin
 * <p>
 * 1    拷贝小括号， 写死右箭头， 落地大括号
 * 2    @FunctionalInterface
 * 3    default
 * 4    static
 */
public class LambdaExpressDemo02 {
    public static void main(String[] args) {
        /*Foo foo = new Foo()
        {
            @Override
            public void sayHello()
            {
                System.out.println("****hello 1205");
            }

            @Override
            public int add(int x, int y)
            {
                return 0;
            }
        };
        foo.sayHello();*/

        Foo ss=new Foo() {
            @Override
            public int add(int x, int y) {
                return 0;
            }
        };

        Foo fp=(int x, int y)->{
            return 0;
        };

        Foo foo = (int x, int y) -> {
            System.out.println("come in add method");
            return x + y;
        };
        System.out.println(foo.add(3, 5));

        System.out.println(foo.mul(3, 5));

        System.out.println(Foo.div(10, 2));

    }
}
