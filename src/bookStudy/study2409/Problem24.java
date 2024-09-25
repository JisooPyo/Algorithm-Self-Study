package bookStudy.study2409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 lv.2
 * 24. 메뉴 리뉴얼
 */
public class Problem24 {
    public static void main(String[] args) {
        Problem24 p = new Problem24();

        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2, 3, 4};
        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};
        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2, 3, 4};

        // {"AC", "ACDE", "BCFG", "CDE"}
        System.out.println(Arrays.toString(p.solution(orders1, course1)));
        // {"ACD", "AD", "ADE", "CD", "XYZ"}
        System.out.println(Arrays.toString(p.solution(orders2, course2)));
        // {"WX", "XY"}
        System.out.println(Arrays.toString(p.solution(orders3, course3)));
    }

    // 내 풀이
    Map<Integer, Map<String, Integer>> menuCount;

    public String[] solution(String[] orders, int[] course) {
        // orders 메뉴 순서대로 맞춰놓기
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        // 조합 저장
        this.menuCount = new HashMap<>();
        for (int num : course) {
            Map<String, Integer> map = new HashMap<>();
            menuCount.put(num, map);
            for (String order : orders) {
                combination(order, 0, num, new StringBuilder());
            }
        }

        // 최대로 많이 뽑힌 조합 고르기
        List<String> result = new ArrayList<>();
        for (Integer nums : menuCount.keySet()) {
            Map<String, Integer> map = menuCount.get(nums);
            int max = Integer.MIN_VALUE;
            for (int value : map.values()) {
                max = Math.max(max, value);
            }
            if (max == 1) {
                continue;
            }
            for (String menu : map.keySet()) {
                if (map.get(menu) == max) {
                    result.add(menu);
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void combination(String order, int i, int num, StringBuilder menu) {
        if (menu.length() == num) {
            Map<String, Integer> map = menuCount.get(num);
            map.put(menu.toString(), map.getOrDefault(menu.toString(), 0) + 1);
            return;
        }
        if (i == order.length()) {
            return;
        }
        for (int j = i; j < order.length(); j++) {
            StringBuilder sb = new StringBuilder(menu);
            sb.append(order.charAt(j));
            combination(order, j + 1, num, sb);
        }
    }
}
/*
테스트 1 〉	통과 (2.16ms, 74.4MB)
테스트 2 〉	통과 (1.13ms, 67MB)
테스트 3 〉	통과 (2.41ms, 77.9MB)
테스트 4 〉	통과 (2.65ms, 77MB)
테스트 5 〉	통과 (2.22ms, 70.3MB)
테스트 6 〉	통과 (3.12ms, 74.8MB)
테스트 7 〉	통과 (3.23ms, 72.6MB)
테스트 8 〉	통과 (6.76ms, 80.1MB)
테스트 9 〉	통과 (10.87ms, 81MB)
테스트 10 〉	통과 (10.38ms, 89.8MB)
테스트 11 〉	통과 (27.02ms, 89.3MB)
테스트 12 〉	통과 (7.38ms, 84.9MB)
테스트 13 〉	통과 (13.77ms, 86.2MB)
테스트 14 〉	통과 (9.84ms, 83.6MB)
테스트 15 〉	통과 (16.76ms, 87.6MB)
테스트 16 〉	통과 (6.84ms, 68.8MB)
테스트 17 〉	통과 (13.99ms, 81.4MB)
테스트 18 〉	통과 (13.69ms, 88.9MB)
테스트 19 〉	통과 (15.81ms, 91.9MB)
테스트 20 〉	통과 (15.26ms, 86.6MB)
 */
