package c1_mydatastructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-22
 **/
public class TestLRU {

    public static void main(String[] args) {

        HashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(10, 0.75f, true);
        linkedHashMap.put(1, "11");
        linkedHashMap.put(2, "22");
        linkedHashMap.put(3, "33");
        linkedHashMap.put(4, "44");
        linkedHashMap.put(5, "55");

        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.print(entry.getKey() + "  ");
        }
        System.out.println();

        linkedHashMap.put(3, "333");
        linkedHashMap.get(5);

        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.print(entry.getKey() + "  ");
        }
        System.out.println();

        System.out.println("=============================");

        LRUCache<Integer, String> lruCache = new LRUCache<>(10);
        lruCache.put(1, "11");
        lruCache.put(2, "22");
        lruCache.put(3, "33");
        lruCache.put(4, "44");
        lruCache.put(5, "55");

        lruCache.printLRUCache();

        lruCache.put(3, "333");
        lruCache.get(5);

        lruCache.printLRUCache();
    }
}
