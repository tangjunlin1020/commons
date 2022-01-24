package com.wondersgroup.commons.util.demo.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @auther tangjunlin
 * @create 2019-03-24 21:43
 * <p>
 * 1 故障现象
 * java.util.ConcurrentModificationException
 * <p>
 * 2 导致原因
 * <p>
 * 3 解决方法
 * 3.1 new Vector<>()
 * 3.2 Collections.synchronizedList(new ArrayList<>());
 * 3.3 new CopyOnWriteArrayList()
 * <p>
 * <p>
 * 4 优化建议(同样的错误不犯第2次)
 */
public class NotSafeDemo03 {
    public static void main(String[] args) {
        mapSafe();
        setSafe();
        listSafe();
    }
    public static void mapSafe() {
        Map<String, String> map = new ConcurrentHashMap<>();//ConcurrentHashMap线程安全，HashMap是线程不安全的
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }
    public static void setSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();//CopyOnWriteArraySet线程安全， HashSet线程不安全
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    public static void listSafe() {
        List<String> list = new CopyOnWriteArrayList();//CopyOnWriteArrayList线程安全，Collections.synchronizedList(new ArrayList<>());线程安全，但是效率第一点主要是使用的synchronized方法上//new Vector<>()线程安全;        List<String> list = new CopyOnWriteArrayList();//CopyOnWriteArrayList线程安全，Collections.synchronizedList(new ArrayList<>());线程安全，但是效率第一点主要是使用的synchronized方法上//new Vector<>();线程安全//new ArrayList<>();线程不安全;
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}


/**
 * 笔记
 * 写时复制
 * CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行Copy，
 * 复制出一个新的容器Object[] newElements，然后新的容器Object[] newElements里添加元素，添加完元素之后，
 * 再将原容器的引用指向新的容器 setArray(newElements);。这样做的好处是可以对CopyOnWrite容器进行并发的读，
 * 而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器
 * public boolean add(E e)
 * {
 * final ReentrantLock lock = this.lock;
 * lock.lock();
 * <p>
 * try
 * {
 * Object[] elements = getArray();
 * int len = elements.length;
 * Object[] newElements = Arrays.copyOf(elements, len + 1);
 * newElements[len] = e;
 * setArray(newElements);
 * return true;
 * }
 * finally {
 * lock.unlock();
 * }
 * }
 */