package com.ming.demo;

class Other {
    public static Other o1 = new Other();

    public static Other o2 = new Other();
    {
        System.out.println("构造块");
    }
    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        Other other = new Other();
    }
}