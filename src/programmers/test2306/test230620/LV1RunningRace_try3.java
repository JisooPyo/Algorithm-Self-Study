package programmers.test2306.test230620;

import java.util.Arrays;

public class LV1RunningRace_try3 {
    public static void main( String[] args ) {
        LV1RunningRace_try3 rr = new LV1RunningRace_try3();

        String[] t1_1 = { "mumu", "soe", "poe", "kai", "mine" };
        String[] t1_2 = { "kai", "kai", "mine", "mine" };

        System.out.println( Arrays.toString( rr.solution( t1_1, t1_2 ) ) );
    }

    public String[] solution( String[] players, String[] callings ) {
        for ( int i = 0; i < callings.length; i++ ) {
            int callOfIndex = indexOfArr( players, callings[i] );   // 3
            String temp = callings[i];  // temp = "kai"
            players[callOfIndex] = players[callOfIndex - 1];
            players[callOfIndex - 1] = temp;
        }
        return players;
    }

    public int indexOfArr( String[] strArr, String str ) {
        for ( int i = 0; i < strArr.length; i++ ) {
            if ( strArr[i].equals( str ) ) {
                return i;
            }
        }
        return -1;
    }
}

/*
테스트 1 〉통과 (0.01ms, 82.9MB)
테스트 2 〉통과 (0.03ms, 72.8MB)
테스트 3 〉통과 (0.12ms, 83.4MB)
테스트 4 〉통과 (1.25ms, 79.5MB)
테스트 5 〉통과 (10.67ms, 91.1MB)
테스트 6 〉통과 (24.42ms, 106MB)
테스트 7 〉통과 (420.55ms, 130MB)
테스트 8 〉통과 (1826.91ms, 105MB)
테스트 9 〉실패 (시간 초과)
테스트 10 〉실패 (시간 초과)
테스트 11 〉실패 (시간 초과)
테스트 12 〉실패 (시간 초과)
테스트 13 〉실패 (시간 초과)
테스트 14 〉통과 (0.02ms, 82.6MB)
테스트 15 〉통과 (0.02ms, 72.8MB)
테스트 16 〉통과 (0.03ms, 74.7MB)
 */