// 로또의 최고 순위와 최저 순위
package programmers.test2305.test230514;

import java.util.Arrays;

public class Lev1_14 {
    public static void main( String[] args ) {
        Lev1_14 lev = new Lev1_14();

        int[] t1_1 = { 44, 1, 0, 0, 31, 25 };
        int[] t1_2 = { 31, 10, 45, 1, 6, 19 };
        int[] t2_1 = { 0, 0, 0, 0, 0, 0 };
        int[] t2_2 = { 38, 19, 20, 40, 15, 25 };
        int[] t3_1 = { 45, 4, 35, 20, 3, 9 };
        int[] t3_2 = { 20, 9, 3, 45, 4, 35 };

        System.out.println( Arrays.toString( lev.solution( t1_1, t1_2 ) ) );
        System.out.println( Arrays.toString( lev.solution( t2_1, t2_2 ) ) );
        System.out.println( Arrays.toString( lev.solution( t3_1, t3_2 ) ) );
    }

    public int[] solution( int[] lottos, int[] win_nums ) {
        int[] answer = new int[2];
        int equal = 0;
        int zero = 0;
        for ( int i = 0 ; i < lottos.length ; i++ ) {
            for ( int j = 0 ; j < win_nums.length ; j++ ) {
                if ( lottos[i] == win_nums[j] ) {
                    equal++;
                }
            }
            if ( lottos[i] == 0 ) {
                zero++;
            }
        }
        if ( equal == 0 && zero == 0 ) {
            answer[0] = 6;
            answer[1] = 6;
        } else if ( equal == 0 ) {
            answer[0] = 6 - zero + 1;
            answer[1] = 6;
        } else {
            answer[0] = 7 - equal - zero;
            answer[1] = 7 - equal;
        }
        return answer;
    }
}
