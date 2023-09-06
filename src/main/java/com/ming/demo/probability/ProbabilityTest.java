package com.ming.demo.probability;

import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Ming
 * @date 6/9/2023-上午 10:44
 */
public class ProbabilityTest {

    private static final Random RANDOM = new Random();

    private double getDoubleRandom() {
        return RANDOM.nextDouble();
    }

    /**
     * 一种简单的概率模型
     */
    @Test
    public void simpleProbabilityOfWinningTest() {
        // 分子
        double molecule = 35000;
        // 分母
        double denominator = 100000;
        // 中奖概率
        double probability = molecule / denominator;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        for (int i = 0; i < 100000; i++) {
            // 判断是否中奖
            if (getDoubleRandom() > probability) {
                continue;
            }
            // 判断能中第几阶梯
            // 三个等级
            List<Integer> numberList = Arrays.asList(5000, 10000, 20000);
            // 借助TreeMap底层数据结构的特性来帮助判断命中概率和等级
            TreeMap<Double, Integer> drawTreeMap = new TreeMap<>();
            double sumProbability = 0;
            int priority = 0;
            for (Integer number : numberList) {
                // 每个阶梯得概率
                sumProbability = sumProbability + number / molecule;
                drawTreeMap.put(sumProbability, ++priority);
            }
            SortedMap<Double, Integer> sortedMap = drawTreeMap.tailMap(getDoubleRandom());
            if (MapUtils.isEmpty(sortedMap)) {
                continue;
            }
            Integer integer = sortedMap.get(sortedMap.firstKey());
            if (Objects.nonNull(integer) && integer.equals(1)) {
                ++p1;
            } else if (Objects.nonNull(integer) && integer.equals(2)) {
                ++p2;
            } else if (Objects.nonNull(integer) && integer.equals(3)) {
                ++p3;
            }
        }
        System.out.printf("一等奖：%s,二等奖：%s,三等奖：%s%n", p1, p2, p3);
    }
}
