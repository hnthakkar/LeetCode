package trie.MaximumXORofTwoNumbersinanArray421;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
    }

    public int findMaximumXOR(int[] nums) {
        int len = nums.length;

        int result = 0;
        int mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);

            Set<Integer> prefix = new HashSet<>();
            for (int j = 0; j < len; j++) {
                prefix.add(mask & nums[j]);
            }

            int tmp = result | (1 << i);

            for (int p: prefix) {
                if (prefix.contains(tmp ^ p)) {
                    result = tmp;
                    break;
                }
            }
        }

        return result;
    }
}
/*
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

            if (curIndex == len - 1) {
                curNode.isAlsoLastNode = true;
            }

            curNodeArray = curNode.next;
            curIndex++;
        }
    }

    public boolean search(String word) {
        char[] wordArray = word.toCharArray();
        int len = wordArray.length;
        int curIndex = 0;

        TrieNode[] curNodeArray = rootElem;
        TrieNode curNode;

        while (curIndex < len) {
            char curChar = wordArray[curIndex];
            curNode = curNodeArray[curChar - 'a'];

            if (curNode == null) {
                return false;
            }

            if (curIndex == len - 1 && !curNode.isAlsoLastNode) {
                return false;
            }

            curNodeArray = curNode.next;
            curIndex++;
        }

        return true;
    }

    public boolean startsWith(String word) {
        char[] wordArray = word.toCharArray();
        int len = wordArray.length;
        int curIndex = 0;

        TrieNode[] curNodeArray = rootElem;
        TrieNode curNode;

        while (curIndex < len) {
            char curChar = wordArray[curIndex];
            curNode = curNodeArray[curChar - 'a'];

            if (curNode == null) {
                return false;
            }

            curNodeArray = curNode.next;
            curIndex++;
        }

        return true;
    }

}

class TrieNode {

    public char ch;
    public TrieNode[] next;
    public boolean isAlsoLastNode;

    public TrieNode(char pCh) {
        ch = pCh;
        next = new TrieNode[26];
        isAlsoLastNode = false;
    }
}

 */