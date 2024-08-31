package com.hf.left.operation.reflex;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/27 15:17
 * @version: 1.0
 */
public class GetClass {

    public static void main(String[] args) throws ClassNotFoundException {
        Class a1 = String.class;
        System.out.println(a1.getConstructors());
        Class a2 = "aa".getClass();
        Class<?> a3 = Class.forName("java.lang.String");
        Class<?> a4 = ClassLoader.getSystemClassLoader().loadClass("java.lang.String");
        System.out.println(a1 == a2);
        System.out.println(a2 == a3);
        System.out.println(a3 == a4);
    }
}
