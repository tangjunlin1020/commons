package com.wondersgroup.commons.util.demo.designMode.mode1;

/**
 * 单例模式
 * 它的定义就是确保某一个类只有一个实例，并且提供一个全局访问点 。
 * 单例模式具备典型的3个特点：①只有一个实例。②自我实例化。③提供全局访问点。
 * 单例模式又分懒汉模式和饿汉模式
 * 懒汉式和饿汉式的安全和性能区别：
 * （1） 线程安全：饿汉式在线程还没出现之前就已经实例化了，所以饿汉式一定是线程安全的。懒汉式加载是在使用时才会去new 实例的，那么你去new的时候是一个动态的过程，是放到方法中实现的，比如：
 * 如果这个时候有多个线程访问这个实例，这个时候实例还不存在，还在new，就会进入到方法中，有多少线程就会new出多少个实例。一个方法只能return一个实例，那最终return出哪个呢？是不是会覆盖很多new的实例？这种情况当然也可以解决，那就是加同步锁，避免这种情况发生 。
 * （2）执行效率：饿汉式没有加任何的锁，因此执行效率比较高。懒汉式一般使用都会加同步锁，效率比饿汉式差。
 * （3）内存使用：饿汉式在一开始类加载的时候就实例化，无论使用与否，都会实例化，所以会占据空间，浪费内存。懒汉式什么时候用就什么时候实例化，不浪费内存。
 *
 * @author tangjunlin
 * @date 2022/12/12 10:20
 */
public class Singleton {
    //这个是饿汉模式   一开始类加载的时候就实例化
//    public static Singleton instance = new Singleton();//创建一个静态对象
//    public static Singleton  getInstance() {
//        return instance;
//    }

    //这个是懒汉模式的写法  当真正需要使用的时候才实例化
    public static Singleton instance = null;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();//什么时候用就什么时候new
        }
        return instance;
    }

    //一个普通的方法
    public void show() {
        System.out.println("我是单例模式");
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        instance1.show();
        Singleton instance2 = Singleton.getInstance();
        instance2.show();
        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1.equals(instance2));//输出结果为true 表示只创建了一次对象
        System.out.println(instance1 == instance2);

    }

}
