package com.hf.left.explorations;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/26 15:02
 * @version: 1.0
 */
public class Java17v {

    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        data.put("key1", "aaa");
        data.put("key2", 111);
        // java16中对于instanceof增强后的写法
        if (data.get("key") instanceof String s) {
            System.out.println(s);
        } else if (data.get("key") instanceof Double s) {
            System.out.println(s);
        } else if (data.get("key") instanceof Integer s) {
            System.out.println(s);
        }
        // java17中对于switch增强后的写法
        switch (data.get("key1")) {
            case String s  -> System.out.println(s);
            case Double d  -> System.out.println(d);
            case Integer t  -> System.out.println(t);
            default        -> System.out.println("1");
        }
    }

    // 定义Hero为密封类，同时仅支持TankHero, AttackHero两个子类
    public sealed class Hero permits TankHero, AttackHero{

    }
    // 必须声明从父类中继承的密封性，当时类定义成非密封类，可以被任意继承
    public non-sealed class AttackHero extends Hero{

    }
    // 必须声明从父类中继承的密封性，当时类定义成密封类，下一层子类必须再次声明密封性
    public sealed class TankHero extends Hero{

    }
    // 必须声明从父类中继承的密封性，当时类定义成非密封类，可以被任意继承
    public non-sealed class Alistar extends TankHero{

    }
}
