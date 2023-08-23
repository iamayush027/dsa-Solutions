package com.example.demo.cacheExample.PolicyHandler;


import com.example.demo.cacheExample.constants.EvictionPolicyEnum;
import org.junit.Test;
import org.springframework.util.Assert;

public class LRUPolicyTest {
    EvictionPolicyBase<Integer, Integer> cache;


    @Test
    public void checkCache() throws Exception {
        cache = EvictionPolicyFactory.getInstance().getHandler(EvictionPolicyEnum.LRU);
        cache.init(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Integer value1 = cache.get(1);
        cache.put(3, 3);
        cache.display();
        Integer value2 = cache.get(2);
        cache.put(4, 4);
        System.out.println("--------");
        cache.display();
        Integer value3 = cache.get(1);
        Assert.isTrue(value1 == 1, "First value is correct");
        Assert.isNull(value2, "Second value is correct");
        Assert.isNull(value3, "Third value is correct");

    }


}