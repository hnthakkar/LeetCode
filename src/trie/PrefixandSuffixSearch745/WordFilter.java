package trie.PrefixandSuffixSearch745;

import java.util.*;

public class WordFilter {

    private Trie forwardTrie;
    private Trie reverseTrie;

    private String[] words;

    public static void main(String[] args) {
        // WordFilter sol = new WordFilter(new String[] {"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"});

        WordFilter sol = new WordFilter(new String[] {"ababbbbbaa","abaabbbbaa"});
        // sol.f("ab", "a");
        // sol.f("a", "abcaccbcaa");
        sol.f("aba","bbbbaa");
    }

    public WordFilter(String[] pWords) {
        forwardTrie = new Trie();
        reverseTrie = new Trie();

        words = pWords;

        int len = pWords.length;

        Set<String> doneSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!doneSet.contains(pWords[i])) {
                insertWordIntoTrie(pWords[i], i);
                doneSet.add(pWords[i]);
            }
        }
    }

    private void insertWordIntoTrie(String word, int index) {
        forwardTrie.insert(word, index);
        reverseTrie.insert(reverseStr(word), index);
    }

    public int f(String prefix, String suffix) {
        Set<Integer> prefixList = forwardTrie.startsWith(prefix);
        Set<Integer> suffixList = reverseTrie.startsWith(reverseStr(suffix));

        return hasUniqueIntersection(prefixList, suffixList);
    }

    private int hasUniqueIntersection(Set<Integer> prefixList, Set<Integer> suffixList) {
        int common = -1;

        if (prefixList.size() == 0 || suffixList.size() == 0) {
            return common;
        }

        for (int index: prefixList) {
            if (suffixList.contains(index)) {
                if (common < index) {
                    common = index;
                }
            }
        }

        return common;
    }

    private String reverseStr(String word) {
        char[] wordArray = word.toCharArray();
        int left = 0;
        int right = wordArray.length - 1;

        while (left < right) {
            char tmp = wordArray[left];
            wordArray[left] = wordArray[right];
            wordArray[right] = tmp;

            left++;
            right--;
        }

        return new String(wordArray);
    }

}

class TrieNode {

    public char ch;
    public TrieNode[] next;
    public boolean isAlsoLastNode;

    public Set<Integer> wordIndex;

    public TrieNode(char pCh) {
        ch = pCh;
        next = new TrieNode[26];
        isAlsoLastNode = false;
    }
}

class Trie {

    TrieNode[] rootElem;

    public Trie() {
        rootElem = new TrieNode[26];
    }

    public void insert(String word, int index) {
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
                curNode.wordIndex = new HashSet<>();
            }

            curNode.wordIndex.add(index);

            if (curIndex == len - 1) {
                curNode.isAlsoLastNode = true;
            }

            curNodeArray = curNode.next;
            curIndex++;
        }
    }

    public Set<Integer> startsWith(String word) {
        char[] wordArray = word.toCharArray();
        int len = wordArray.length;
        int curIndex = 0;

        TrieNode[] curNodeArray = rootElem;
        TrieNode curNode = null;

        while (curIndex < len) {
            char curChar = wordArray[curIndex];
            curNode = curNodeArray[curChar - 'a'];

            if (curNode == null) {
                return Collections.emptySet();
            }

            curNodeArray = curNode.next;
            curIndex++;
        }

        return curNode == null? Collections.emptySet(): curNode.wordIndex;
    }

}