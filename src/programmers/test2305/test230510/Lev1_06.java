// 소수 만들기
package programmers.test2305.test230510;


import java.util.ArrayList;
import java.util.List;

public class Lev1_06 {
    public static void main( String[] args ) {
        Lev1_06 lev = new Lev1_06();

        int[] t1 = { 1, 2, 3, 4 };
        int[] t2 = { 1, 2, 7, 6, 4 };

        System.out.println( lev.solution( t1 ) );
        System.out.println( lev.solution( t2 ) );

    }

    public int solution( int[] nums ) {
        List< Integer > list = new ArrayList<>();
        for ( int i = 0 ; i < nums.length - 2 ; i++ ) {
            for ( int j = i + 1 ; j < nums.length - 1 ; j++ ) {
                for ( int k = j + 1 ; k < nums.length ; k++ ) {
                    int element = nums[i] + nums[j] + nums[k];
                    list.add( element );
                }
            }
        }
        int[] sums = list.stream().mapToInt( i -> i ).toArray();
        list = new ArrayList<>();
        for ( int i = 0 ; i < sums.length ; i++ ) {
            int div_count = 0;
            for ( int j = 2 ; j <= Math.sqrt( sums[i] ) ; j++ ) {
                if ( sums[i] % j == 0 ) {
                    div_count++;
                }
            }
            if ( div_count == 0 ) {
                list.add( sums[i] );
            }
        }
        return list.size();
    }
}
