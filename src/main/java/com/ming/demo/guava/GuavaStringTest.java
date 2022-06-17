package com.ming.demo.guava;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * @author Ming
 * @date 12/5/2022-下午 5:25
 */
public class GuavaStringTest {

    @Test
    public void test01() {
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


    /**
     * 取交集
     */
    @Test
    public void test02() {
        String s1 = "12,21,31";
        String s2 = "12,21,33";
        String s3 = "12,21,34";
        String s4 = "11,,,21,1";
        // Splitter链式分隔
        List<String> list1 = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(s1);
        List<String> list2 = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(s2);
        List<String> list3 = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(s3);
        List<String> list4 = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(s4);
        List<String> strings1 = new ArrayList<>(list1);
        List<String> strings2 = new ArrayList<>(list2);
        List<String> strings3 = new ArrayList<>(list3);
        List<String> strings4 = new ArrayList<>(list4);
        List<List<String>> lists = Lists.newArrayList();
        lists.add(strings1);
        lists.add(strings2);
        lists.add(strings3);
        lists.add(strings4);
        List<String> retainList = retainList(lists);
        System.out.println("retainList = " + retainList);
    }

    public static List<String> retainList(List<List<String>> lists) {
        List<String> list = lists.parallelStream()
                .filter(CollectionUtils::isNotEmpty)
                .reduce((a, b) -> {
                    a.retainAll(b);
                    return a;
                }).orElse(Collections.emptyList());
        System.out.println("list = " + list);
        return list;
    }
}
