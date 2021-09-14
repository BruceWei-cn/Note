### ConcurrentHashMap

##### put大致步骤

1. 根据key计算处hashcode;
2. 判断是否需要进行初始化；
3. 即为当前key定位处node,如果为空表示当前位置可以写入数据，利用cas尝试写入，失败自旋保证；
4. 如果当前位置的hashcode == MOVED == -1,则需要进行扩容；
5. 如果都不满足，利用synchronized锁写入数据；
6. 如果数据量大约TREEIFY_THRESHOLD则要转为红黑树；

##### put代码分析

```java
final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();
    // 根据key计算出hashcode
        int hash = spread(key.hashCode());
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh;
            // 判断是否需要进行初始化
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                // 根据当前key计算出的Node,r如果为空表示当前位置可以写入数据，利用cas尝试写入，失败自旋保证成功
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null)))
                    break;                   // no lock when adding to empty bin
            }
            // 如果当前位置的hashcode == MOVED==-1，则需要扩容
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else {
                V oldVal = null;
                // 以上都不符合，则利用synchronized锁写入数据
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key,
                                                              value, null);
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                if (binCount != 0) {
                    // bin下的node节数量大于TREEIFY_THRESHOLD=8，进行树化
                    if (binCount >= TREEIFY_THRESHOLD)
                        // tab = table; -> The array of bins
                        // 树化过程先要判断tab容量是否>MIN_TREEIFY_CAPACITY = 64;
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);
        return null;
    }
```

##### get大致步骤

- 根据计算出来的 hashcode 寻址，如果就在桶上那么直接返回值。
- 如果是红黑树那就按照树的方式获取值。
- 就不满足那就按照链表的方式遍历获取值。

##### get代码分析

> - volatile V val;
>
> - volatile Node<K,V> next;
>
> 注：get操作没有加synchronized,因为val&next都被volatile修饰，如果值变动不同线程间可见！

```java
public V get(Object key) {
        Node<K,V>[] tab; Node<K,V> e, p; int n, eh; K ek;
    // 根据key计算hash值
        int h = spread(key.hashCode());
    // 通过key定位数组下标是否为空，判断数组是否为空
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (e = tabAt(tab, (n - 1) & h)) != null) {
            // 	判断是否在数组上，是，直接返回
            if ((eh = e.hash) == h) {
                if ((ek = e.key) == key || (ek != null && key.equals(ek)))
                    return e.val;
            }
            // 如果是红黑树结构，从红黑树里面查询
            else if (eh < 0)
                return (p = e.find(h, key)) != null ? p.val : null;
            // 如果是链表，循环遍历找出对应的值
            while ((e = e.next) != null) {
                if (e.hash == h &&
                    ((ek = e.key) == key || (ek != null && key.equals(ek))))
                    return e.val;
            }
        }
        return null;
    }
```

##### HashTable

> 线程安全，是给整个hash表加了一把大锁，多线程访问操作该对象，同一时刻只能由一个线程获取资源；
>
> 默认：this(initCapacity:11, loadFactory:0.75f)
>
> 所有操作都加上：synchronized

