package com.ming.demo.design.pattern.closeopen;

import com.google.common.collect.Lists;
import com.ming.demo.design.pattern.closeopen.bean.ApiStatInfo;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 针对开闭原则得一个demo
 */
public class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ...省略设置apiStatInfo数据值的代码
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }

    @Test
    public void test() {
        String s = "|saleMallVersionC|trainHotelReturnCash|npaypass|notSelectSeat|bAccReg|zlRO|newJavaSys";
        if (s.contains("trainHotelReturnCah")) {
            System.out.println("haha");
        }

        BigDecimal bigDecimal = new BigDecimal(3).setScale(0, RoundingMode.CEILING);
        System.out.println("bigDecimal = " + bigDecimal);

        BigDecimal multiply = new BigDecimal(128).divide(BigDecimal.TEN, 0, RoundingMode.CEILING).multiply(BigDecimal.TEN);
        System.out.println("multiply = " + multiply);
    }

    @Test
    public void genericsAndWildCard() {
        List<Integer> list01 = Lists.newArrayList();
        List<Object> list02 = Lists.newArrayList();
        list01.add(1);
        list01.add(2);
        double v = wildCardExtendTest(list01);
//        double v1 = wildCardExtendTest(list02); // 编译错误
        System.out.println("v = " + v);

        wildCardSuperTest(list01);
        wildCardSuperTest(list02);
    }

    /**
     * 通配符上限，适合从集合中获取元素而不涉及修改操作
     *
     * @param list
     * @return
     */
    public double wildCardExtendTest(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    /**
     * 通配符下限，更适合往集合中添加元素
     *
     * @param list
     * @return
     */
    public void wildCardSuperTest(List<? super Integer> list) {
        for (Object o : list) {
            System.out.println("o = " + o);
        }

        list.add(3);
        list.add(4);
        list.add(5);
        for (Object o : list) {
            System.out.println("o = " + o);
        }
    }

    /**
     * 泛型上限，适合从集合中获取元素而不涉及修改操作
     *
     * @param list
     * @return
     */
    public <T extends Number> double genericsExtendTest(List<T> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

}