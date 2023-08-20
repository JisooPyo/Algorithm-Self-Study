package programmers.test2306.test230619;

import java.util.Arrays;

public class LV1RunningRace_try2 {
    public static void main( String[] args ) {
        LV1RunningRace_try2 rr = new LV1RunningRace_try2();

        String[] t1_1 = { "mumu", "soe", "poe", "kai", "mine" };
        String[] t1_2 = { "kai", "kai", "mine", "mine" };

        System.out.println( Arrays.toString( rr.solution( t1_1, t1_2 ) ) );
    }

    public String[] solution( String[] players, String[] callings ) {
        for ( int i = 0; i < callings.length; i++ ) {
            String call = callings[i];
            int callingIndex = Arrays.asList( players ).indexOf( call );
            String temp = players[callingIndex - 1];
            players[callingIndex - 1] = call;
            players[callingIndex] = temp;
        }
        return players;
    }
}

/*
테스트 1 〉통과 (0.09ms, 81.5MB)
테스트 2 〉통과 (0.07ms, 64.6MB)
테스트 3 〉통과 (0.27ms, 78.2MB)
테스트 4 〉통과 (1.80ms, 71.7MB)
테스트 5 〉통과 (12.76ms, 90.7MB)
테스트 6 〉통과 (38.27ms, 105MB)
테스트 7 〉통과 (477.42ms, 123MB)
테스트 8 〉통과 (2255.32ms, 105MB)
테스트 9 〉실패 (시간 초과)
테스트 10 〉실패 (시간 초과)
테스트 11 〉실패 (시간 초과)
테스트 12 〉실패 (시간 초과)
테스트 13 〉실패 (시간 초과)
테스트 14 〉통과 (0.06ms, 74.4MB)
테스트 15 〉통과 (0.07ms, 73.1MB)
테스트 16 〉통과 (0.07ms, 70.3MB)
 */