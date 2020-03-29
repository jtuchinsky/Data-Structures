package com.intertuma.algorithms.backtracking;

import java.util.Optional;

public class TrieNode {
    private TrieNode[] children = new TrieNode[26];
    private boolean isWord;

    public TrieNode() {
        this.isWord = false;
    }

    public TrieNode(boolean isWord) {
        this.isWord = isWord;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public Optional<TrieNode> getChild(char c){
        int index = c - 'a';
        return Optional.ofNullable(children[index]);
    }

    public TrieNode addChild(char c, boolean isWord){
        return getChild(c)
                .map(t->{
                    if(!t.isWord())
                        t.setWord(isWord);
                    return t;
                })
                .orElseGet(()-> {
                    TrieNode node = new TrieNode(isWord);
                    children[c-'a'] = node;
                    return node;
                });
    }
}
