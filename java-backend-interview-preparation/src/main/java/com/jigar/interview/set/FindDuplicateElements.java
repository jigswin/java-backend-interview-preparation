package com.jigar.interview.set;
import java.util.*;
public class FindDuplicateElements {
    public static void main(String[] args)
    {

        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 40, 30, 50
        );

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicate = new LinkedHashSet<>();

        for(int i : numbers)
        {
            if(!seen.add(i))
            {
                duplicate.add(i);
            }
        }

        System.out.println(seen);
        System.out.println(duplicate);
    }


    // expected output :
    // [10, 20, 30]

}
