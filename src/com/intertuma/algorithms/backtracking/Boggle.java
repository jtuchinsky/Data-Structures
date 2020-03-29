package com.intertuma.algorithms.backtracking;

import java.util.*;

public class Boggle {
    int[] rd = {-1, -1, -1, 0, 1, 1, 1, 0};
    int[] cd = {-1, 0, 1, 1, 1, 0, -1, -1};
    int R, C;
    char[][] grid;
    HashSet<String> dictionary;
    // Limiting the search depth by length of longest word in a dictionary
    int maxLen = 0;
    // Using trie
    Trie trie = new Trie();

    public Boggle(char[][] grid, HashSet<String> dictionary){
        //TODO: Write - Your - Code
        R = grid.length;
        C = grid[0].length;
        this.grid = grid;
        this.dictionary = dictionary;
        // Limiting the search depth by length of longest word in a dictionary and Using trie
        for (String word : dictionary) {
            // Limiting the search depth by length of longest word in a dictionary
            this.maxLen = Integer.max(this.maxLen, word.length());
            // Using trie
            trie.addWord(word);
        }
    }

    public HashSet<String> findAllWords(){
        //TODO: Write - Your - Code
        HashSet<String> result = new HashSet<String>();
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                // Using trie
                if(trie.getRoot().getChild(grid[r][c]).isPresent()) {
                    // Using Trie
                    LinkedList<TrieNode> nodes = new LinkedList<>();
                    nodes.add(trie.getRoot().getChild(grid[r][c]).get());
                    // End Using Trie
                    boolean[][] visited = new boolean[R][C];
                    visited[r][c] = true;

                    //dfs(r, c, visited, result, new StringBuilder().append(grid[r][c]));
                    dfsUsinTrie(r, c, visited, result, new StringBuilder().append(grid[r][c]), nodes);
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, HashSet<String> result, StringBuilder word) {
        System.out.println(word);
        if(dictionary.contains(word.toString()))
            result.add(word.toString());
        // Limiting the search depth by length of longest word in a dictionary
        if(word.length() == maxLen)
            return;

        for(int i = 0; i < 8; i++){
            int rr = r + rd[i];
            int cc = c + cd[i];
            if(rr >= 0 && rr < R && cc >= 0 && cc < C && !visited[rr][cc]){
                visited[rr][cc] = true;
                word.append(grid[rr][cc]);
                dfs(rr, cc, visited, result, word);
                visited[rr][cc] = false;
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    private void dfsUsinTrie(int r, int c, boolean[][] visited, HashSet<String> result, StringBuilder word, LinkedList<TrieNode> nodes) {
        System.out.println(word);
        //if(dictionary.contains(word.toString()))
        //    result.add(word.toString());
        if(nodes.getLast().isWord())
            result.add(word.toString());
        // Limiting the search depth by length of longest word in a dictionary
        if(word.length() == maxLen)
            return;

        for(int i = 0; i < 8; i++){
            int rr = r + rd[i];
            int cc = c + cd[i];
            if(rr >= 0 && rr < R && cc >= 0 && cc < C && !visited[rr][cc] && nodes.getLast().getChild(grid[rr][cc]).isPresent()){
                visited[rr][cc] = true;
                word.append(grid[rr][cc]);
                nodes.addLast(nodes.getLast().getChild(grid[rr][cc]).get());
                dfs(rr, cc, visited, result, word);
                visited[rr][cc] = false;
                word.deleteCharAt(word.length() - 1);
                nodes.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'c', 'a', 't'},
                {'r', 'r', 'e'},
                {'t', 'o', 'n'}
        };

        //String[] dictionary = {"cat", "cater", "cartoon", "toon", "moon", "not", "tone", "apple", "ton", "art"};
        String[] dictionary = {"art", "tone", "cat", "cater", "not", "not", "ton"};

        Boggle boggle = new Boggle(grid, new HashSet<String>(Arrays.asList(dictionary)));
        System.out.println(boggle.findAllWords());
    }
}
