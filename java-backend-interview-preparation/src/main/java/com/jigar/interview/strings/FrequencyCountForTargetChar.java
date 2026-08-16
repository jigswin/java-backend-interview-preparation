package com.jigar.interview.strings;

public class FrequencyCountForTargetChar {

    public static void main(String[] args)
    {
        String str = "programming";
        char target = 'g';

        int freq = 0;
        for(int i =0;i<str.length();i++)
        {
            if(str.charAt(i) == target)
            {
                freq++;
            }
        }

        System.out.println(target + " => " + freq);

        //expected output
        // g => 2

    }
}
