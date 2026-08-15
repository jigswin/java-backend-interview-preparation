package com.jigar.interview.hashmap;
import java.util.*;

/*

Current number
      ↓
Target - Current
      ↓
Required number
      ↓
Kya HashMap me already hai?
      ↓
   YES       NO
    ↓         ↓
Answer     Current ko
mil gaya    Map me store karo


Target = 9

2 → mujhe 7 chahiye → nahi mila → 2 store
7 → mujhe 2 chahiye → MIL GAYA → answer


 */

public class TwoSum {
    public static void main(String[] args)
    {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i< numbers.length;i++)
        {
            int current = numbers[i];
            int required = target - current;

            if(map.containsKey(required))
            {
                System.out.println(
                        "Pair: " +
                                required + " + " +
                                current + " = " +
                                target
                );

                System.out.println(
                        "Indices: [" +
                                map.get(required) +
                                ", " +
                                i +
                                "]"
                );

                break;

            }

            map.put(current, i);
        }

//        for(Map.Entry<Integer, Integer> m : map.entrySet())
//        {
//            System.out.println(m.getKey() + " => " + m.getValue());
//        }

        // expected output
        // Pair: 2 + 7 = 9
        // Indices: [0, 1]
    }
}
