package com.jigar.interview.strings;
import com.jigar.interview.utils.StringUtils;

/*
    ==========================================================
    STR-004 : First Non-Repeating Character
    ==========================================================

    Problem:
    Find the first character in a string that appears only once.

    Example:
    Input  : aabbcdde
    Output : c


    Approach 1: Brute Force
    -----------------------
    Logic:
    - Take each character one by one.
    - Count its occurrence by traversing the complete string.
    - If count is 1, return that character.

    Time Complexity : O(n²)
    Space Complexity: O(1)

    Drawback:
    - Multiple traversals make it slow for large strings.


    Approach 2: Optimized (Frequency Array)
    ----------------------------------------
    Logic:
    - Store character frequency using int[26].
    - First pass: Count frequency of each character.
    - Second pass: Find first character with frequency 1.

    Time Complexity : O(n)
    Space Complexity: O(1)

    Why int[26]?
    - Faster lookup.
    - Fixed size memory.
    - Works for lowercase English characters (a-z).


    Limitations:
    - Does not support uppercase letters.
    - Does not support special characters.
    - Does not support Unicode characters.

    Future Improvement:
    - Use HashMap<Character,Integer> for dynamic character sets.


    Important Interview Point:
    Two-pass approach is used because:
    1. First pass gives frequency.
    2. Second pass maintains original order and finds first unique character.


    Pattern:
    Character Frequency Counting

    ==========================================================
*/

public class FirstNonRepeatingCharacter {
    public static void main(String[] args)
    {
        String str = "Aab bbJddee";

        // Approach 1
        char c = firstNonRepeatChar(str);
        if(c == '\0')
        {
            System.out.println("not unique char found");
        }
        else
        {
            System.out.println(c);
        }

        // Approach 2
        char c1 = firstNonRepeatCharOptimized(str);
        if(c1 == '\0')
        {
            System.out.println("not unique char found");
        }
        else
        {
            System.out.println(c1);
        }

    }

    // Approach 1 (Brute force)
    public static char firstNonRepeatChar(String str)
    {
        str = StringUtils.normalize(str);

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

            if(count == 1)
            {
                return str.charAt(i);
            }
        }

        return '\0';
    }

    // Approach 2 (optimized using 26 char)

    public static char firstNonRepeatCharOptimized(String str)
    {
        str = StringUtils.normalize(str);

        int[] frequency = new int[26];

        for (int i =0; i<str.length();i++)
        {
            frequency[str.charAt(i) - 'a']++;
        }

        for (int i=0;i<str.length();i++)
        {
            if(frequency[str.charAt(i)-'a'] == 1)
            {
                return str.charAt(i);
            }
        }

        return '\0';
    }
}
