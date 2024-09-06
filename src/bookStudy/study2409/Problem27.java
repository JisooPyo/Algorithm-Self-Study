package bookStudy.study2409;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 lv.3
 * 27. 다단계 칫솔 판매
 */
public class Problem27 {
    public static void main(String[] args) {
        Problem27 p = new Problem27();

        String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller1 = {"young", "john", "tod", "emily", "mary"};
        int[] amount1 = {12, 4, 2, 5, 10};
        // [360, 958, 108, 0, 450, 18, 180, 1080]
        System.out.println(Arrays.toString(p.solution(enroll1, referral1, seller1, amount1)));

        String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller2 = {"sam", "emily", "jaimie", "edward"};
        int[] amount2 = {2, 3, 5, 4};
        // [0, 110, 378, 180, 270, 450, 0, 0]
        System.out.println(Arrays.toString(p.solution(enroll2, referral2, seller2, amount2)));
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 판매원, 판매원을 참여시킨 사람 기록
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
        }

        // 이익 구하기
        Map<String, Integer> profit = new HashMap<>();
        for (int i = 0; i < amount.length; i++) {
            String name = seller[i];
            int value = amount[i] * 100;
            profit.put(name, profit.getOrDefault(name, 0) + value);

            while (map.get(name) != null && (int)(value * 0.1) != 0) {
                profit.put(name, profit.get(name) - (int)(value * 0.1));
                name = map.get(name);
                value = (int)(value * 0.1);
                profit.put(name, profit.getOrDefault(name, 0) + value);
            }
        }

        // int 배열로 반환
        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = profit.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
}
/*
테스트 1 〉	통과 (0.09ms, 74.4MB)
테스트 2 〉	통과 (0.49ms, 76MB)
테스트 3 〉	통과 (0.20ms, 75.6MB)
테스트 4 〉	통과 (0.52ms, 89.6MB)
테스트 5 〉	통과 (1.46ms, 76.6MB)
테스트 6 〉	통과 (3.98ms, 97.4MB)
테스트 7 〉	통과 (4.19ms, 108MB)
테스트 8 〉	통과 (5.08ms, 97.9MB)
테스트 9 〉	통과 (36.04ms, 108MB)
테스트 10 〉	통과 (110.26ms, 121MB)
테스트 11 〉	통과 (57.09ms, 121MB)
테스트 12 〉	통과 (76.84ms, 142MB)
테스트 13 〉	통과 (60.56ms, 125MB)
 */
