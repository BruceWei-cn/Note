package com.ming.demo.thisdemo;


class A4 {
    int data = 10;

    A4() {
        //传递A4这个对象实例
        B b = new B(this);
        b.display();
    }


    /**
     * 可以在构造函数中传递this关键字（若必须在多个类中使用同一个对象可以使用这种方式）
     */
    public static void main(String[] args) {
        A4 a = new A4();
    }
}

