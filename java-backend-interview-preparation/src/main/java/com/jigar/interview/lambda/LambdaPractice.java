package com.jigar.interview.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaPractice {
    public static void main(String[] args)
    {
        // Lambda with Sorting
        List<Integer> numbers = new ArrayList<>(List.of(
                10,50,30,40,20
        ));

        numbers.sort(
                (a,b) -> a-b
        );

        System.out.println(numbers);



        // Lambda + Comparator
        List<String> names = new ArrayList<>(List.of(
                "jigs" , "nagar", "bhavarlal", "damyantidevi", "leeladevi", "pavan", "gautam"
        ));

        names.sort(
                (a,b) -> a.compareTo(b)
        );
        System.out.println(names);


        // Lambda + Stream API
        // find even number from list

        List<Integer> num = List.of(10,4,5,7,20,11,12,8);

        List<Integer> evenNum = num.stream()
                .filter(
                n -> n % 2 == 0)
                .toList();

        System.out.println(evenNum);

    }
}
