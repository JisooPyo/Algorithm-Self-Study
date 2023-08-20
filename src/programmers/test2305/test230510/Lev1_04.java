// 모의고사
package programmers.test2305.test230510;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lev1_04 {
  public static void main( String[] args ) {
    Lev1_04 lev = new Lev1_04();

    int[] t1 = { 1, 2, 3, 4, 5 };
    int[] t2 = { 1, 3, 2, 4, 2 };

    System.out.println( Arrays.toString( lev.solution( t1 ) ) );
    System.out.println( Arrays.toString( lev.solution( t2 ) ) );

  }

  public int[] solution( int[] answers ) {
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    // 점수 구하기
    for ( int i = 0 ; i < answers.length ; i++ ) {
      switch ( i % 5 ) {
        case 0 -> {          if ( answers[i] == 1 ) score1++;        }
        case 1 -> {          if ( answers[i] == 2 ) score1++;        }
        case 2 -> {          if ( answers[i] == 3 ) score1++;        }
        case 3 -> {          if ( answers[i] == 4 ) score1++;        }
        case 4 -> {          if ( answers[i] == 5 ) score1++;        }
      }
      switch ( i % 8 ) {
        case 0, 2, 4, 6 -> {          if ( answers[i] == 2 ) score2++;        }
        case 1 -> {          if ( answers[i] == 1 ) score2++;        }
        case 3 -> {          if ( answers[i] == 3 ) score2++;        }
        case 5 -> {          if ( answers[i] == 4 ) score2++;        }
        case 7 -> {          if ( answers[i] == 5 ) score2++;        }
      }
      switch ( i % 10 ) {
        case 0, 1 -> {          if ( answers[i] == 3 ) score3++;        }
        case 2, 3 -> {          if ( answers[i] == 1 ) score3++;        }
        case 4, 5 -> {          if ( answers[i] == 2 ) score3++;        }
        case 6, 7 -> {          if ( answers[i] == 4 ) score3++;        }
        case 8, 9 -> {          if ( answers[i] == 5 ) score3++;        }
      }
    }
    int maxScore = Math.max( Math.max( score1, score2 ), score3 );
    int[] scores = { score1, score2, score3 };
    List< Integer > list = new ArrayList<>();
    for ( int i = 0 ; i < 3 ; i++ ) {
      if ( maxScore == scores[i] ) {
        list.add( i + 1 );
      }
    }

    return list.stream().sorted().mapToInt( i -> i ).toArray();
  }
}
