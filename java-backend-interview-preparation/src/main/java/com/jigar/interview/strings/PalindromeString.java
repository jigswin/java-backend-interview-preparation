package com.jigar.interview.strings;

/*
    Palindrome String:

    A palindrome is a string that reads the same from both directions.

    Approach 1:
    - Reverse the string and compare with original string.
    - Time Complexity: O(n²) because String concatenation creates new objects.
    - Space Complexity: O(n)

    Optimized Approach:
    - Use Two Pointer technique (left & right).
    - Compare characters from both ends without creating extra string.
    - Time Complexity: O(n)
    - Space Complexity: O(1)

    Why Two Pointer?
    - More memory efficient.
    - No extra string/object creation.
    - Preferred approach for interviews.

    Edge Cases:
    - Empty string -> true
    - Single character -> true
    - Null string -> handle separately
    - Case sensitivity should be considered.
*/

public class PalindromeString {

    public static void main(String[] args)
    {

        // Approach 1
        String str1 = "madam";
        Boolean res1 = checkPalindromeString(str1);
        System.out.println(str1 + " is a palindrome : " + (res1 ? "Yes" : "No"));

        String str2 = "jigar";
        Boolean res2 = checkPalindromeString(str2);
        System.out.println(str2 + " Is a palindrome : " + (res2 ? "Yes" : "No"));


        // Approach 2
        String str3 = "naman";
        Boolean res3 = checkPalindromeUsing2Pointer(str3);
        System.out.println(str3 + " Is a palindrome : " + (res3 ? "Yes" : "No"));

        String str4 = "Ishwar";
        Boolean res4 = checkPalindromeUsing2Pointer(str4);
        System.out.println(str4 + " Is a palindrome : " + (res4 ? "Yes" : "No"));

    }

    // Approach 1 (Using String Reverse)
    public static Boolean checkPalindromeString(String str)
    {
        String reversed = "";
        for (int i = str.length()-1;i>=0;i--)
        {
            reversed = reversed + str.charAt(i);
        }

       return str.equals(reversed);
    }

    // Approach 2 (Use Two Pointer technique (left & right).)
    public static Boolean checkPalindromeUsing2Pointer(String str)
    {
        int left = 0;
        int right = str.length()-1;

        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
