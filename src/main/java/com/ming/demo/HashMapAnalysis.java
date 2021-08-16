package com.ming.demo;

/**
 * @author: Ming
 * @Date: 2021/7/1 14:01
 * @Description: hashMap分析
 */
public class HashMapAnalysis {

	/**
	 * 计算hash值：
	 * 		1. 将key的hashCode右移16位再与其进行 异或运算
	 * 			1.1 目的：保留高位信息，值多样性，减少hash碰撞，分布更均匀
	 */
	/*static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}*/
	/**
	 * 计算数组桶的下标：
	 * 		1. 在putVal()方法内有如下几行代码，先n = (tab = resize()).length获得table的长度
	 * 		2. 根据 hash &（n-1）获得要被插入数据桶的index，若该位置为0则直接执行newNode()将数值插入桶；
	 * 			2.1：否则进行插入链表或插入红黑树的步骤
	 * 	important: 	hash &（n-1） == hash % n; 位于运算效率远告诉算数运算，前提table长度必须为 2^n(2的幂次方)
	 */
	/* if ((tab = table) == null || (n = tab.length) == 0)
				n = (tab = resize()).length;
     if ((p = tab[i = (n - 1) & hash]) == null)
				tab[i] = newNode(hash, key, value, null);
	*/



	/**
	 * 以下方法为扩容时:
	 * 以下三步为第一条件分支：
	 * 1.<p>第一步先判断oldCap>0,说明旧的table已被初始化，判断其大小是否小于Integer.MaxValue</p>
	 * 		1.1:大于则不在扩容，返回原来oldCap;
	 * 		1.2:小于则 old << 1容量double
	 */
	/*if (oldCap > 0) {
		if (oldCap >= MAXIMUM_CAPACITY) {
			threshold = Integer.MAX_VALUE;
			return oldTab;
		}
		else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
				oldCap >= DEFAULT_INITIAL_CAPACITY)
			newThr = oldThr << 1; // double threshold
	}*/
	/**
	 * 2. threshold > 0，且桶数组未被初始化
	 *   2.1：调用 HashMap(int) 和 HashMap(int, float) 构造方法时会产生这种情况，此种情况下 newCap = oldThr，newThr 在第二个条件分支中算出
	 *   2.2：这里把oldThr > 0情况单独拿出来说一下。在这种情况下，会将 oldThr 赋值给 newCap，等价于newCap = threshold = tableSizeFor(initialCapacity)。
	 *   我们在初始化时传入的 initialCapacity 参数经过 threshold 中转最终赋值给了 newCap。
	 */
	/*else if (oldThr > 0) // initial capacity was placed in threshold
	newCap = oldThr;*/
	/**
	 * 3. 走到此处意味着oldCap == 0& oldThr == 0,同数组违背初始化，且threshold为0
	 * 调用 HashMap() 构造方法会产生这种情况。
	 */
	/*else {               // zero initial threshold signifies using defaults
		newCap = DEFAULT_INITIAL_CAPACITY;
		newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
	}*/

	/**
	 * 扩容时：
	 * 第二分支
	 * 覆盖情况为：第一个条件分支未计算 newThr 或嵌套分支在计算过程中导致 newThr 溢出归零
	 */
	/*if (newThr == 0) {
		float ft = (float)newCap * loadFactor;
		newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
				(int)ft : Integer.MAX_VALUE);
	}*/

	/**
	 * 扩容后链表要分链之链表：
	 * 1. 依据条件：(e.hash & oldCap) == 0 判断，符合放入低链loList
	 * 2. 否则放入高链 hiList
	 * 扩容后链表虽然重新计算映射，但链表的相对顺序并未发生变化，依然保持之前的顺序
	 */
	/*Node<K,V> loHead = null, loTail = null;
	Node<K,V> hiHead = null, hiTail = null;
	Node<K,V> next;
                        do {
		next = e.next;
		if ((e.hash & oldCap) == 0) {
			if (loTail == null)
				loHead = e;
			else
				loTail.next = e;
			loTail = e;
		}
		else {
			if (hiTail == null)
				hiHead = e;
			else
				hiTail.next = e;
			hiTail = e;
		}
	} while ((e = next) != null);*/
	/**
	 * 若扩容：则需要拆树，那么使用split()方法
	 * 因为TreeNode也保留了在转换为红黑树前链表结构的 pre&next指针保留原链表节点顺序，所以重新映射红黑树与重新映射链表逻辑基本一致；
	 * 不同在于重新映射后，将根据链表长度是否小于UNTREEIFY_THRESHOLD，将链表转为普通链表；否则重新将TreeNode树化
	 */
	/*final void split(HashMap<K,V> map, Node<K,V>[] tab, int index, int bit) {
		TreeNode<K,V> b = this;
		// Relink into lo and hi lists, preserving order
		TreeNode<K,V> loHead = null, loTail = null;
		TreeNode<K,V> hiHead = null, hiTail = null;
		int lc = 0, hc = 0;
		for (TreeNode<K,V> e = b, next; e != null; e = next) {
			next = (TreeNode<K,V>)e.next;
			e.next = null;
			if ((e.hash & bit) == 0) {
				if ((e.prev = loTail) == null)
					loHead = e;
				else
					loTail.next = e;
				loTail = e;
				++lc;
			}
			else {
				if ((e.prev = hiTail) == null)
					hiHead = e;
				else
					hiTail.next = e;
				hiTail = e;
				++hc;
			}
		}

		if (loHead != null) {
		// 若loHead不为空，且链表长度小于6则将TreeNode转化为普通listNode
			if (lc <= UNTREEIFY_THRESHOLD)
				tab[index] = loHead.untreeify(map);
			else {
				tab[index] = loHead;
         // hiHead == null 时，表明扩容后，所有节点仍在原位置，树结构不变，无需重新树化
				if (hiHead != null) // (else is already treeified)
					loHead.treeify(tab);
			}
		}
		// 同上
		if (hiHead != null) {
			if (hc <= UNTREEIFY_THRESHOLD)
				tab[index + bit] = hiHead.untreeify(map);
			else {
				tab[index + bit] = hiHead;
				if (loHead != null)
					hiHead.treeify(tab);
			}
		}
	}*/
	/**
	 * 红黑树小于UNTREEIFY_THRESHOLD，就要链化使用untreefiy()方法
	 * 	1.1 链表红黑树化使用treefiyBin()方法，首先下要判断(n = tab.length) < MIN_TREEIFY_CAPACITY,也就是说容量若是
	 * 			小于64先进行扩容，暂不进行红黑树化；过早的红黑树化增加复杂度，同时过早的红黑树化会面临过多过早的红黑树拆分影响效率；
	 */
	/*final Node<K,V> untreeify(HashMap<K,V> map) {
		Node<K,V> hd = null, tl = null;
		// 遍历 TreeNode 链表，并用 Node 替换
		for (Node<K,V> q = this; q != null; q = q.next) {
			// 替换节点类型
			Node<K,V> p = map.replacementNode(q, null);
			if (tl == null)
				hd = p;
			else
				tl.next = p;
			tl = p;
		}
		return hd;
	}

	Node<K,V> replacementNode(Node<K,V> p, Node<K,V> next) {
		return new Node<>(p.hash, p.key, p.value, next);
	}*/
}
