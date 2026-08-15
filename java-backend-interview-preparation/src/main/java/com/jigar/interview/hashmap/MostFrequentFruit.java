package com.jigar.interview.hashmap;
import java.util.*;

public class MostFrequentFruit {
    public static void main(String[] args)
    {
        List<String> fruits = Arrays.asList(
                "apple",
                "banana",
                "apple",
                "mango",
                "banana",
                "apple",
                "orange",
                "banana"
        );

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String f : fruits)
        {
            map.put(f, map.getOrDefault(f, 0)+1);
        }

        String keyname = "";
        int max = 0;

        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
            {
                keyname = entry.getKey();
                max = entry.getValue();
            }
        }

        System.out.println(keyname + " => "+ max);
    }

    // expected output frits max frequent value
    // apple => 3
}
