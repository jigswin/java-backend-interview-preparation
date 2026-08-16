package com.jigar.interview.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWords {
    public static void main(String[] args)
    {
        String str = "java is easy and java is powerful";

        String[] words = str.split(" ");

        Set<String> set = new LinkedHashSet<>();
        StringBuilder newSentence = new StringBuilder();

        for(int i =0;i<words.length;i++)
        {
            if(set.add(words[i]))
            {
                newSentence.append(words[i] + " ");

            }
        }

        System.out.println(newSentence.toString().trim());

        // expected output
        // java is easy and powerful

    }
}
