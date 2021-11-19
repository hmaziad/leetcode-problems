package com.leet.problems;
//https://leetcode.com/problems/distance-between-bus-stops/
public class DistanceBetweenBusStops {

    public static void main(String[] args) {

        System.out.println(distanceBetweenBusStops(new int[]{1,2}, 1, 0));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {

        return Math.min(forward(distance, start, destination), backward(distance, start, destination));
    }

    private static int forward(int[] distance, int start, int destination) {
        int sum = 0;

        while (start != destination) {
            sum += distance[start];
            start = (start + 1) % distance.length;
        }

        return sum;
    }

    private static int backward(int[] distance, int start, int destination) {
        int sum = 0;

        while (start != destination) {
            start = (start - 1  + distance.length) % distance.length;
            sum += distance[start];
        }

        return sum;
    }
}
