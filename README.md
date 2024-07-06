# Pancake-Shop-Simulator

<p>This project simulates a pancake shop where a shopkeeper makes pancakes and three 
users eat them.
The system operates in 30-second slots, with specific constraints on
pancake consumption and production, the simulation provides insights into pancake production,
consumption, wastage, and user satisfaction.
The project includes both non-concurrent and concurrent versions of the simulation,
comparing their performance and behavior.</p>

## Overview
This project implements both non-concurrent and concurrent Java programs to solve 
the pancake simulation problem:

1. ### Non-Concurrent Program:

  * Simulates the scenario without using threads or ExecutorServices.
  * Runs sequentially to process each 30-second slot.
  * Uses simple loops and method calls for pancake production and user consumption.

2. ### Concurrent Program:

   * Uses CompletableFuture for asynchronous programming without directly using
   threads or ExecutorServices.
   * Simulates pancake production and user consumption concurrently.
   * Demonstrates parallelism in processing multiple user actions simultaneously 
   * within each slot.
   
## Features
   
* Pancake Production: Shopkeepers can produce up to 12 pancakes every 30 seconds.
* User Consumption: Each user can eat up to 5 pancakes within the same 30-second interval.
* Slot-based Processing: Outputs starting and ending times of each 30-second slot, 
pancakes made, eaten, wasted, and any unmet user orders.
* Random Generation: Randomly determines the number of pancakes each user wants to eat within the limit.


## Technologies Used
Java 8 (or higher) for core programming
CompletableFuture for asynchronous processing
Prerequisites
Java Development Kit (JDK) 8 or higher installed
Integrated Development Environment (IDE) configured for Java development (e.g., IntelliJ IDEA, Eclipse)