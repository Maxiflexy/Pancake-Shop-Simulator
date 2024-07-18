package com.brilloconnetz.test2.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class User {

    private static final int MAX_PANCAKES_EATEN = 5;
    private final Random random = new Random();

    public CompletableFuture<Integer> eatPancakes() {
        return CompletableFuture.supplyAsync(

                () -> random.nextInt(MAX_PANCAKES_EATEN + 1));


        // 0 to 5 pancakes
    }
}
