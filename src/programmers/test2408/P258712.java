package programmers.test2408;

import java.util.HashMap;
import java.util.Map;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/258712
프로그래머스 lv.1
2024 KAKAO WINTER INTERNSHIP
가장 많이 받은 선물
 */
public class P258712 {
    public static void main(String[] args) {
        P258712 p = new P258712();
        String[] friends1 = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts1 = {
            "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi",
            "frodo muzi", "frodo ryan", "neo muzi"
        };

        String[] friends2 = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts2 = {
            "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"
        };

        String[] friends3 = {"a", "b", "c"};
        String[] gifts3 = {"a b", "b a", "c a", "a c", "a c", "c a"};
        // 준 친구 받은 친구
        // 선물 지수 = 준 선물 수 - 받은 선물 수
        System.out.println(p.solution(friends1, gifts1));       // 2
        System.out.println(p.solution(friends2, gifts2));       // 4
        System.out.println(p.solution(friends3, gifts3));       // 0
    }

    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        // 친구별 index 기록
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(friends[i], i);
        }

        // 준 선물 수, 받은 선물 수, 각자 선물 수 기록
        int[] totCount = new int[len];
        // row : 준 사람, column: 받은 사람
        int[][] giftCount = new int[len][len];
        for (int i = 0; i < gifts.length; i++) {
            String[] split = gifts[i].split(" ");
            String give = split[0];
            String take = split[1];
            giftCount[map.get(give)][map.get(take)]++;
            totCount[map.get(give)]++;
            totCount[map.get(take)]--;
        }

        int[] giftCalculate = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (giftCount[i][j] > giftCount[j][i]) {
                    giftCalculate[i]++;
                } else if (giftCount[i][j] < giftCount[j][i]) {
                    giftCalculate[j]++;
                } else {
                    if (totCount[i] > totCount[j]) {
                        giftCalculate[i]++;
                    } else if (totCount[i] < totCount[j]) {
                        giftCalculate[j]++;
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int gift : giftCalculate) {
            answer = Math.max(answer, gift);
        }
        return answer;
    }
}
