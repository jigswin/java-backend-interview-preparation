package com.jigar.interview.set;

import java.util.*;

public class CommonElementBWToList {

    public static void main(String[] args)
    {
        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list2 = Arrays.asList(30, 40, 60, 70);

        Set<Integer> set = new HashSet<>(list1);

        for (int l : list2)
        {
            if(set.contains(l))
            {
                System.out.println(l);
            }
        }

        // expected output
        // 30
        // 40
    }
}
