package com.jigar.interview.set;
import java.util.*;

public class FirstRepeatingChar {
    public static void main(String[] args)
    {
        String str = "abcaed";

        Set<Character> set = new HashSet<>();

        for(int i=0;i<str.length();i++)
        {
            if(!set.add(str.charAt(i)))
            {
                System.out.println(str.charAt(i));
                break;
            }
        }

        // expected output
        // a
    }
}
