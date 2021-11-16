package com.leet.problems;

public class ComplementofBase10Integer {
    public static void main(String[] args) {
        System.out.println(flip(999999999));

    }

    private static int flip(int num) {
        char[] chars = Integer.toBinaryString(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = chars[i] == '1' ? '0' : '1';
        }
        return Integer.parseInt(new String(chars), 2);
    }
}
