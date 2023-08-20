package programmers.test2305.test230529;

import java.util.Arrays;

public class Lev1_21 {
    public static void main( String[] args ) {

        Lev1_21 lev = new Lev1_21();

        String[] t1_keymap = { "ABACD", "BCEFD" };
        String[] t1_targets = { "ABCD", "AABB" };
        String[] t2_keymap = { "AA" };
        String[] t2_targets = { "B" };
        String[] t3_keymap = { "AGZ", "BSSS" };
        String[] t3_targets = { "ASA", "BGZ" };

        System.out.println( Arrays.toString( lev.solution( t1_keymap, t1_targets ) ) );
        System.out.println( Arrays.toString( lev.solution( t2_keymap, t2_targets ) ) );
        System.out.println( Arrays.toString( lev.solution( t3_keymap, t3_targets ) ) );

    }

    public int[] solution( String[] keymap, String[] targets ) {
        int[] answer = new int[targets.length];
        for ( int i = 0 ; i < targets.length ; i++ ) {
            String target = targets[i];
            // target = "ABCD", "AABB"
            for ( int j = 0 ; j < target.length() ; j++ ) {
                String str = "" + target.charAt( j );
                // str = "A","B","C","D"
                int count = 101;
                for ( String key : keymap ) {
                    // key : "ABCDE","BCEFD"
                    if ( key.indexOf( str ) != -1 ) {
                        count = count > key.indexOf( str ) ? key.indexOf( str ) + 1 : count;
                    }
                }
                if ( count == 101 ) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += count;
                }
            }
        }


        return answer;
    }
}
/*
테스트 1 〉	통과 (10.47ms, 78.3MB)
테스트 2 〉	통과 (10.99ms, 84.6MB)
테스트 3 〉	통과 (7.16ms, 73MB)
테스트 4 〉	통과 (8.00ms, 78.3MB)
테스트 5 〉	통과 (8.82ms, 71.8MB)
테스트 6 〉	통과 (10.68ms, 82.1MB)
테스트 7 〉	통과 (7.75ms, 71.4MB)
테스트 8 〉	통과 (6.98ms, 73.5MB)
테스트 9 〉	통과 (10.05ms, 76.7MB)
테스트 10 〉	통과 (7.22ms, 74.6MB)
테스트 11 〉	통과 (5.93ms, 75.2MB)
테스트 12 〉	통과 (5.62ms, 82.5MB)
테스트 13 〉	통과 (5.61ms, 78.7MB)
테스트 14 〉	통과 (21.10ms, 87.9MB)
테스트 15 〉	통과 (17.56ms, 83.8MB)
테스트 16 〉	통과 (17.54ms, 77.3MB)
테스트 17 〉	통과 (22.55ms, 81.9MB)
테스트 18 〉	통과 (16.64ms, 79.9MB)
테스트 19 〉	통과 (15.00ms, 82.2MB)
테스트 20 〉	통과 (14.66ms, 78.2MB)
테스트 21 〉	통과 (17.28ms, 78.6MB)
테스트 22 〉	통과 (15.48ms, 81.6MB)
테스트 23 〉	통과 (15.64ms, 75.2MB)
 */
