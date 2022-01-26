package com.ming.demo.objectnulldemo;

import org.junit.Test;

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
        if (info.getSourceUrl().equals("123456")){
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


    /*public MemberBaseInfo convertBuilder(Function<MemberCards,MemberBaseInfo> fun){
        return fun.apply();
    }*/
}
