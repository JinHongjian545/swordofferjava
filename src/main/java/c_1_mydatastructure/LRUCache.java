package c_1_mydatastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * @program: swordofferjava
 * @description: 基于HashMap加双向链表的LRU缓存实现，最近最少使用策略 LRU（Least Recently Used）缓存淘汰算法
 * @author: Jin Hongjian
 * @create: 2020-07-22
 **/
public class LRUCache<K, V> {
    class Node<K, V> {
        K k;
        V v;
        Node<K, V> before;
        Node<K, V> after;

        Node() {
        }

        Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    //LRU成员
    private int size;
    private int capacity;
    private Node<K, V> head, tail; //head, tail哨兵节点，数据节点放在中间，避免两端访问判断，早进来的节点靠近尾部
    private HashMap<K, Node<K, V>> hashMap;

    //构造器，这里初始化哨兵节点

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity * 3 / 4 + 1); //初始化hashMap，避免扩容，直接给初始容量
        head = new Node<>();
        tail = new Node<>();
        head.after = tail;
        tail.before = head;
    }

    //从缓存中获取并更新缓存中数据位置
    public V get(K k) {
        Node<K, V> kvNode = hashMap.get(k);
        if (kvNode == null) {
            return null;
        }
        //缓存中存在，定位到该节点，并把该节点放到头部来，表示刚刚访问过
        removeNode(kvNode);
        addToHead(kvNode);
        return kvNode.v;
    }

    //数据写入缓存
    public void put(K k, V v) {
        //先从缓存中查找
        Node<K, V> kvNode = hashMap.get(k);
        //缓存中没有
        if (kvNode == null) {
            Node<K, V> newNode = new Node<>(k, v);
            addToHead(newNode);
            hashMap.put(k, newNode);
            if (size == capacity) { //缓存满
                deleteTail();
            } else { //缓存未满
                size++;
            }
        } else { //缓存中已经存在该节点
            removeNode(kvNode);
            kvNode.v = v;
            addToHead(kvNode);
        }
    }

    //添加到链表头部
    private void addToHead(Node<K, V> kvNode) {
        kvNode.after = head.after;
        kvNode.before = head;
        head.after = kvNode;
    }

    //从链表中删除节点
    private void removeNode(Node<K, V> kvNode) {
        kvNode.before.after = kvNode.after;
        kvNode.after.before = kvNode.before;
    }

    //删除链表尾部节点
    private void deleteTail() {
        removeNode(tail.before);
    }

    public void printLRUCache() {
        Node<K, V> kvNode = tail.before;
        System.out.println("KEY--->VALUE");
        while (kvNode != head) {
            System.out.print(kvNode.k + "--->" + kvNode.v + "   ");
            kvNode = kvNode.before;
        }
        System.out.println();
    }
}
