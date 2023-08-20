package programmers.test2305.test230527;

import java.util.Stack;

public class Lev1_20 {
    public static void main( String[] args ) {
        Lev1_20 lev = new Lev1_20();
        int[][] t1 = {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 3 },
                { 0, 2, 5, 0, 1 },
                { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 }
        };  //[i,0][i,1][i,2][i,3][i,4]
        int[] t1_1 = { 1, 5, 3, 5, 1, 2, 1, 4 };
        System.out.println( lev.solution( t1, t1_1 ) );
    }

    public int solution( int[][] board, int[] moves ) {
        int answer = 0;
        Stack< Integer > basket = new Stack<>();
        for ( int i = 0 ; i < moves.length ; i++ ) {
            for ( int j = 0 ; j < board[0].length ; j++ ) {
                int element = board[j][moves[i] - 1];
                if ( element != 0 ) {
                    if ( basket.size() == 0 ) {
                        basket.push( element );
                    } else {
                        if ( basket.peek() == element ) {
                            basket.pop();
                            answer += 2;
                        } else {
                            basket.push( element );
                        }
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }


        return answer;
    }

}
/*

 */