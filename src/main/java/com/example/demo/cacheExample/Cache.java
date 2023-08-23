package com.example.demo.cacheExample;

import com.example.demo.cacheExample.PolicyHandler.EvictionPolicyBase;
import com.example.demo.cacheExample.PolicyHandler.EvictionPolicyFactory;
import com.example.demo.cacheExample.constants.EvictionPolicyEnum;

public class Cache {
    static EvictionPolicyFactory evictionPolicyFactory = EvictionPolicyFactory.getInstance();
    static Integer count =0 ;
    public static void main(String[] args) throws Exception {


       EvictionPolicyBase handler= evictionPolicyFactory.getHandler(EvictionPolicyEnum.LRU);
       handler.init(2);
        handler.put(1,1);
        handler.put(2,2);
        handler.get(1);
        handler.put(3,3);
        handler.get(2);
        handler.put(4,4);
        handler.get(1);
    }



}
