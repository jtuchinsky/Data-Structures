package com.intertuma.algorithms.subsets;

import org.junit.Test;

import java.util.*;

public class Subsets {
    public void printAllSubsetsIterative(int[] arr){
        List<List<Integer>> accumulator = new LinkedList<>();
        accumulator.add(Collections.EMPTY_LIST);
        for(int i = 0; i< arr.length; i++){
            int len = accumulator.size();
            for(int j = 0; j < len; j++){
                List<Integer> current = new LinkedList<>(accumulator.get(j));
                current.add(arr[i]);
                accumulator.add(current);
            }
        }

        System.out.println(accumulator);
    }

    @Test
    public void printAllSubsetsIterative(){
        int[] arr = {1,2,3,4};
        printAllSubsetsIterative(arr);
    }

    public void printAllSubsetsRecursievly(int[] arr) {
        List<List<Integer>> accumulator = new LinkedList<>();
        accumulator.add(Collections.EMPTY_LIST);

        printAllSubsetsHelper(arr, 0, accumulator);

        System.out.println(accumulator);
    }

    private void printAllSubsetsHelper(int[] arr, int position, List<List<Integer>> accumulator){
        if(position >= arr.length)
            return;

        int len = accumulator.size();
        for(int j = 0; j < len; j++){
            List<Integer> current = new LinkedList<>(accumulator.get(j));
            current.add(arr[position]);
            accumulator.add(current);
        }
        printAllSubsetsHelper(arr, position+1, accumulator);
    }

    @Test
    public void printAllSubsetsRecursievly(){
        int[] arr = {1,2,3,4};
        printAllSubsetsRecursievly(arr);
    }

    public void printPermutations1(String s){
        printPermutations1("", s);
    }

    private void printPermutations1(String prefix, String s){
        int n = s.length();
        if(n == 0)
            System.out.println(prefix);
        else {
            for(int i=0; i< n; i++)
                printPermutations1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1));
        }
    }

    @Test
    public void printPermutations1(){
        printPermutations1("1234");
    }

    public void printPermutations2(String s){
        printPermutations2(s.toCharArray(), s.length());
    }

    private void printPermutations2(char[] arr, int position){
        if(position == 1){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i = 0; i < position; i++){
            swap(arr, i, position-1);
            printPermutations2(arr, position - 1);
            swap(arr, i, position-1);
        }
    }

    private void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    @Test
    public void printPermutations2(){
        printPermutations2("1234");
    }

    public void permutatins(String str){
        List<String> permutations = permutationsHelper(str);
        System.out.println(permutations);
    }

    private List<String> permutationsHelper(String str){
        List<String> ret = new ArrayList<>();
        if(str.length() == 0)
            return ret;
        if(str.length() == 1){
            ret.add(str);
            return ret;
        }

        for(int i = 0; i < str.length(); i++){
            String swapped = swapWithFirst(str, i);
            List<String> results = permutationsHelper(swapped.substring(1));
            for(String result : results){
                ret.add(swapped.charAt(0) + result);
            }
        }
        return ret;
    }

    private String swapWithFirst(String str, int i) {
        char[] arr = str.toCharArray();
        char first = arr[0];
        arr[0] = arr[i];
        arr[i] = first;

        return new String(arr);
    }

    @Test
    public void permutations(){
        permutatins("abc");
    }

    public void permutationsOfSizeK(String str, int k){
        List<String> result;
        if(k > str.length() || k == 0)
            result  = new ArrayList<>();
        else
            result = permutationsOfSizeKHelper(str, k);

        System.out.println(result);
    }

    private List<String> permutationsOfSizeKHelper(String str, int k) {
        List<String> ret = new ArrayList<>();
        if (k == str.length()){
            ret.add(str);
        } else if (k == 1) {
            for(char c : str.toCharArray()){
                ret.add(new String(String.valueOf(c)));
            }
        } else {
            for(int i = 0; i < str.length(); i++){
                String swapped = swapWithFirst(str, i);
                List<String> results = permutationsOfSizeKHelper(swapped.substring(1), k-1);
                for(String result : results){
                    ret.add(swapped.charAt(0) + result);
                }
            }
        }
        return ret;
    }

    @Test
    public void permutationsOfSizeK(){
        permutationsOfSizeK("abcd", 0);
        permutationsOfSizeK("abcd", 1);
        permutationsOfSizeK("abcd", 2);
        permutationsOfSizeK("abcd", 3);
        permutationsOfSizeK("abcd", 4);
    }

    public void combinationsOfSizeK(String str, int k){
        List<String> result;
        if(k > str.length() || k == 0)
            result  = new ArrayList<>();
        else
            result = combinationsOfSizeKHelper(str, k);

        System.out.println(result);
    }

    private List<String> combinationsOfSizeKHelper(String str, int k) {
        System.out.println(str + " " + k);
        List<String> ret = new ArrayList<>();
        if (k == str.length()){
            ret.add(str);
//        } else if (k == 1) {
//            for(char c : str.toCharArray()){
//                ret.add(new String(String.valueOf(c)));
//            }
        } else {
            for(int i = 0; i < str.length() - 1; i++){
                String substr = str.substring(i + 1);
                List<String> results = combinationsOfSizeKHelper(substr, k-1);
                for(String result : results){
                    ret.add(str.charAt(i) + result);
                }
            }
        }
        return ret;
    }

    @Test
    public void combinationsOfSizeK(){
//        combinationsOfSizeK("abcde", 0);
//        combinationsOfSizeK("abcde", 1);
        combinationsOfSizeK("abcde", 2);
//        combinationsOfSizeK("abcde", 3);
//        combinationsOfSizeK("abcde", 4);
//        combinationsOfSizeK("abcde", 5);
    }

}
