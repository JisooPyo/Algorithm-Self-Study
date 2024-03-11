package leetcode.al2403;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leet791 {
    public static void main(String[] args) {
        Leet791 l = new Leet791();
        System.out.println(l.customSortString("cba","abcd"));
        System.out.println(l.customSortString("bcafg","abcd"));
    }

    public String customSortString(String order, String s) {
        Character[] sChar = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sChar[i] = s.charAt(i);
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        Arrays.sort(sChar, (o1, o2) -> {
            int i = map.getOrDefault(o1, 0) - map.getOrDefault(o2, 0);
            return i;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sChar.length; i++) {
            sb.append(sChar[i]);
        }
        return sb.toString();
    }

    // 다른 사람의 풀이
    // 1. 26칸의 int 배열을 만들어 s char 값을 index로 하여 1의 값으로 저장
    // 2. order를 돌면서 위 배열에 저장된 값이 있으면 StringBuilder에 append, 값 -> 0
    // 3. 배열을 다시 돌면서 값이 1인 값만 StringBuilder 뒤에 붙이기
}
