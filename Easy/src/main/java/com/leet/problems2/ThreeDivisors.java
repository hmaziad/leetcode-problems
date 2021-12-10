package com.leet.problems2;

public class ThreeDivisors {

    public static void main(String[] args) {

        System.out.println(new ThreeDivisors().isThree(14));

    }


    public boolean isThree(int n) {
        if (n < 4) {
            return false;
        }
        int divisors = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                divisors++;
            }
        }

        return divisors == 1;

    }
}
