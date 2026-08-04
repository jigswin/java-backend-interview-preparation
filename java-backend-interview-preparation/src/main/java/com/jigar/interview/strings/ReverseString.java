package com.jigar.interview.strings;

/*
    Approach 1:
    Time Complexity: O(n²)
    Space Complexity: O(n)

    Reason:
    String immutable hai (edit nahi kar sakte h), har concatenation pe new object create hota hai.

    ==================================================

    Approach 2:
    Time Complexity: O(n)
    Space Complexity: O(n)

    Reason:
    StringBuilder mutable (edit kar sakte h) hota hai aur same buffer me append karta hai.

    ****************************************************************************************

    StringBuffer vs StringBuilder:

    StringBuffer:
    - Mutable class (value change kar sakte hain)
    - Thread-safe because methods are synchronized
    - Multiple threads same object modify kare tab use karte hain
    - Synchronization ki wajah se StringBuilder se thoda slow hota hai

    Why we did not use StringBuffer here?
    - String reversal ek single-threaded operation hai.
    - Hume thread safety ki requirement nahi hai.
    - StringBuilder same kaam faster perform karta hai because it has no synchronization overhead.

    Rule:
    Single thread -> StringBuilder preferred
    Multiple threads -> StringBuffer preferred

*/

public class ReverseString {
    public static void main(String[] args)
    {
        String str = "JIGAR";

        // Approach 1
        String reversed1 = reverseUsingString(str);
        System.out.println("Using String : " + reversed1);

        // Approach 2
        String reversed2 = reverseUsingStringBuilder(str);
        System.out.println("Using StringBuilder : " + reversed2);
    }


    // Approach 1  (using string)
    public static String reverseUsingString(String str)
    {
        String reversed = "";
        for (int i=str.length()-1;i >= 0; i--){
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }

    // Approach 2 (Using StringBuilder)
    public static String reverseUsingStringBuilder(String str)
    {
        StringBuilder reversed = new StringBuilder();
        for(int i = str.length()-1;i>=0;i-- )
        {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
