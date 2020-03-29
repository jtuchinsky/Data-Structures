package com.intertuma.algorithms.backtracking;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length()-1; i++) {
            current = current.addChild(word.charAt(i), false);
        }
        current.addChild(word.charAt(word.length()-1), true);
    }

    public TrieNode getRoot() {
        return root;
    }
}
