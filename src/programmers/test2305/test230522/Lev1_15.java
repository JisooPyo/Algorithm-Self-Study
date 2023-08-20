// 숫자 짝꿍
package programmers.test2305.test230522;

public class Lev1_15 {
    public static void main( String[] args ) {
        Lev1_15 lev = new Lev1_15();

        System.out.println( lev.solution( "100", "2345" ) );
        System.out.println( lev.solution( "100", "203045" ) );
        System.out.println( lev.solution( "100", "123450" ) );
        System.out.println( lev.solution( "12321", "42531" ) );
        System.out.println( lev.solution( "5525", "1255" ) );
    }

    public String solution( String X, String Y ) {
        int[] xnum = new int[10];
        int[] ynum = new int[10];
        for ( int i = 0 ; i < X.length() ; i++ ) {
            xnum[X.charAt( i ) - '0']++;
        }
        for ( int i = 0 ; i < Y.length() ; i++ ) {
            ynum[Y.charAt( i ) - '0']++;
        }

        for ( int i = 0 ; i <= 9 ; i++ ) {
            xnum[i] = Math.min( xnum[i], ynum[i] );
        }

        int sum = 0;
        int zerocount = 0;
        for ( int i = 0 ; i <= 9 ; i++ ) {
            sum += xnum[i];
            if ( i >= 1 ) {
                zerocount += xnum[i];
            }
        }

        if ( sum == 0 ) {
            return "-1";
        } else if ( zerocount == 0 ) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for ( int i = 9 ; i >= 0 ; i-- ) {
            String plus = "";
            if ( xnum[i] != 0 ) {
                plus += i;
                sb.append( plus.repeat( xnum[i] ) );
            }
        }

        return sb.toString();
    }

}

// 배열 정렬하고 뽑아서 나열.
// 6, 7, 8, 9, 10 : 실패, 11, 12, 13, 14, 15 : 시간 초과

// Stringbuilder로 바꿔서 해보기
// 6, 7, 8, 9, 10: 실패, 11, 12, 13, 14, 15 : 시간 초과
// 일단 방법 자체가 틀린 거 같다..

// 배열을 먼저 정렬하지 말고 공통된 걸 먼저 뽑자.
// 배열 정렬하는데 더 시간이 걸리는 거 같아. for문돌리는게 더 걸리는 거 아닌가..? 일단 해봄.

/*
* 테스트 1 〉	통과 (0.38ms, 75MB)
테스트 2 〉 	통과 (0.56ms, 77.1MB)
테스트 3 〉 	통과 (0.47ms, 73.3MB)
테스트 4 〉 	통과 (0.62ms, 84.3MB)
테스트 5 〉 	통과 (0.60ms, 75.8MB)
테스트 6 〉	    통과 (2.06ms, 74MB)
테스트 7 〉 	통과 (0.92ms, 73.2MB)
테스트 8 〉 	통과 (1.95ms, 73.2MB)
테스트 9 〉	    통과 (1.26ms, 72.8MB)
테스트 10 〉	통과 (2.85ms, 74.9MB)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	실패 (시간 초과)
테스트 14 〉	실패 (시간 초과)
테스트 15 〉	실패 (시간 초과)
테스트 16 〉	통과 (0.08ms, 74.5MB)
테스트 17 〉	통과 (0.05ms, 72.6MB)
테스트 18 〉	통과 (0.05ms, 73.7MB)
테스트 19 〉	통과 (0.25ms, 72.7MB)
* */

// 6, 7, 8, 9, 10이 맞았다. 시간을 더 줄여야 함.

/*
테스트 1 〉	    통과 (9.90ms, 75.5MB)
테스트 2 〉 	통과 (12.34ms, 82.8MB)
테스트 3 〉	    통과 (10.38ms, 79.6MB)
테스트 4 〉 	통과 (14.64ms, 73.6MB)
테스트 5 〉	    통과 (14.08ms, 78.1MB)
테스트 6 〉 	통과 (14.62ms, 79.8MB)
테스트 7 〉	    통과 (9.01ms, 73.1MB)
테스트 8 〉 	통과 (13.80ms, 77.2MB)
테스트 9 〉	    통과 (10.36ms, 71.6MB)
테스트 10 〉	통과 (13.67ms, 69.8MB)
테스트 11 〉	통과 (52.83ms, 153MB)
테스트 12 〉	통과 (46.86ms, 133MB)
테스트 13 〉	통과 (45.67ms, 140MB)
테스트 14 〉	통과 (53.46ms, 148MB)
테스트 15 〉	통과 (57.77ms, 147MB)
테스트 16 〉	통과 (0.03ms, 75.6MB)
테스트 17 〉	통과 (0.04ms, 73.9MB)
테스트 18 〉	통과 (0.03ms, 75.4MB)
테스트 19 〉	통과 (0.04ms, 78.5MB)
 */