package com.ming.demo.guava;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author Ming
 * @date 12/5/2022-下午 5:25
 */
public class GuavaStringTest {

    @Test
    public void test01(){
        String s = "";
        // Splitter链式分隔
        List<String> list = Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .splitToList(s);
        System.out.println("list = " + list);
        HashSet<String> set = new HashSet<>(list);
        System.out.println("set = " + set);
        ArrayList<@Nullable Object> arrayList = Lists.newArrayList();
        arrayList.addAll(set);
        System.out.println("arrayList = " + arrayList);
    }
}
