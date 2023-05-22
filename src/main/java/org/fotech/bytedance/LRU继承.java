package org.fotech.bytedance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存的linked实现。
 * 重写linkedhashmap的删除规则，即可实现删除最后访问的功能
 */
class LRU继承 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRU继承(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

