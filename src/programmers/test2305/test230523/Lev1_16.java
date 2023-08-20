// 체육복
package programmers.test2305.test230523;

public class Lev1_16 {
    public static void main( String[] args ) {
        Lev1_16 lev = new Lev1_16();

        int[] t1_1 = { 2, 4 };
        int[] t1_2 = { 1, 3, 5 };

        int[] t2_1 = { 2, 4 };
        int[] t2_2 = { 3 };

        int[] t3_1 = { 3 };
        int[] t3_2 = { 1 };

        System.out.println( lev.solution( 5, t1_1, t1_2 ) );
        System.out.println( lev.solution( 5, t2_1, t2_2 ) );
        System.out.println( lev.solution( 3, t3_1, t3_2 ) );
    }

    public int solution( int n, int[] lost, int[] reserve ) {
        int[] allStudents = new int[n + 2];
        for ( int i = 1 ; i <= n ; i++ ) {
            allStudents[i] = 1;
        }
        for ( int i = 0 ; i < reserve.length ; i++ ) {
            allStudents[reserve[i]] = 2;
        }
        for ( int i = 0 ; i < lost.length ; i++ ) {
            allStudents[lost[i]]--;
        }
        for ( int i = 1 ; i <= n ; i++ ) {
            if ( allStudents[i] == 0 ) {
                if ( allStudents[i - 1] == 2 ) {
                    allStudents[i - 1] = 1;
                    allStudents[i] = 1;
                } else if ( allStudents[i + 1] == 2 ) {
                    allStudents[i + 1] = 1;
                    allStudents[i] = 1;
                }
            }
        }
        int answer = 0;
        for ( int i = 1 ; i <= n ; i++ ) {
            if ( allStudents[i] >= 1 ) {
                answer++;
            }
        }

        return answer;
    }
}
