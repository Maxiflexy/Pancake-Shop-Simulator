package com.brilloconnetz.test2.concurrent;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConcurrentPancakeSimulation {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ConcurrentPancakeShop shop = new ConcurrentPancakeShop();
        User[] users = { new User(), new User(), new User() };
        int slotDuration = 30; // 30 seconds
        int numberOfSlots = 3; // Number of 30-second slots to simulate

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime startTime = LocalTime.now();

        for (int slot = 1; slot <= numberOfSlots; slot++) {
            LocalTime slotStartTime = startTime.plusSeconds((long) (slot - 1) * slotDuration);
            LocalTime slotEndTime = slotStartTime.plusSeconds(slotDuration);

            System.out.println("Starting time of the 30 seconds slot: " + slotStartTime.format(formatter));
            System.out.println("Ending time of the 30 seconds slot: " + slotEndTime.format(formatter));

            CompletableFuture<Integer> pancakesMadeFuture = shop.makePancakes();
            CompletableFuture<Integer>[] userEatingFutures = new CompletableFuture[users.length];
            for (int i = 0; i < users.length; i++) {
                userEatingFutures[i] = users[i].eatPancakes();
            }


            int pancakesMade = pancakesMadeFuture.get();

            int totalPancakesEaten = 0;
            int unmetOrders = 0;

            for (CompletableFuture<Integer> future : userEatingFutures) {
                int pancakesEaten = future.get();
                if (pancakesEaten > pancakesMade){
                    unmetOrders += (pancakesEaten - pancakesMade);
                    totalPancakesEaten += pancakesMade;
                    pancakesMade = 0;
                }else {
                    totalPancakesEaten += pancakesEaten;
                    pancakesMade -= pancakesEaten;
                }

            }

            displaySlotResults(pancakesMade, totalPancakesEaten, unmetOrders);
            System.out.println("---------------------------------");
        }

    }

    public static void displaySlotResults(int pancakesMade, int totalPancakesEaten, int unmetOrders) {
        int pancakesWasted = Math.max(pancakesMade, 0);
        boolean needsMet = unmetOrders == 0;

        System.out.println("Number of pancakes made by the shopkeeper: " + (pancakesMade + totalPancakesEaten));
        System.out.println("Number of pancakes eaten by the 3 users: " + totalPancakesEaten);
        System.out.println("Whether the shopkeeper was able to meet the needs of the 3 users: " + (needsMet ? "Yes" : "No"));
        System.out.println("Number of pancakes wasted: " + pancakesWasted);
        if (!needsMet) {
            System.out.println("Number of pancake orders not met: " + unmetOrders);
        }
    }
}
