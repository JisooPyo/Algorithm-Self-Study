// 기사단원의 무기
package programmers.test2305.test230514;

public class Lev1_13 {
    public static void main( String[] args ) {
        Lev1_13 lev = new Lev1_13();

        System.out.println( lev.solution( 5, 3, 2 ) );
        System.out.println( lev.solution( 10, 3, 2 ) );
    }

    public int solution( int number, int limit, int power ) {
        int answer = 0;
        for ( int j = 1 ; j <= number ; j++ ) {
            int attack = 0;
            int div_cnt = 0;
            for ( int i = 1 ; i <= Math.sqrt( j ) ; i++ ) {
                if ( j % i == 0 ) {
                    div_cnt++;
                }
            }
            if ( ( (int) Math.sqrt( j ) ) * ( (int) Math.sqrt( j ) ) == j ) {
                div_cnt = div_cnt * 2 - 1;
            } else {
                div_cnt *= 2;
            }
            if ( div_cnt > limit ) {
                attack = power;
            } else {
                attack = div_cnt;
            }
            answer += attack;
        }
        return answer;
    }
}

/*
다른 사람이 푼 약수의 개수 구하기
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                count[i * j]++;
            }
        }
 */