package educative.trie.wordsintrie;

import educative.trie.Trie;
import educative.trie.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    //Recursive Function to generate all words
    public static void getWords(TrieNode root, ArrayList < String > result, int level, char[] str)
    {
        if (root.isEndWord) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append(str[i]);
            }

            result.add(sb.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] == null) {
                continue;
            }
            str[level] = (char) ('a' + i);
            getWords(root.children[i], result, level + 1, str);
        }
    }
    public static ArrayList < String > findWords(TrieNode root)
    {
        ArrayList < String > result = new ArrayList < String > ();

        if (root == null) {
            return result;
        }

        getWords(root, result, 0, new char[20]);
        return result;
    }

    public static void main(String args[]){
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie
        Trie t = new Trie();

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);

        System.out.println(findWords(t.getRoot()));
    }
}
