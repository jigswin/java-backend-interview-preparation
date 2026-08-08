package com.jigar.interview.strings;
import com.jigar.interview.utils.StringUtils;

/*
    ==========================================================
    STR-006 : Character Frequency Count
    ==========================================================

    Problem:
    Find and print the frequency of each character in a string.

    ----------------------------------------------------------
    APPROACH 1: BRUTE FORCE
    ----------------------------------------------------------

    Logic:
    - Take each character one by one.
    - Compare it with the remaining characters.
    - Count how many times the character occurs.
    - Use boolean[] visited to avoid processing the same
      character again.

    Why visited[]?
    - It marks character indexes that are already processed.
    - If visited[i] is true, skip that character using continue.

    Example:
    String = "aabbc"

    Output:
    a -> 2
    b -> 2
    c -> 1

    Time Complexity : O(n²)
    Space Complexity: O(n)

    Drawback:
    - Nested loops make it slower for large strings.


    ----------------------------------------------------------
    APPROACH 2: OPTIMIZED - FREQUENCY ARRAY
    ----------------------------------------------------------

    Logic:
    - Use int[26] to store frequency of lowercase characters.
    - Convert character into array index using:

          character - 'a'

    Example:
          'a' - 'a' = 0
          'b' - 'a' = 1
          'c' - 'a' = 2
          ...
          'z' - 'a' = 25

    - Increment the frequency:

          frequency[str.charAt(i) - 'a']++;

    - Finally, traverse the frequency array and print
      characters whose frequency is greater than 0.

    Why int[26]?
    - There are only 26 lowercase English characters.
    - Array provides O(1) access.

    Time Complexity : O(n)
    Space Complexity: O(1)

    Limitation:
    - Works only for lowercase English characters (a-z).
    - For uppercase, spaces, special characters or mixed
      characters, HashMap<Character, Integer> is more flexible.


    ----------------------------------------------------------
    KEY INTERVIEW PATTERN
    ----------------------------------------------------------

    Brute Force:
    Character -> Compare -> Count

    Optimized:
    Character -> Array Index -> Frequency Count

    Important Conversion:

    Character -> Index:
        'p' - 'a' = 15

    Index -> Character:
        (char)('a' + 15) = 'p'

    ==========================================================
*/

public class PrintFrequency {
    public static void main(String[] args)
    {
        // Approach 1
        String str = "jjabbbcaacccds";
        printFrequenctBruteForec(str);

        System.out.println("========================");

        // Approach 2
        String str1 = "programming";
        printFrequenctOptimized(str1);
    }

    // Approach 1
    public static void printFrequenctBruteForec(String str)
    {
        str = StringUtils.normalize(str);

        boolean[] visited = new boolean[str.length()];

        for(int i=0;i < str.length();i++)
        {
            if(visited[i])
            {
                continue;
            }

            int count = 1;

            for(int j= i+1;j<str.length();j++)
            {
                if(str.charAt(i) == str.charAt(j))
                {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(str.charAt(i) + " => " + count);
        }

    }

    // Approach 2

    public static void printFrequenctOptimized(String str){

        str = StringUtils.normalize(str);

        int[] f = new int[26];

        for(int i=0;i<str.length();i++)
        {
            f[str.charAt(i)-'a']++;
        }

        for(int i =0;i<26;i++)
        {
            if(f[i] > 0)
            {
                char ch = (char)('a' + i);
                System.out.println(ch + " => " + f[i]);
            }
        }

    }
}
