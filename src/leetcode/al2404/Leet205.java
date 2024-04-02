package leetcode.al2404;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leet205 {
    public static void main(String[] args) {
        Leet205 l = new Leet205();
        System.out.println(l.isIsomorphic("egg", "add"));   // true
        System.out.println(l.isIsomorphic("foo", "bar"));   // false
        System.out.println(l.isIsomorphic("paper", "title"));   // true
        System.out.println(l.isIsomorphic("badc", "baba")); // false
    }

    // 내 풀이
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!map.containsKey(sChar)) {
                if (map.containsValue(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
                sb.append(tChar);
            } else {
                sb.append(map.get(sChar));
            }
        }

        return sb.toString().equals(t);
    }

    // 좀 더 빨랐던 다른 사람의 풀이
    // NUL을 제외하고 아스키 코드가 127개 있다는 사실을 이용하여
    // 127 크기의 int 배열을 S와 T 각각 만들었다.
    // 이후 S와 T에서 나오는 문자개수를 세어 다르면 false를 return하는 식으로 구현하였다.
    public boolean isIsomorphicOther(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] tempS = new int[127];
        int[] tempT = new int[127];
        for (int i = 0; i < s.length(); i++) {
            if (tempS[s.charAt(i)] != tempT[t.charAt(i)])
                return false;

            tempS[s.charAt(i)] = i + 1;
            tempT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
