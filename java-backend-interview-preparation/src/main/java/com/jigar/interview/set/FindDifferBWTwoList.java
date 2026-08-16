package com.jigar.interview.set;

import java.util.*;

public class FindDifferBWTwoList {
    public static void main(String[] args)
    {
        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list2 = Arrays.asList(30, 40, 60, 70);

        Set<Integer> set = new HashSet<>(list2);
        Set<Integer> differList = new LinkedHashSet<>();

        for(int i : list1)
        {
            if(!set.contains(i)){
                differList.add(i);
            }
        }

        System.out.println(differList);

        // expected output
        // [10, 20, 50]

        // Approach 2 direct use of RemoveAll
        Set<Integer> difference = new LinkedHashSet<>(list1);

        difference.removeAll(list2);

        System.out.println(difference);

    }
}
