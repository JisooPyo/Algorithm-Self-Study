// 추억 점수
package programmers.test2305.test230510;

import java.util.Arrays;

public class Lev1_01 {

  public static void main( String[] args ) {
    Lev1_01 lev = new Lev1_01();

    String[] t1_1 = { "may", "kein", "kain", "radi" };
    int[] t1_2 = { 5, 10, 1, 3 };
    String[][] t1_3 = { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" }, { "kon", "kain", "may", "coni" } };

    String[] t2_1 = { "kali", "mari", "don" };
    int[] t2_2 = { 11, 1, 55 };
    String[][] t2_3 = { { "kali", "mari", "don" }, { "pony", "tom", "teddy" }, { "con", "mona", "don" } };

    String[] t3_1 = { "may", "kein", "kain", "radi" };
    int[] t3_2 = { 5, 10, 1, 3 };
    String[][] t3_3 = { { "may" }, { "kein", "deny", "may" }, { "kon", "coni" } };

    System.out.println( Arrays.toString( lev.solution( t1_1, t1_2, t1_3 ) ) );
    System.out.println( Arrays.toString( lev.solution( t2_1, t2_2, t2_3 ) ) );
    System.out.println( Arrays.toString( lev.solution( t3_1, t3_2, t3_3 ) ) );

  }

  public int[] solution( String[] name, int[] yearning, String[][] photo ) {
    int[] answer = new int[photo.length];
      for ( int i = 0 ; i < photo.length ; i++ ) {
        for ( int j = 0 ; j < name.length ; j++ ) {
          if ( Arrays.asList( photo[i] ).contains( name[j] ) ) {
            answer[i]+=yearning[j];
          }
        }
      }
    return answer;
  }
}
