package programmers.test2306.test230619;

import java.util.Arrays;

public class LV1RunningRace_try1 {
    public static void main( String[] args ) {
        LV1RunningRace_try1 rr = new LV1RunningRace_try1();

        String[] t1_1 = { "mumu", "soe", "poe", "kai", "mine" };
        String[] t1_2 = { "kai", "kai", "mine", "mine" };

        System.out.println( Arrays.toString( rr.solution( t1_1, t1_2 ) ) );
    }

    public String[] solution( String[] players, String[] callings ) {
        String[] answer = Arrays.copyOf( players, players.length );
        for ( int i = 0; i < callings.length; i++ ) {
            String call = callings[i];
            int callingIndex = Arrays.asList( answer ).indexOf( call );
            String temp = answer[callingIndex - 1];
            answer[callingIndex - 1] = call;
            answer[callingIndex] = temp;
        }
        return answer;
    }
}

/*
테스트 1 〉통과 (0.06ms, 73.6MB)
테스트 2 〉통과 (0.12ms, 84.8MB)
테스트 3 〉통과 (0.30ms, 79.6MB)
테스트 4 〉통과 (1.93ms, 74.7MB)
테스트 5 〉통과 (14.41ms, 86.3MB)
테스트 6 〉통과 (33.22ms, 101MB)
테스트 7 〉통과 (564.85ms, 119MB)
테스트 8 〉통과 (2493.68ms, 113MB)
테스트 9 〉실패 (시간 초과)
테스트 10 〉실패 (시간 초과)
테스트 11 〉실패 (시간 초과)
테스트 12 〉실패 (시간 초과)
테스트 13 〉실패 (시간 초과)
테스트 14 〉통과 (0.10ms, 73.2MB)
테스트 15 〉통과 (0.08ms, 73.8MB)
테스트 16 〉통과 (0.10ms, 75.5MB)

 */