package com.jigar.interview.hashmap;
import org.w3c.dom.css.CSSStyleRule;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args)
    {
        String[] words = {
                "eat",
                "tea",
                "tan",
                "ate",
                "nat",
                "bat"
        };

        Map<String, List<String>> map = new LinkedHashMap<>();

        for(String w : words)
        {
            char[] chars = w.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            // 1st approach
            // map.computeIfAbsent(key, k -> new ArrayList<>()).add(w);
            // 1st approach

            // 2nd approach
            if(!map.containsKey(key))
            {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(w);
            // 2nd approach
        }

        System.out.println(map.values());


        // expected output
        // [[eat, tea, ate], [tan, nat], [bat]]
    }
}
