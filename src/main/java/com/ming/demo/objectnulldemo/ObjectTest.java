package com.ming.demo.objectnulldemo;

import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Ming
 * @date 26/1/2022-下午 3:12
 */
public class ObjectTest {
    /**
     * 简单说明：
     * <P>整个对象为null那么会导致NPE</P>
     * <P>整个对象不为null，其内个别字段为null，不会导致NPE</P>
     */
    @Test
    public void testNullObject() {
        MemberCards cards = MemberCards.builder()
                .iconUrl("http://hahaha.com")
                .registerUrl("register")
                .resetPasswordUrl("sbhjdg")
                .build();
        // 会导致转convertBuilder()报错：NPE
        cards = null;
        MemberBaseInfo info = convertBuilder(cards);
        System.out.println("convertBuilder= " + info.toString());
        // NPE error will be through if sourceUrl is null
        if (info.getSourceUrl().equals("123456")) {
            System.out.println("success");
        }
    }

    public MemberBaseInfo convertBuilder(MemberCards card) {
        MemberBaseInfo baseInfo = new MemberBaseInfo();
        baseInfo.setIconUrl(card.getIconUrl());
        baseInfo.setSourceUrl(card.getSourceUrl());
        baseInfo.setRegisterUrl(card.getRegisterUrl());
        baseInfo.setResetPasswordUrl(card.getResetPasswordUrl());

        return baseInfo;
        /*return MemberBaseInfo.builder()
                .iconUrl(card.getIconUrl())
                .sourceUrl(card.getSourceUrl())
                .registerUrl(card.getRegisterUrl())
                .resetPasswordUrl(card.getResetPasswordUrl())
                .build();*/
    }


    /**
     * 泛型方法 对于泛型的声明要在返回值前面
     */
    public <T, R> R convertBuilder(Function<T, R> fun) {
//        return fun.apply(T);
        return null;
    }

    @Test
    public void test() {
        String[] strings = new String[0];
        if (strings.length == 0) {
            System.out.println("空的");
            System.out.println(strings.length);
        }

        List<String> list = Lists.newArrayList();
        list.add("MU");
        list.add("CS");
        list.add("FM");
        String[] array = list.toArray(new String[0]);
        for (String s : array) {
            System.out.println("s = " + s);
        }
        System.out.println("array.length = " + array.length);
    }
}
