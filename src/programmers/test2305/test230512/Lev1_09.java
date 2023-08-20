// 실패율
package programmers.test2305.test230512;

import java.util.Arrays;
import java.util.Comparator;

public class Lev1_09 {
    public static void main( String[] args ) {
        Lev1_09 lev = new Lev1_09();

        int[] t1 = { 2, 1, 2, 6, 2, 4, 3, 3 };
        int[] t2 = { 4, 4, 4, 4, 4 };

        System.out.println( Arrays.toString( lev.solution( 5, t1 ) ) );
        System.out.println( Arrays.toString( lev.solution( 4, t2 ) ) );
    }

    public int[] solution( int N, int[] stages ) {
        int[] ind = new int[N + 2];
        for ( int i = 0 ; i < stages.length ; i++ ) {
            ind[stages[i]]++;
        }

        double[][] failure_rate = new double[N][2];
        int clear = stages.length;
        for ( int i = 0 ; i < N ; i++ ) {
            int unclear = ind[i + 1];
            if ( clear == 0 ) {
                failure_rate[i][0] = 0;
                failure_rate[i][1] = i + 1;
            } else {
                failure_rate[i][0] = (double) ( unclear ) / clear;
                failure_rate[i][1] = i + 1;
            }
            clear = clear - unclear;

        }
        Arrays.sort( failure_rate, new Comparator< double[] >() {
            @Override
            public int compare( double[] o1, double[] o2 ) {
                return Double.compare( o2[0], o1[0] );
            }
        } );

        int ans[] = new int[N];
        for ( int i = 0 ; i < N ; i++ ) {
            ans[i] = (int) ( failure_rate[i][1] );
        }

        return ans;
    }
}

// 1, 6, 7, 9, 13, 23, 24, 25

// 0으로 나눠지는 것 따로 처리 후 끝!

