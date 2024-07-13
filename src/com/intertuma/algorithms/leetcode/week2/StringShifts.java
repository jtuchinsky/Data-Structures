package com.intertuma.algorithms.leetcode.week2;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 */
public class StringShifts {
    public String stringShift(String s, int[][] shift) {
        char[] arr = s.toCharArray();

        for(int i = 0; i < shift.length; i++){
            shift(arr, shift[i][1], shift[i][0]);
        }

        return new String(arr);
    }

    // direction = 1 -> right, 0 -> left
    void shift(char[] arr, int shift, int direction){
        int len = shift%arr.length;

        if(direction == 1){
            rotate(arr, 0, arr.length - len - 1);
            rotate(arr, arr.length - len, arr.length - 1);
        } else {
            rotate(arr,0, len-1);
            rotate(arr, len, arr.length - 1);
        }
        rotate(arr, 0, arr.length - 1);
    }

    void rotate(char[] arr, int left, int right){
        while(left < right){
            swap(arr, left, right);
            left++; right--;
        }
    }

    private void swap(char[] arr, int left, int right) {
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
