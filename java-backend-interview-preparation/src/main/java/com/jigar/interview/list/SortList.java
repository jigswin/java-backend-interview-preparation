package com.jigar.interview.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortList {
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(10,50,30,20,40);

        Collections.sort(numbers);
        System.out.println(numbers);

        // expected output
        // [10, 20, 30, 40, 50]
    }
}
