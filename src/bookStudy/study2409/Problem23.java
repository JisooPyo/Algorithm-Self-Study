package bookStudy.study2409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 프로그래머스 lv.1
 * 23. 신고 결과 받기
 */
public class Problem23 {
    public static void main(String[] args) {
        Problem23 p = new Problem23();

        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k1 = 2;

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        System.out.println(Arrays.toString(p.solution(id_list1, report1, k1))); // [2, 1, 1, 0]
        System.out.println(Arrays.toString(p.solution(id_list2, report2, k2))); // [0, 0]
    }

    // 책 풀이는 유저당 메일을 받은 횟수를 저장하는 Map을 선언하여 신고리스트를 돌 때
    // reportedCount를 검사하면서 k이상인지 확인하는 작업을 거쳤다.
    // 미리 검사를 해둠으로써 한 번 정지된 사람은 생각해줄 필요가 없어진다. => 더 효율적
    // 책 풀이의 시간복잡도는 O(N + M)

    // 내 풀이
    // 시간복잡도: O(N * M)
    public int[] solution(String[] id_list, String[] report, int k) {
        // 중복 신고 처리
        Set<String> set = new HashSet<>();
        // 유저당 신고 받은 횟수
        Map<String, Integer> reportedCount = new HashMap<>();
        // 각 유저의 신고 목록
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            if (set.contains(report[i])) {
                continue;
            }
            set.add(report[i]);

            String[] split = report[i].split(" ");
            reportedCount.put(split[1], reportedCount.getOrDefault(split[1], 0) + 1);

            if (reportMap.get(split[0]) == null) {
                Set<String> reportSet = new HashSet<>();
                reportSet.add(split[1]);
                reportMap.put(split[0], reportSet);
            } else {
                reportMap.get(split[0]).add(split[1]);
            }
        }

        // 정지된 ID list
        List<String> bannedList = new ArrayList<>();
        for (String user : reportedCount.keySet()) {
            if (reportedCount.get(user) >= k) {
                bannedList.add(user);
            }
        }

        // 메일 받는 횟수 계산
        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            int count = 0;
            Set<String> reportSet = reportMap.get(id_list[i]);
            if (reportSet == null) {
                answer[i] = 0;
                continue;
            }
            for (String bannedUser : bannedList) {
                if (reportSet.contains(bannedUser)) {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.14ms, 78.1MB)
테스트 2 〉	통과 (0.20ms, 77.9MB)
테스트 3 〉	통과 (229.95ms, 163MB)
테스트 4 〉	통과 (0.42ms, 75.9MB)
테스트 5 〉	통과 (0.33ms, 68.2MB)
테스트 6 〉	통과 (3.50ms, 82.3MB)
테스트 7 〉	통과 (4.77ms, 77.5MB)
테스트 8 〉	통과 (5.91ms, 93.8MB)
테스트 9 〉	통과 (113.54ms, 147MB)
테스트 10 〉	통과 (96.36ms, 136MB)
테스트 11 〉	통과 (175.10ms, 170MB)
테스트 12 〉	통과 (3.49ms, 77.5MB)
테스트 13 〉	통과 (1.67ms, 76.6MB)
테스트 14 〉	통과 (118.82ms, 143MB)
테스트 15 〉	통과 (138.20ms, 155MB)
테스트 16 〉	통과 (1.62ms, 75MB)
테스트 17 〉	통과 (1.44ms, 78.9MB)
테스트 18 〉	통과 (4.15ms, 77.8MB)
테스트 19 〉	통과 (8.32ms, 71.7MB)
테스트 20 〉	통과 (117.00ms, 129MB)
테스트 21 〉	통과 (155.70ms, 158MB)
테스트 22 〉	통과 (0.21ms, 78.6MB)
테스트 23 〉	통과 (0.17ms, 82.8MB)
테스트 24 〉	통과 (0.15ms, 75MB)
 */
