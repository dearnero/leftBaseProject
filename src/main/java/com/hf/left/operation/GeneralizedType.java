package com.hf.left.operation;

public class GeneralizedType {

    public static void main(String[] args) {
        GeneralizedType generalizedType = new GeneralizedType();
        Box<String> box = generalizedType.new Box<>("dd");
        System.out.println(box.getValue());
    }

    public class Box<T> {
        private T value;

        // 构造函数
        public Box(T value) {
            this.value =value;
        }

        // 获取值
        public T getValue() {
            return value;
        }
    }
}
