package com.brilloconnetz.test2.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class ConcurrentPancakeShop {
    private static final int MAX_PANCAKES_MADE = 12;
    private final Random random = new Random();

    public CompletableFuture<Integer> makePancakes() {
        return CompletableFuture.supplyAsync(
                () -> random.nextInt(MAX_PANCAKES_MADE + 1)); // 0 to 12 pancakes
    }
}
