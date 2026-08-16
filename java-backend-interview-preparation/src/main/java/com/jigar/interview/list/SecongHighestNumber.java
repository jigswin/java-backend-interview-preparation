package com.jigar.interview.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecongHighestNumber {

    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10, 50, 20, 80, 30, 80, 40);

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int number : numbers) {

            if (number > highest) {

                secondHighest = highest;
                highest = number;

            } else if (number > secondHighest && number != highest) {

                secondHighest = number;
            }
        }

        System.out.println("Highest => " + highest);
        System.out.println("Second Highest => " + secondHighest);


        // expected output
        // Highest => 80
        // Second Highest => 50


    }
}
