package com.example.demo.cacheExample.PolicyHandler;

import com.example.demo.cacheExample.constants.EvictionPolicyEnum;

public interface EvictionPolicyBase<T, V> {
    public void put(T key, V value) throws Exception;

    public V get(T key) throws Exception;

    public void init(int capacity);
    public void display();

    public EvictionPolicyEnum getPolicyEnum();

}
