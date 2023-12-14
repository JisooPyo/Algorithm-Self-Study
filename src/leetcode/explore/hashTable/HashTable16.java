package leetcode.explore.hashTable;

import java.util.HashSet;
import java.util.Set;

public class HashTable16 {
    public static void main(String[] args) {
        HashTable16 h = new HashTable16();
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        String jewels2 = "z";
        String stones2 = "ZZ";
        System.out.println(h.numJewelsInStones(jewels1, stones1));
        System.out.println(h.numJewelsInStones(jewels2, stones2));
    }

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsStore = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            jewelsStore.add(ch);
        }

        int answer = 0;
        for (char ch : stones.toCharArray()) {
            if (jewelsStore.contains(ch)) {
                answer++;
            }
        }

        return answer;
    }
}
