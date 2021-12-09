package com.leet.problems2;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        var longestPrefix = new LongestCommonPrefix();
        System.out.println(longestPrefix.longestCommonPrefix(new String[]{"","","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        return Arrays.stream(strs).reduce(strs[0], (acc, cur) -> getLongestPrefix(cur, acc));
    }

    private String getLongestPrefix(String str, String prefix) {
        int i = 0;
        while (i < Math.min(str.length(), prefix.length())) {
            if (str.charAt(i) != prefix.charAt(i)) {
                return prefix.substring(0, i);
            }
            i++;
        }
        return str.length() < prefix.length() ? str : prefix;
    }
}
