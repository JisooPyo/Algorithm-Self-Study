// 햄버거 만들기
package programmers.test2306.test230601;

import java.util.ArrayList;
import java.util.List;

public class Lev1_23 {
    public static void main( String[] args ) {
        Lev1_23 lev = new Lev1_23();

        int[] t1 = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };
        int[] t2 = { 1, 3, 2, 1, 2, 1, 3, 1, 2 };

        System.out.println( lev.solution( t1 ) );
        System.out.println( lev.solution( t2 ) );
    }

    public int solution( int[] ingredient ) {
        int answer = 0;
        List< Integer > list = new ArrayList<>();
        for ( int i = 0 ; i < ingredient.length ; i++ ) {
            list.add( ingredient[i] );
            if ( list.size() >= 4 ) {
                int s = list.size();
                if ( list.get( s - 4 ) == 1 && list.get( s - 3 ) == 2 && list.get( s - 2 ) == 3 && list.get( s - 1 ) == 1 ) {
                    list.remove( list.size() - 1 );
                    list.remove( list.size() - 1 );
                    list.remove( list.size() - 1 );
                    list.remove( list.size() - 1 );
                    answer++;
                }
            }
        }
        return answer;
    }
}

/*
테스트 1 〉	통과 (0.04ms, 76MB)
테스트 2 〉	통과 (0.04ms, 80.3MB)
테스트 3 〉	통과 (31.00ms, 90.3MB)
테스트 4 〉	통과 (66.64ms, 126MB)
테스트 5 〉	통과 (43.08ms, 147MB)
테스트 6 〉	통과 (46.73ms, 103MB)
테스트 7 〉	통과 (38.17ms, 123MB)
테스트 8 〉	통과 (31.32ms, 101MB)
테스트 9 〉	통과 (30.62ms, 88.4MB)
테스트 10 〉통과 (2.40ms, 74.3MB)
테스트 11 〉통과 (39.12ms, 96.9MB)
테스트 12 〉통과 (63.45ms, 151MB)
테스트 13 〉통과 (0.03ms, 75.6MB)
테스트 14 〉통과 (0.03ms, 69.9MB)
테스트 15 〉통과 (0.02ms, 78.2MB)
테스트 16 〉통과 (0.03ms, 70.5MB)
테스트 17 〉통과 (0.03ms, 73.1MB)
테스트 18 〉통과 (0.05ms, 81.7MB)
 */