package com.jigar.interview.set;

import java.util.*;

public class RemoveDuplicate {

    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 40, 30
        );

        Set<Integer> s = new LinkedHashSet<>();

        for (int i : numbers)
        {
            s.add(i);
        }

        System.out.println(s);
    }
}
