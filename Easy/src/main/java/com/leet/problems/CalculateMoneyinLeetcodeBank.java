package com.leet.problems;

public class CalculateMoneyinLeetcodeBank {

    public static void main(String[] args) {
        System.out.println(totalMoney(10));

    }

    public static int totalMoney(int n) {
        int monday = -1;
        int balance = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 1) {
                monday++;
            }
            balance += (monday + (i % 7 == 0 ? 7 : i % 7));
        }

        return balance;
    }
}
