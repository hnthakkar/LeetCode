package educative.trie.numberofwords;

import educative.trie.Trie;
import educative.trie.TrieNode;

import java.util.Arrays;

public class Main {

    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie
        Trie t = new Trie();

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

        System.out.println(totalWords(t.getRoot()));
    }

        public static int totalWords(TrieNode root){
            if (root == null) {
                return 0;
            }

            int leafNodeAtThisLevel = 0;
            TrieNode currentNode;
            for (int i = 0; i < 26; i++) {
                currentNode = root.children[i];
                if (currentNode == null) {
                    continue;
                }

                if (currentNode.isEndWord) {
                    leafNodeAtThisLevel++;
                }

                leafNodeAtThisLevel += totalWords(currentNode);
            }

            return leafNodeAtThisLevel;
        }
}
