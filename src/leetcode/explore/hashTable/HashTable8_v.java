package leetcode.explore.hashTable;

import java.util.HashMap;
import java.util.Map;

public class HashTable8_v {
    public static void main(String[] args) {
        HashTable8_v h = new HashTable8_v();
        String s1 = "egg";
        String t1 = "add";
        String s2 = "foo";
        String t2 = "bar";
        String s3 = "paper";
        String t3 = "title";

        System.out.println(h.isIsomorphic(s1, t1));
        System.out.println(h.isIsomorphic(s2, t2));
        System.out.println(h.isIsomorphic(s3, t3));

        String s4 = "badc";
        String t4 = "baba";
        System.out.println(h.isIsomorphic(s4, t4));
    }

    public boolean isIsomorphic(String s, String t) {
        StringBuilder s2 = new StringBuilder(s);
        StringBuilder t2 = new StringBuilder(t);

        Map<Character, Character> matchS = new HashMap<>();
        Map<Character, Character> matchT = new HashMap<>();

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (matchS.containsKey(sChars[i]) && matchT.containsKey(tChars[i])) {
                s2.setCharAt(i, matchS.get(sChars[i]));
                t2.setCharAt(i, matchT.get(tChars[i]));
                continue;
            }
            if (matchS.containsKey(sChars[i]) || matchT.containsKey(tChars[i])) {
                return false;
            }
            matchS.put(sChars[i], tChars[i]);
            matchT.put(tChars[i], sChars[i]);
            s2.setCharAt(i, tChars[i]);
            t2.setCharAt(i, sChars[i]);
        }
        return s2.toString().equals(t) && t2.toString().equals(s);
    }

    // char값과 index를 배열을 이용해 저장
    public boolean isIsomorphic2(String s, String t) {

        int map1[] = new int[128];
        int map2[] = new int[128];

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int i = 0;

        for (char ch1 : arr1) {
            char ch2 = arr2[i++];
            if (map1[ch1] != map2[ch2])
                return false;

            map1[ch1] = i + 1;
            map2[ch2] = i + 1;
        }
        return true;
    }
}
