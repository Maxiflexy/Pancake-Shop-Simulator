package com.brilloconnetz.test2.non_concurrent;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static com.brilloconnetz.test2.concurrent.ConcurrentPancakeSimulation.displaySlotResults;

public class NonConcurrentPancakeSimulation {

    public static void main(String[] args) {

        NonConcurrentPancakeShop shop = new NonConcurrentPancakeShop();
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

            int pancakesMade = shop.makePancakes();
            int totalPancakesEaten = 0;
            int unmetOrders = 0;

            for (User user : users) {
                int pancakesEaten = user.eatPancakes();
                totalPancakesEaten += pancakesEaten;

                if (pancakesEaten > pancakesMade) {
                    unmetOrders += (pancakesEaten - pancakesMade);
                    pancakesMade = 0;
                } else {
                    pancakesMade -= pancakesEaten;
                }
            }

            displaySlotResults(pancakesMade, totalPancakesEaten, unmetOrders);

            System.out.println("-----------------------------------------------------------");
        }

    }
}