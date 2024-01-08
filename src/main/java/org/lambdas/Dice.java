package org.lambdas;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Lets roll the dice and see how much steps we need to get three times six *** ***
 */

public class Dice {
    public static void main(String[] args) {

        int numberOfSteps = 0;
        int gotSix = 0;
        Random randomSupplier = new Random();
        while (gotSix < 3) {
            IntStream dice = IntStream.generate(() -> randomSupplier.nextInt(6) + 1);
            numberOfSteps++;
            int number = dice.findFirst().getAsInt();
            System.out.printf("Generated number is: %d and gotSix: %d%n", number, gotSix);
            gotSix = (number == 6) ? ++gotSix : gotSix;
        }

        System.out.println("number of steps needed: " + numberOfSteps + " got six times: " + gotSix);


    }
}
