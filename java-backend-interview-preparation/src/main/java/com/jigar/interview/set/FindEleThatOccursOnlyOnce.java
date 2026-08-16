package com.jigar.interview.set;

import java.util.*;

public class FindEleThatOccursOnlyOnce {
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10, 20, 10, 30, 20, 40, 50, 30);

        Set<Integer> seen = new LinkedHashSet<>();
        Set<Integer> duplicate = new LinkedHashSet<>();
        Set<Integer> differ = new LinkedHashSet<>();

        for(int i : numbers)
        {
            if(!seen.add(i))
            {
                duplicate.add(i);
            }
        }

        for (int i : seen)
        {
            if(!duplicate.contains(i))
            {
                differ.add(i);
            }
        }

        System.out.println(differ);

        // expected output
        // [40, 50]



    }
}
