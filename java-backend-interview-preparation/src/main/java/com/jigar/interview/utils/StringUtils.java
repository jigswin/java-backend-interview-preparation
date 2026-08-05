package com.jigar.interview.utils;

public class StringUtils {
    /*
    Utility Method : normalize()

    Purpose:
    Prepare input before solving string problems.

    Operations:
    1. Convert to lowercase.
    2. Remove spaces.
    3. Remove special characters.
    4. Keep only lowercase English letters (a-z).

    Example:

    Input:
    "A Gentleman!!"

    Output:
    "agentleman"

    Use Cases:
    - Anagram
    - Palindrome
    - Valid Palindrome
    - Character Frequency Problems
*/
    public static String normalize(String input) {

        if (input == null) {
            return "";
        }

        return input
                .toLowerCase()
                .replaceAll("[^a-z]", "");
    }

    public static void main(String[] args) {

        String input = "A Gentleman!!";

        String output = normalize(input);

        System.out.println(output);
    }
}