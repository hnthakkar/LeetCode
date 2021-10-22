package sorting.sortcharacterbyfreq451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.frequencySort("abaccadeeefaafcc");
    }

    public String frequencySort(String s) {
        char[] sArray = s.toCharArray();

        Map<Character, Integer> charFreq = new HashMap<>();

        for (char ch: sArray) {
            if (charFreq.containsKey(ch)) {
                charFreq.put(ch, charFreq.get(ch) + 1);
            } else {
                charFreq.put(ch, 1);
            }
        }

        NodeList list = new NodeList();
        for (Map.Entry<Character, Integer> entry: charFreq.entrySet()) {
            list.insert(entry.getKey(), entry.getValue());
        }

        return list.getOutputString();
    }

}

class NodeList {
    Node root = null;
    Node tail = null;

    public void insert(char ch, int freq) {
        // list is null
        if (root == null) {
            Node newNode = new Node(freq);
            newNode.items.add(ch);
            root = newNode;
            tail = newNode;
            return;
        }

        // append before cur head
        if (root.freq < freq) {
            Node newNode = new Node(freq);
            newNode.items.add(ch);
            newNode.next = root;
            root.prev = newNode;
            root = newNode;
            return;
        }

        // append to the tail
        if (tail.freq > freq) {
            Node newNode = new Node(freq);
            newNode.items.add(ch);
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
            return;
        }

        Node curNode = root;

        while(curNode.freq > freq) {
            curNode = curNode.next;
        }

        // node already exists, just add to the list
        if (curNode.freq == freq) {
            curNode.items.add(ch);
            return;
        }

        // node in middle
        Node newNode = new Node(freq);
        newNode.items.add(ch);

        newNode.next = curNode;
        newNode.prev = curNode.prev;

        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
    }

    public String getOutputString() {
        Node cur = root;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.getNodeString());
            cur = cur.next;
        }

        return sb.toString();
    }
}

class Node {
    int freq;
    List<Character> items;
    Node prev = null;
    Node next = null;

    public Node(int pFreq) {
        freq = pFreq;
        items = new ArrayList<>();
    }

    public String getNodeString() {
        StringBuilder sb = new StringBuilder();

        for (char ch: items) {
            for (int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}


/*
public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < pos; i++)
                        sb.append(c);

        return sb.toString();
    }
 */