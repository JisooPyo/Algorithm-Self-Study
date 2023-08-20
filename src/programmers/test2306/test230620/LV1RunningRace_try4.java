package programmers.test2306.test230620;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LV1RunningRace_try4 {
    public static void main(String[] args) {
        LV1RunningRace_try4 rr = new LV1RunningRace_try4();

        String[] t1_1 = {"mumu", "soe", "poe", "kai", "mine"};
        String[] t1_2 = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(rr.solution(t1_1, t1_2)));
    }

    public String[] solution(String[] players, String[] callings) {
        LinkedList<String> rank = new LinkedList<>();
        for (int i = 0; i < players.length; i++) {
            rank.add(players[i]);
        }

        for (int i = 0; i < callings.length; i++) {
            String call = callings[i];
            int callIndex = rank.indexOf(call);
            rank.remove(callIndex);
            rank.add(callIndex - 1, call);
        }

        Iterator<String> it = rank.iterator();
        String[] answer = new String[players.length];
        int i = 0;
        while (it.hasNext()) {
            answer[i] = it.next();
            i++;
        }

        return answer;
    }

}

/*
테스트 1 〉통과 (0.27ms, 66.3MB)
테스트 2 〉통과 (0.26ms, 79.8MB)
테스트 3 〉통과 (0.84ms, 78.9MB)
테스트 4 〉통과 (4.03ms, 82.1MB)
테스트 5 〉통과 (26.36ms, 96.2MB)
테스트 6 〉통과 (81.26ms, 91.1MB)
테스트 7 〉통과 (1709.60ms, 120MB)
테스트 8 〉통과 (8224.60ms, 130MB)
테스트 9 〉실패 (시간 초과)
테스트 10 〉실패 (시간 초과)
테스트 11 〉실패 (시간 초과)
테스트 12 〉실패 (시간 초과)
테스트 13 〉실패 (시간 초과)
테스트 14 〉통과 (0.31ms, 79.2MB)
테스트 15 〉통과 (0.29ms, 78.6MB)
테스트 16 〉통과 (0.29ms, 75.3MB)
 */