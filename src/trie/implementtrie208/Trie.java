package trie.implementtrie208;

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
