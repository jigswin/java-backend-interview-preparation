package com.jigar.interview.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateChar {

    public static void main(String[] args)
    {
        String str = "programming";

        Set<Character> set = new LinkedHashSet<>();

        for(int i=0;i<str.length();i++)
        {
            set.add(str.charAt(i));
        }

        StringBuilder newStr = new StringBuilder();

        for(char c : set)
        {
            newStr.append(c);
        }

        System.out.println(newStr);
    }


    // expected output
    // progamin
}
