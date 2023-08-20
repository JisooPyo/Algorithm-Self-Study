package programmers.test2306.test230620;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LV1RunningRace_try6pass {
    public static void main(String[] args) {
        LV1RunningRace_try6pass rr = new LV1RunningRace_try6pass();

        String[] t1_1 = {"mumu", "soe", "poe", "kai", "mine"};
        String[] t1_2 = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(rr.solution(t1_1, t1_2)));
    }

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();
        String[] answer = new String[players.length];

        for (int i = 0; i < players.length; i++) {
            answer[i] = players[i];
            rankMap.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String call = callings[i];
            int callIndex = rankMap.get(call);
            answer[callIndex] = answer[callIndex - 1];
            answer[callIndex - 1] = call;
            rankMap.put(call, callIndex - 1);
            rankMap.put(answer[callIndex], callIndex);
        }

        return answer;
    }


}

/*
테스트 1 〉통과 (0.07ms, 76.9MB)
테스트 2 〉통과 (0.08ms, 76.5MB)
테스트 3 〉통과 (0.16ms, 76.9MB)
테스트 4 〉통과 (0.58ms, 69.1MB)
테스트 5 〉통과 (3.18ms, 84.1MB)
테스트 6 〉통과 (4.92ms, 101MB)
테스트 7 〉통과 (25.43ms, 122MB)
테스트 8 〉통과 (36.41ms, 125MB)
테스트 9 〉통과 (98.20ms, 142MB)
테스트 10 〉통과 (172.00ms, 242MB)
테스트 11 〉통과 (343.56ms, 356MB)
테스트 12 〉통과 (453.78ms, 354MB)
테스트 13 〉통과 (299.56ms, 398MB)
테스트 14 〉통과 (0.06ms, 72.6MB)
테스트 15 〉통과 (0.04ms, 82.5MB)
테스트 16 〉통과 (0.04ms, 75.9MB)
 */