package com.wellsfargo.interview;

import org.junit.Test;

import java.util.Arrays;

public class CountElements {
    public int countElements(int[] arr){
        int result = 0, repeated = 1;

        Arrays.sort(arr);
        for(int i = 1;  i < arr.length; i++){
            if(arr[i] == arr[i-1])
                repeated++;
            else if (arr[i] - arr[i-1] == 1){
                result += repeated;
                repeated = 1;
            } else {
                repeated = 1;
            }
        }
        return result;
    }

    @Test
    public void countElements(){
        System.out.println(countElements(new int[] {1,1,2,2}));
        System.out.println(countElements(new int[] {1,1,3,3,5,5}));
        System.out.println(countElements(new int[] {1,2,3}));
        System.out.println(countElements(new int[] {1,3,2,3,5,0}));
    }
}
