package educative.trie.dictword;

import educative.trie.Trie;

public class DictWord {
    public static Object isFormationPossible(String[] dict,String word) {
        Trie trie = new Trie();

        for (int i = 0; i < dict.length; i++) {
            trie.insert(dict[i]);
        }

        for (int i = 0; i < word.length(); i++) {
            String first = word.substring(0, i);
            String second = word.substring(i, word.length());

            if (trie.search(first) && trie.search(second)) {
                return true;
            }
        }
        return false;
    }
}
