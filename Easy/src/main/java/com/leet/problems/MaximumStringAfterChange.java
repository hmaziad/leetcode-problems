package com.leet.problems;
// https://leetcode.com/problems/maximum-binary-string-after-change/
public class MaximumStringAfterChange {
    public static void main(String[] args) {

        System.out.println(maximumBinaryString("11101100"));

    }

    public static String maximumBinaryString(String binary) {
        int i_zero = -1;
        char[] bin = binary.toCharArray();
        final char ZERO = '0';
        final char ONE = '1';
        for (int i = 0; i < binary.length(); i++) {
            if (bin[i] == ZERO && i_zero == -1) { // first zero
                i_zero = i;
                continue;
            }
            if (bin[i] == ZERO && i - 1 == i_zero) { // adjacent
                bin[i_zero] = ONE;
                i_zero = i;
                continue;
            }
            if (bin[i] == ZERO) { // not adjacent
                bin[i_zero] = ONE;
                bin[++i_zero] = ZERO;
                bin[i] = ONE;
            }
        }
        return new String(bin);
    }
}
