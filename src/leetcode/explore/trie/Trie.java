package leetcode.explore.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    Map<Character, Trie> children;

    boolean word;

    public Trie() {
        children = new HashMap<>();
    }

    public void insert(String word) {
        char ch = word.charAt(0);
        if (!children.containsKey(ch)) {
            Trie trie = new Trie();
            children.put(ch, trie);

        }
        if (word.length() > 1) {
            children.get(ch).insert(word.substring(1));
        } else {
            children.get(ch).word = true;
        }
    }

    public boolean search(String word) {
        char ch = word.charAt(0);
        if (!children.containsKey(ch)) {
            return false;
        }
        if (word.length() > 1) {
            return children.get(ch).search(word.substring(1));
        } else {
            return children.get(ch).word;
        }
    }

    public boolean startsWith(String prefix) {
        char ch = prefix.charAt(0);
        if (!children.containsKey(ch)) {
            return false;
        }
        if (prefix.length() > 1) {
            return children.get(ch).startsWith(prefix.substring(1));
        } else {
            return true;
        }
    }

}
