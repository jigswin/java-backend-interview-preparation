package com.jigar.interview.strings;
import com.jigar.interview.utils.StringUtils;

import java.util.Arrays;

/*
    ===========================================================
    Question 03 : Valid Anagram
    ===========================================================

    Definition:
    Two strings are anagrams if they contain the same characters
    with the same frequency.

    Current Assumption:
    - Input contains only lowercase English letters (a-z).

    Approach 1:
    - Sort both strings and compare.
    - Time Complexity : O(n log n)
    - Space Complexity: O(n)

    Optimized Approach:
    - Use int[26] to store character frequency.
    - Increment count for first string.
    - Decrement count for second string.
    - If all values become 0, strings are anagrams.
    - Time Complexity : O(n)
    - Space Complexity: O(1)

    Why int[26]?
    - Faster than HashMap.
    - Constant space.
    - Best when input contains only lowercase English letters.

    Limitations:
    - Does not support uppercase letters.
    - Does not support spaces.
    - Does not support digits.
    - Does not support special characters.
    - Does not support Unicode.

    Future Improvement:
    - Convert input to lowercase.
    - Remove spaces and special characters.
    - Use HashMap<Character,Integer> when character set is not fixed.

    Interview Tip:
    Always clarify input constraints before choosing the approach.
    ===========================================================
*/

public class Anagram {
    public static void main(String[] args)
    {
        // Approach 1
        String str1 = "listen";
        String str2 = "Silent";

        Boolean res1 = checkAnagram(str1, str2);
        System.out.println(res1);

        // Approach 2
        Boolean res2 = isAnagramOptimized(str1, str2);
        System.out.println(res2);
    }


    public static Boolean checkAnagram(String str1, String str2)
    {
        if(str1.length() != str2.length())
        {
            return false;
        }

        str1 = StringUtils.normalize(str1);
        str2 = StringUtils.normalize(str2);

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static Boolean isAnagramOptimized(String str1, String str2)
    {
        if(str1.length() != str2.length())
        {
            return false;
        }

        str1 = StringUtils.normalize(str1);
        str2 = StringUtils.normalize(str2);

        int[] count = new int[26];

        for(int i =0;i < str1.length();i++)
        {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        for(int value : count)
        {
            if(value != 0)
            {
                return false;
            }
        }

        return true;
    }
}

