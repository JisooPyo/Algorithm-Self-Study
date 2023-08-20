// 과일장수
package programmers.test2305.test230512;

import java.util.Arrays;

public class Lev1_08 {
    public static void main( String[] args ) {
        Lev1_08 lev = new Lev1_08();

        int[] t1 = { 1, 2, 3, 1, 2, 3, 1 };
        int[] t2 = { 4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2 };

        System.out.println( lev.solution( 3, 4, t1 ) );
        System.out.println( lev.solution( 3, 8, t1 ) );
        System.out.println( lev.solution( 4, 3, t2 ) );
    }

    public int solution( int k, int m, int[] score ) {
        int answer = 0;
        int len = score.length;
        Arrays.sort( score );
        int[] rev = new int[( len / m ) * m];
        for ( int i = 0 ; i < rev.length ; i++ ) {
            rev[i] = score[len - 1 - i];
        }
        for ( int i = 0 ; i < rev.length ; i += m ) {
            answer += rev[i + m - 1] * m;
        }
        return answer;
    }
}

// 11, 12, 13, 14, 15 : 시간초과 -> list로 했을 때
// 통과. 배열로 바꿔서 해서. 근데 굳이 역순해줄 필요는 없었던 거 같다.