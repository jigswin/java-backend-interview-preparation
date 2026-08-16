package com.jigar.interview.hashmap;
import java.util.*;

public class FirstNonRepeatingChar {

    public static void main(String[] args)
    {
        String str = "aabbfdde";

        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1)
            {
                System.out.println(entry.getKey());
                break;
            }
        }

        // expected output
        // f
    }
}
