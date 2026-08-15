package com.jigar.interview.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * HashMap is used to store data in Key-Value pairs.
 *
 * In this program:
 * Key   = Fruit name
 * Value = Frequency/count of that fruit
 *
 * getOrDefault(f, 0) returns:
 * - existing count if fruit is already present
 * - 0 if fruit is not present
 *
 * Then +1 increases the frequency.
 *
 * Example:
 * Apple -> 1
 * Apple -> 2
 * Apple -> 3
 *
 * entrySet() is used to iterate through both
 * key and value together.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class FruitFrequency {

    public static void main (String[] args)
    {
        List<String> fruits = new ArrayList<>();

        fruits.add("banana");
        fruits.add("apple");
        fruits.add("chickoo");
        fruits.add("banana");
        fruits.add("chickoo");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("mango");


        List<String> fruits1 = Arrays.asList("banana", "mango", "apple", "mango", "chickko", "pinaple", "mango", "banana", "mango");

        Map<String, Integer> freq = new LinkedHashMap<>();

        for (String f : fruits1)
        {
            freq.put(f, freq.getOrDefault(f,0)+1);
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet())
        {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
