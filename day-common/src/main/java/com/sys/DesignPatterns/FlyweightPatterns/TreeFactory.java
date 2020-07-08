package com.sys.DesignPatterns.FlyweightPatterns;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 树的工厂，hashmap 中获得数据，节省资源
 *
 * Create by yang_zzu on 2020/7/8 on 21:12
 */
public class TreeFactory {

    private static Map<String, Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name, String date) {
        if (map.containsKey(name)) {
            return map.get(name);
        } else {
            Tree tree = new Tree(name, date);
            map.put(name, tree);
            return tree;
        }
    }

}
