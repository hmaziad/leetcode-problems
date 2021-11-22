package com.leet.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseVowelsofaString {

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));

    }

    public static String reverseVowels(String s) {
        char[] str = s.toCharArray();
        Set<Character> vowels = new HashSet<>(List.of('a','e','i','o','u','A','E','I','O','U'));
        int i=0;
        int j = s.length() -1;

        while(i<j){

            while(!vowels.contains(str[i]) && i<j){ i++;}
            while(!vowels.contains(str[j]) && j>i ){ j--;}

            if(i>=j){
                break;
            }

            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;

        }

        return new String(str);

    }
}
