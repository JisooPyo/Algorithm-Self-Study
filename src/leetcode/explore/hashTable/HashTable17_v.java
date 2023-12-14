package leetcode.explore.hashTable;

import java.util.HashSet;
import java.util.Set;

public class HashTable17_v {
    public static void main(String[] args) {
        HashTable17_v h = new HashTable17_v();

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

//        System.out.println(h.lengthOfLongestSubstring(s1));
//        System.out.println(h.lengthOfLongestSubstring(s2));
        System.out.println(h.lengthOfLongestSubstring2(s3));
    }

    // 내 풀이 - 98ms
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Set<Character> substringChar = new HashSet<>();
        int index = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (substringChar.contains(chars[i])) {
                answer = Math.max(i - index, answer);
                index = s.substring(0, i).lastIndexOf(Character.toString(chars[i])) + 1;
                substringChar = new HashSet<>();
                for (int j = index; j <= i; j++) {
                    substringChar.add(chars[j]);
                }
                continue;
            }
            substringChar.add(chars[i]);
        }
        answer = Math.max(s.length() - index, answer);
        return answer;
    }

    // 다른 사람 풀이 - 1ms
    // Set으로 중복 확인할 필요 없이 겹치는 문자의 예전 index만 알면 풀리는 문제였다.

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];  // Assuming ASCII characters

        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            // 겹치는 문자의 가장 나중 index + 1
            i = Math.max(charIndex[c], i);
            // 겹치지 않는 문자열의 길이
            maxLength = Math.max(maxLength, j - i + 1);
            charIndex[c] = j + 1;
        }
        return maxLength;
    }
}
