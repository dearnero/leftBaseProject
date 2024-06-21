package com.hf.left.gof.proxy;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/20 13:58
 * @version: 1.0
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("real subject");
    }
}
