package trie.searchSuggestionSystem1268;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();

        for (String product: products) {
            trie.insert(product);
        }

        List<List<String>> result = new ArrayList<>();

        int len = searchWord.length();

        for (int i = 0; i < len; i++) {
            List curResults = trie.startsWith(searchWord.substring(0, i + 1));
            Collections.sort(curResults);

            while (curResults.size() > 3) {
                curResults.remove(curResults.size() - 1);
            }

            result.add(curResults);
        }

        return result;
    }

}

class TrieNode {

    public char ch;
    public TrieNode[] next;
    public boolean isAlsoLastNode;

    public List<String> words;

    public TrieNode(char pCh) {
        ch = pCh;
        next = new TrieNode[26];
        isAlsoLastNode = false;
        words = new ArrayList<>();
    }
}

class Trie {

    TrieNode[] rootElem;

    public Trie() {
        rootElem = new TrieNode[26];
    }

    public void insert(String word) {
        char[] wordArray = word.toCharArray();
        int len = wordArray.length;
        int curIndex = 0;

        TrieNode[] curNodeArray = rootElem;
        TrieNode curNode;

        while (curIndex < len) {
            char curChar = wordArray[curIndex];
            curNode = curNodeArray[curChar - 'a'];
            if (curNode == null) {
                curNode = new TrieNode(curChar);
                curNodeArray[curChar - 'a'] = curNode;
            }

            curNode.words.add(word);

            if (curIndex == len - 1) {
                curNode.isAlsoLastNode = true;
            }

            curNodeArray = curNode.next;
            curIndex++;
        }
    }

    public List<String> startsWith(String word) {
        char[] wordArray = word.toCharArray();
        int len = wordArray.length;
        int curIndex = 0;

        TrieNode[] curNodeArray = rootElem;
        TrieNode curNode = null;

        while (curIndex < len) {
            char curChar = wordArray[curIndex];
            curNode = curNodeArray[curChar - 'a'];

            if (curNode == null) {
                return Collections.emptyList();
            }

            curNodeArray = curNode.next;
            curIndex++;
        }

        return curNode == null? Collections.emptyList(): curNode.words;
    }

}
