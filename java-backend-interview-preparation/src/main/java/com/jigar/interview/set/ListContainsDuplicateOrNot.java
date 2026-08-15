package com.jigar.interview.set;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Set;


public class ListContainsDuplicateOrNot {
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(
                10, 20, 30, 40, 50, 30
        );

        Set<Integer> s = new HashSet<>() ;

        boolean b = false;
        for (int i : numbers)
        {
            if(!s.add(i))
            {
                b = true;
                break;
            }
        }

        System.out.println("List is duplicate or not => " + b);

        // expected output :
        // true

    }
}
