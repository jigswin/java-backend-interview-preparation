package com.jigar.interview.strings;

/*
    ==========================================================
    STR-005 : First Repeating Character
    ==========================================================

    Problem:
    Find the first character in the string whose frequency is
    greater than 1.

    Approach 1: Brute Force
    - Check frequency of every character using nested loops.
    - Time Complexity : O(n²)
    - Space Complexity: O(1)

    Approach 2: Optimized
    - First pass: Store character frequencies using int[26].
    - Second pass: Traverse original string and return the
      first character whose frequency is greater than 1.
    - Time Complexity : O(n)
    - Space Complexity: O(1)

    Important:
    STR-004 -> frequency == 1  -> Non-Repeating
    STR-005 -> frequency > 1   -> Repeating

    Limitation:
    int[26] works only for lowercase English letters (a-z).

    Future:
    HashMap/HashSet solutions will be covered later.

    Pattern:
    Character Frequency Counting
    ==========================================================
*/

public class FirstRepeatingChar {

    public static void main(String[] args)
    {
        String str = "abcddec";
        char c = firstRepeatingCharbruteforce(str);
        System.out.println(c);

        char c1 = firstRepeatingCharOptimized(str);
        System.out.println(c1);
    }

    // Approach 1
    public static char firstRepeatingCharbruteforce(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            int count = 0;
            for(int j=0;j<str.length();j++)
            {
                if(str.charAt(i) == str.charAt(j))
                {
                    count++;
                }
            }

            if(count > 1)
            {
                return str.charAt(i);
            }
        }
        return '\0';
    }

    // Approach 2

    public static char firstRepeatingCharOptimized(String str)
    {
        int[] f = new int[26];

        for(int i=0;i<str.length();i++)
        {
            f[str.charAt(i)-'a']++;
        }

        for(int i=0;i<str.length();i++)
        {
            if(f[str.charAt(i)-'a'] > 1)
            {
                return  str.charAt(i);
            }
        }

        return '\0';
    }


}
