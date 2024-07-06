package com.brilloconnetz.test2.non_concurrent;

import java.util.Random;

public class NonConcurrentPancakeShop {
    private static final int MAX_PANCAKES_MADE = 12;
    private final Random random = new Random();

    public int makePancakes() {
        return random.nextInt(MAX_PANCAKES_MADE + 1);
    }
}
