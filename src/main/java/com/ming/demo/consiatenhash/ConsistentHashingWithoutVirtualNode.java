package com.ming.demo.consiatenhash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash算法不包含虚拟节点
 *
 * @author Ming
 */
public class ConsistentHashingWithoutVirtualNode {
    /**
     * 待添加入hash环的服务器列表
     */
    private static final String[] SERVERS = {"192.168.0.1:8888", "192.168.0.2:8888", "192.168.0.3:8888"};

    /**
     * key标识服务器hash的值，value表示服务器
     * <P>因为服务器要分布到hash环上，并且需要根据被存储的值的hash值按顺序结果寻找到最近的SERVER上，所以此处使用TreeMap能够保留顺序特征</P>
     */
    private static final SortedMap<Integer, String> SORTED_MAP = new TreeMap<>();

    //静态代码块会随着类的加载在静态变量加载之后加载
    static {
        for (String server : SERVERS) {
            int hash = getHash(server);
            System.out.println("[" + server + "]加入集合中, 其Hash值为" + hash);
            SORTED_MAP.put(hash, server);
        }
    }

    /**
     * 得到应当路由到的服务器节点
     * @param key 需要被存储的健
     */
    private static String getServer(String key) {
        //得到该key的hash值
        int hash = getHash(key);
        //得到大于该Hash值的所有Map
        SortedMap<Integer, String> subMap = SORTED_MAP.tailMap(hash);
        if (subMap.isEmpty()) {
            //如果没有比该key的hash值大的，则从第一个node开始
            Integer i = SORTED_MAP.firstKey();
            //返回对应的服务器
            return SORTED_MAP.get(i);
        } else {
            //第一个Key就是顺时针过去离node最近的那个结点
            Integer i = subMap.firstKey();
            //返回对应的服务器
            return subMap.get(i);
        }
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值
     */
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void main(String[] args) {
        String[] keys = {"semlinker", "kakuqo", "fer"};
        for (String key : keys) {
            System.out.println("[" + key + "]的hash值为" + getHash(key)
                    + ", 被路由到结点[" + getServer(key) + "]");
        }
    }
}