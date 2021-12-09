package com.leet.problems2;

import java.util.Arrays;

public class ReverseBits {
    public static void main(String[] args) {

        System.out.println(bin(-3));
    }

    private static int bin(int n) {
        if (n == 0) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}
