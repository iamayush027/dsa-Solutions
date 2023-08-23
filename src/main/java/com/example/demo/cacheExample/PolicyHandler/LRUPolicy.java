package com.example.demo.cacheExample.PolicyHandler;

import com.example.demo.cacheExample.constants.EvictionPolicyEnum;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUPolicy<T, V> implements EvictionPolicyBase<T, V> {
    Map<T, V> cache;
    int CAPACITY;

    @Override
    public void put(T key, V value) throws Exception {
        if(cache!=null) {
            if (cache.size() == CAPACITY) {
                cache.remove(cache.entrySet().stream().findFirst().get().getKey());
            }
            cache.put(key, value);
            return;
        }
        throw new Exception("Cache no Initialised");
    }

    @Override
    public V get(T key) throws Exception {
        if(cache!=null) {
            if (cache.containsKey(key)) {
                V value = cache.get(key);
                cache.remove(key);
                cache.put(key, value);
//                System.out.println(value);
                return value;
            }
//            System.out.println("NOT FOUND");
            return null;
        }
        throw new Exception("Cache no Initialised");

    }

    public void display(){
        cache.entrySet().forEach(tvEntry -> System.out.println(tvEntry.getKey()+" "+tvEntry.getValue()));
    }
    @Override
    public void init(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.CAPACITY = capacity;
    }

    @Override
    public EvictionPolicyEnum getPolicyEnum() {
        return EvictionPolicyEnum.LRU;
    }
}
