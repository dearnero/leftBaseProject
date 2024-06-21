package com.hf.left.gof.proxy;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/20 13:59
 * @version: 1.0
 */
public class Proxy implements Subject{

    private RealSubject realSubject;

    public Proxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public void request() {

        System.out.println("proxy");
        realSubject.request();
    }

    public static void main(String[] args) {

        new Proxy(new RealSubject()).request();
    }
}
