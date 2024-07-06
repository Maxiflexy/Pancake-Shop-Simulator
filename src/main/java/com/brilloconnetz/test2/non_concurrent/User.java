package com.brilloconnetz.test2.non_concurrent;

import java.util.Random;

public class User {

    private static final int MAX_PANCAKES_EATEN = 5;
    private final Random random = new Random();

    public int eatPancakes() {
        return random.nextInt(MAX_PANCAKES_EATEN + 1);
    }
}
