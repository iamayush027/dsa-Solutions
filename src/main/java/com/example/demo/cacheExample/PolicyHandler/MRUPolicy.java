package com.example.demo.cacheExample.PolicyHandler;

import com.example.demo.cacheExample.constants.EvictionPolicyEnum;

import java.util.Map;

public class MRUPolicy<T, V> implements EvictionPolicyBase<T, V> {
    Map<T, V> cache;
    int CAPACITY;

    @Override
    public void put(T key, V value) throws Exception {
        if (cache != null) {
            if (cache.size() == CAPACITY) {
                T lastKey = null;
                int index = 0;
                for (T t :
                        cache.keySet()) {
                    index++;
                    if (index == this.CAPACITY) {
                        lastKey = t;
                    }
                }
                cache.remove(lastKey);
            }
            cache.put(key, value);
            return;
        }
        throw new Exception("Cache no Initialised");
    }

    @Override
    public V get(T key) throws Exception {
        return null;
    }

    @Override
    public void init(int capacity) {

    }

    @Override
    public void display() {

    }

    @Override
    public EvictionPolicyEnum getPolicyEnum() {
        return EvictionPolicyEnum.MRU;
    }
}
