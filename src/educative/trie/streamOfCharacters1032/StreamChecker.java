package educative.trie.streamOfCharacters1032;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StreamChecker {

    Trie trie;
    Stack<String> stack1 = new Stack<>();
    Stack<String> stack2 = new Stack<>();
    Set<String> alreadyPresent = new HashSet<>();


    public static void main(String[] str) {
        StreamChecker sol = new StreamChecker(new String[]{"ab","ba","aaab","abab","baa"});
        sol.query('a'); // a - false
        sol.query('a'); // aa - false
        sol.query('a'); // aaa - false
        sol.query('a'); // aaaa - false
        sol.query('a'); // aaaaa - false
        sol.query('b'); // aaaab - true
        sol.query('a'); // ba - true
        sol.query('b'); // abab - true
        sol.query('a'); // ba - true
        sol.query('b'); // ab - true
        sol.query('b'); // false



        /*
        StreamChecker sol = new StreamChecker(new String[]{"cd","f","kl"});
        sol.query('a');
        sol.query('b');
        sol.query('c');
        sol.query('d');
        sol.query('e');
        sol.query('f');
        sol.query('g');
        sol.query('h');
        sol.query('i');
        sol.query('k');
        sol.query('l');

         */

    }

    public StreamChecker(String[] words) {
        int len = words.length;
        trie = new Trie();

        for (int i = 0; i < len; i++) {
            trie.insert(words[i]);
        }
    }

    public boolean query(char letter) {
        String curWord = letter + "";
        int[] result = trie.search(curWord);

        if (result[0] == 1) {
            return true;
        }

        if (result[1] == 1) {
            if (!alreadyPresent.contains(curWord)) {
                alreadyPresent.add(curWord);
                stack2.push(curWord);
            }
        }

        boolean matchFound = false;

        while (!stack1.isEmpty()) {
            String top = stack1.pop();
            alreadyPresent.remove(top);
            String newWord = top + curWord;

            result = trie.search(newWord);

            if (result[0] == 1) {
                if (!alreadyPresent.contains(newWord)) {
                    alreadyPresent.add(newWord);
                    stack2.push(newWord);
                }
                matchFound = true;
            }

            if (result[1] == 1) {
                if (!alreadyPresent.contains(newWord)) {
                    alreadyPresent.add(newWord);
                    stack2.push(newWord);
                }
            }
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        Stack<String> tmp;
        tmp = stack1;
        stack1 = stack2;
        stack2 = tmp;

        return matchFound;
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

            if (curIndex == len - 1) {
                curNode.isAlsoLastNode = true;
            }

            curNodeArray = curNode.next;
            curIndex++;
        }
    }

    public int[] search(String word) {
        char[] wordArray = word.toCharArray();
        int len = wordArray.length;
        int curIndex = 0;

        TrieNode[] curNodeArray = rootElem;
        TrieNode curNode;

        int exactMatch = 0;
        int possible = 1;

        while (curIndex < len) {
            char curChar = wordArray[curIndex];
            curNode = curNodeArray[curChar - 'a'];

            if (curNode == null) {
                possible = -1;
                break;
            }

            if (curIndex == len - 1 && curNode.isAlsoLastNode) {
                exactMatch = 1;
                break;
            }

            curNodeArray = curNode.next;
            curIndex++;
        }

        return new int[] {exactMatch, possible};
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