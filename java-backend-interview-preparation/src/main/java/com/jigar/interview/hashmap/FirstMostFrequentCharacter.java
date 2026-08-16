package com.jigar.interview.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstMostFrequentCharacter {
    public static void main(String[] args)
    {
        String str = "programming";

        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i = 0;i<str.length();i++)
        {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0) + 1);
        }

        int max= 0;
        char c = '\0';

        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if((entry.getValue() > max))
            {
                max = entry.getValue();
                c = entry.getKey();
            }
        }

        System.out.println(c + " => " + max);

        // expected output
        // r => 2
    }
}
