package com.ming.demo.thisdemo;

class B {
    A4 obj;

    B(A4 obj) {
        this.obj = obj;
    }

    void display() {
        // using data member of A4 class
        System.out.println(obj.data);
    }
}
