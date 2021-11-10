package com.leet.problems;

import java.util.Arrays;

public class ArithmeticFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length<=2){
            return true;
        }

        Arrays.sort(arr);

        for(int i=1;i<arr.length-1;i++){
            if((arr[i] - arr[i-1]) != arr[i+1] - arr[i])
                return false;
        }

        return true;
    }
}
