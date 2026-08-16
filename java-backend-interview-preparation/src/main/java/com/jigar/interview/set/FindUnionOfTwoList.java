package com.jigar.interview.set;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FindUnionOfTwoList {
    public static void main(String[] args)
    {
        List<Integer> list1 = Arrays.asList(10, 20, 30, 40);

        List<Integer> list2 = Arrays.asList(30, 40, 50, 60);

        Set<Integer> set = new LinkedHashSet<>(list1);

        for(int i : list2)
        {
            if(!set.contains(i)){
                set.add(i);
            }
        }

        System.out.println(set);

        // expected output
        // [10, 20, 30, 40, 50, 60]

        // Approach 2 direct use of addAll()
        Set<Integer> union = new LinkedHashSet<>(list1);
        union.addAll(list2);

        System.out.println(union);
    }
}
