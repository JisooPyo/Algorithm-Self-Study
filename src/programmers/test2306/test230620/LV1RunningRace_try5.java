package programmers.test2306.test230620;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LV1RunningRace_try5 {
    public static void main(String[] args) {
        LV1RunningRace_try5 rr = new LV1RunningRace_try5();

        String[] t1_1 = {"mumu", "soe", "poe", "kai", "mine"};
        String[] t1_2 = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(rr.solution(t1_1, t1_2)));
    }

    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(i, players[i]);
        }
        for (int i = 0; i < callings.length; i++) {
            String call = callings[i];  // call = "kai"
            int callIndex = findKey(rank, call); // 3
            String front = rank.get(callIndex - 1);   // 2인 애 찾기

            rank.put(callIndex, rank.get(callIndex - 1));
            rank.put(callIndex - 1, call);
        }

        String[] answer = new String[players.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = rank.get(i);
        }
        return answer;
    }

    public Integer findKey(Map<Integer, String> map, String str) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

}

/*
테스트 1 〉통과 (0.08ms, 74.3MB)
테스트 2 〉통과 (0.08ms, 76.1MB)
테스트 3 〉통과 (0.94ms, 76.5MB)
테스트 4 〉통과 (3.85ms, 87.1MB)
테스트 5 〉통과 (67.55ms, 80MB)
테스트 6 〉통과 (125.11ms, 96.3MB)
테스트 7 〉통과 (1618.49ms, 122MB)
테스트 8 〉통과 (7122.29ms, 116MB)
테스트 9 〉실패 (시간 초과)
테스트 10 〉실패 (시간 초과)
테스트 11 〉실패 (시간 초과)
테스트 12 〉실패 (시간 초과)
테스트 13 〉실패 (시간 초과)
테스트 14 〉통과 (0.10ms, 79.3MB)
테스트 15 〉통과 (0.15ms, 90MB)
테스트 16 〉통과 (0.11ms, 81.1MB)
 */