package com.hf.left.gof;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/27 10:32
 * @version: 1.0
 */
public class Singleton {

    private static Singleton instance;

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {}

    /**
     * 方法1: 一种是在get单例对象的方法中创建单例对象，该实现方式可能存在线程安全问题
     * 1. 在多线程的前提下，多个线程会同时进入instance = new Singleton()，导致单例被实例多次
     * 2. 指令重排序问题
     *  - instance = new Singleton(); 实际上分为三步：
     *      - 分配内存空间。
     *      - 调用构造函数，初始化对象。
     *      - 将内存地址赋给 instance。
     *  在指令重排序的情况下，可能会让外部持有一个尚未完全初始化的 Singleton 对象
     *  解决办法：可以通过将 instance 变量声明为 volatile 来防止指令重排序。
     */
    public static Singleton getInstance1() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 通过双重检查的方式，来解决上述实现方式可能存在线程安全问题
     */
    public static Singleton getInstance2() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类： 这种方法利用了类加载的机制，既保证了线程安全，又避免了同步带来的开销
     * - 懒加载：SingletonHolder 类在 Singleton 类加载时并不会立即加载，而是在调用 getInstance() 方法时，
     * 才会去加载 SingletonHolder 类并初始化 INSTANCE。这种机制保证了 Singleton 实例的延迟加载，
     * 即只有在第一次调用 getInstance() 方法时才会创建 Singleton 实例。
     */
    public static Singleton getInstance3() {
        return SingletonHolder.INSTANCE;
    }
}
