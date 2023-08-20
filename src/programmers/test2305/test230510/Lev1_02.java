// 폰켓몬
package programmers.test2305.test230510;

import java.util.HashSet;

public class Lev1_02 {
  public static void main( String[] args ) {
    Lev1_02 lev = new Lev1_02();

    int[] t1 = { 3, 1, 2, 3 };
    int[] t2 = { 3, 3, 3, 2, 2, 4 };
    int[] t3 = { 3, 3, 3, 2, 2, 2 };

    System.out.println( lev.solution( t1 ) );
    System.out.println( lev.solution( t2 ) );
    System.out.println( lev.solution( t3 ) );

  }

  public int solution( int[] nums ) {
    HashSet set = new HashSet();
    for ( int i = 0 ; i < nums.length ; i++ ) {
      set.add( nums[i] );
    }
    return Math.min( set.size(), nums.length / 2 );
  }
}
