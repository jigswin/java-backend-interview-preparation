package com.jigar.interview.set;
import java.util.*;

public class FirstNonRepeatingElement {

    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(
                10, 20, 10, 30, 20, 40, 30, 50
        );

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i : numbers){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1)
            {
                System.out.println(entry.getKey());
                break;
            }
        }

        // expected output :
        // 40

    }
}
