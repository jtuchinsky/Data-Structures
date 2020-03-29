package com.intertuma.algorithms.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;

public class AllBraces {
    static ArrayList<ArrayList<Character>> printAllBraces(int n) {
        ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
        //TODO: Write - Your - Code
        findBraces(n, 0, 0, 0, result, new LinkedList<>() );
        return result;
    }

    static void findBraces(int n, int position, int openCount, int closeCount, ArrayList<ArrayList<Character>> result, LinkedList<Character> path) {
        //System.out.println(position);
        if (position == n * 2){
            result.add(new ArrayList<>(path));
            //path.clear();
        } else {
            if (closeCount < openCount) {
                path.addLast('}');
                findBraces(n, position + 1, openCount, closeCount + 1, result, path);
                path.removeLast();
                if (openCount < n) {
                    path.addLast('{');
                    findBraces(n, position + 1, openCount + 1, closeCount, result, path);
                    path.removeLast();
                }
            } else {
                if (openCount < n) {
                    path.addLast('{');
                    findBraces(n, position + 1, openCount + 1, closeCount, result, path);
                    path.removeLast();
                }
            }
        }
    }

    public static void main(String[] args){
        System.out.println(printAllBraces(1));
        System.out.println(printAllBraces(2));
        System.out.println(printAllBraces(3));
    }
}
