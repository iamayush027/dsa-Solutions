package com.example.demo.cacheExample.PolicyHandler;

import com.example.demo.cacheExample.Exception.InvalidInputException;
import com.example.demo.cacheExample.constants.EvictionPolicyEnum;

public class EvictionPolicyFactory {
    private static EvictionPolicyFactory INSTANCE;

    private EvictionPolicyFactory() {
    }

    public static EvictionPolicyFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EvictionPolicyFactory();
        }
        return INSTANCE;
    }

    public EvictionPolicyBase getHandler(EvictionPolicyEnum evictionPolicyEnum) throws InvalidInputException {
        switch (evictionPolicyEnum) {
            case LRU -> {
                return new LRUPolicy();

            }
            default -> throw new InvalidInputException("Invalid Enum: " + evictionPolicyEnum);
        }
    }
}
