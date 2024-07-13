package com.intertuma.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, nums.length, result);
        return result;
    }

    void permute(int[] arr, int pos, List<List<Integer>> result){
        if(pos==1){
            result.add(IntStream.of(arr).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i=0; i<pos; i++){
            swap(arr, i, pos-1);
            permute(arr, pos-1, result);
            swap(arr, i, pos-1);
        }

    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
