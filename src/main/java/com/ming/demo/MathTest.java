package com.ming.demo;

import java.security.SecureRandom;

import org.junit.Test;

/**
 * @author Ming
 * @date 2021/7/2 15:57
 * @description
 */
public class MathTest {


    @Test
    public void test01() {
        SecureRandom random = new SecureRandom();
        // [1,60]
        int i = random.nextInt(60) + 1;
        System.out.println("i = " + i);
    }

    @Test
    public void test02() {
        int i = 0;
        i = i++;
        System.out.println("i = " + i);
    }

    /**
     * 时间戳大小比较
     */
    @Test
    public void test03() {
        long time = 1648051200000L;
        if ( 1648051260000L > time){
            System.out.println("哈哈");
        }
    }

}
