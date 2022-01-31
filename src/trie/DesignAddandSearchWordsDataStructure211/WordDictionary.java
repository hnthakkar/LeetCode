package trie.DesignAddandSearchWordsDataStructure211;

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        wd.addWord("pad");
        wd.addWord("bad");

        wd.search(".ad");
        wd.search("b..");
    }

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
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

    public boolean search(String word) {
        char[] wordArray = word.toCharArray();
        int len = wordArray.length;
        int curIndex = 0;

        TrieNode[] curNodeArray = rootElem;

        return searchWord(curNodeArray, null, wordArray, len, 0);
        /*
        while (curIndex < len) {
            char curChar = wordArray[curIndex];
            if (curChar == '.') {
                for (int i = 0; i <= 25; i++) {
                    curNode = curNodeArray[i];
                }
            } else {
                curNode = curNodeArray[curChar - 'a'];
            }

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

         */
    }

    private boolean searchWord(TrieNode[] curNodeArray, TrieNode curNode, char[] wordArray, int len, int curIndex) {
        char curChar = wordArray[curIndex];
        if (curChar == '.') {
            for (int i = 0; i <= 25; i++) {
                curNode = curNodeArray[i];

                if (curNode == null) {
                    continue;
                }

                if (curIndex == len - 1) {
                    if (curNode.isAlsoLastNode) {
                        return true;
                    }

                    continue;
                }

                if (searchWord(curNode.next, curNode, wordArray, len, curIndex + 1)) {
                    return true;
                }
            }
        } else {
            curNode = curNodeArray[curChar - 'a'];

            if (curNode == null) {
                return false;
            }

            if (curIndex == len - 1) {
                if (curNode.isAlsoLastNode) {
                    return true;
                } else {
                    return false;
                }
            }

            return searchWord(curNode.next, curNode, wordArray, len, curIndex + 1);
        }

        return false;
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