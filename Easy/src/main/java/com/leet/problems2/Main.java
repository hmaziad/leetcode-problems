package com.leet.problems2;

public class Main {
    public static void main(String[] args) {

        String str = "abcde";

        for (int i = 0; i < str.length(); ++i) {
            String pref = "";
            for (int j = i; j < str.length(); j++) {
                pref += String.valueOf(str.charAt(j));
                System.out.println(pref);
            }
        }
    }
}
