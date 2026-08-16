package com.jigar.interview.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonEleBWThreeList {
    public static void main(String[] args)
    {
        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);

        List<Integer> list2 = Arrays.asList(20, 30, 40, 60);

        List<Integer> list3 = Arrays.asList(30, 40, 70, 80);

        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        for(int i : list3)
        {
            if(set1.contains(i) && set2.contains(i))
            {
                System.out.println(i);
            }
        }

        // expected output
        // 30
        // 40


        // Approach 2 direct use of retainAll()
        Set<Integer> common = new HashSet<>(list1);

        common.retainAll(list2);
        common.retainAll(list3);

        System.out.println(common);
    }
}
