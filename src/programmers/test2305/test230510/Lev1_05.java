// 소수 찾기
package programmers.test2305.test230510;

public class Lev1_05 {
    public static void main( String[] args ) {
        Lev1_05 lev = new Lev1_05();

        System.out.println( lev.solution( 10 ) );
        System.out.println( lev.solution( 1000000 ) );

    }

    public int solution( int n ) {
        int[] arr = new int[n + 1];
        for ( int i = 0 ; i <= n ; i++ ) {
            arr[i] = i;
        }

        arr[1] = 0;

        for ( int i = 2 ; i <= n ; i++ ) {
            if ( arr[i] == 0 ) continue;
            for ( int j = i * 2 ; j <= n ; j += i ) {
                arr[j] = 0;
            }
        }

        int answer = 0;
        for ( int i = 0 ; i < arr.length ; i++ ) {
            if ( arr[i] != 0 ) {
                answer++;
            }
        }
        return answer;
    }
}



