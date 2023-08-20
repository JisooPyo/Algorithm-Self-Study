// 덧칠하기
package programmers.test2305.test230514;

public class Lev1_12 {
    public static void main( String[] args ) {
        Lev1_12 lev = new Lev1_12();

        int[] t1 = { 2, 3, 6 };
        int[] t2 = { 1, 3 };
        int[] t3 = { 1, 2, 3, 4 };

        System.out.println( lev.solution( 8, 4, t1 ) );
        System.out.println( lev.solution( 5, 4, t2 ) );
        System.out.println( lev.solution( 4, 1, t3 ) );
    }

    public int solution( int n, int m, int[] section ) {
        int answer = 0;
        int[] ind = new int[n + 1];
        for ( int i = 0 ; i < section.length ; i++ ) {
            ind[section[i]]++;
        }
        for ( int i = 1 ; i < ind.length ; i++ ) {
            if ( ind[i] == 1 ) {
                answer++;
                i += m - 1;
            }
        }
        return answer;
    }
}
