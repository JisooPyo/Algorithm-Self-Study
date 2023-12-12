package leetcode.al12;

import java.util.HashMap;
import java.util.Map;

public class HashTable10 {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqChar(s2));
        System.out.println(firstUniqChar(s3));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> counting = new HashMap<>();
        for (char ch : s.toCharArray()) {
            counting.put(ch, counting.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s.toCharArray()) {
            if (counting.get(ch) == 1) {
                return s.indexOf(Character.toString(ch));
            }
        }
        return -1;
    }

    // 다른 사람의 풀이 s를 iterate하는 것이 아니라
    // s는 영소문자밖에 없다는 사실을 이용하여 영소문자만 돌면서 확인하기
    public int firstUniqChar2(String s) {
        int ans = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                ans = Math.min(ans, index);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
