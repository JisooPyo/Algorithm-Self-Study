// 명예의 전당

package programmers.test2305.test230512;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lev1_07 {
    public static void main( String[] args ) {
        Lev1_07 lev = new Lev1_07();

        int[] t1 = { 10, 100, 20, 150, 1, 100, 200 };
        int[] t2 = { 0, 300, 40, 300, 20, 70, 150, 50, 500, 1000 };

        System.out.println( Arrays.toString( lev.solution( 3, t1 ) ) );
        System.out.println( Arrays.toString( lev.solution( 4, t2 ) ) );

    }

    public int[] solution( int k, int[] score ) {
        int[] answer = new int[score.length];
        List< Integer > list = new ArrayList<>();
        for ( int i = 0 ; i < answer.length ; i++ ) {
            if ( list.size() < k ) {
                list.add( score[i] );
            } else {
                list.add( score[i] );
                list.sort( Comparator.naturalOrder() );
                list.remove( 0 );
            }
            list.sort( Comparator.naturalOrder() );
            answer[i] = list.get( 0 );
        }
        return answer;
    }


}

/*

다른 사람의 풀이

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int temp = 0;

        for(int i = 0; i < score.length; i++) {

            priorityQueue.add(score[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            answer[i] = priorityQueue.peek();
        }



        return answer;
    }
}

 */