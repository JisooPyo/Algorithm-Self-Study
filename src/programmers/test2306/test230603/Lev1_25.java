// 바탕화면 정리
package programmers.test2306.test230603;

import java.util.Arrays;

public class Lev1_25 {


    public static void main( String[] args ) {
        Lev1_25 lev = new Lev1_25();

        String[] t1 = { ".#...",
                "..#..",
                "...#." };

        String[] t2 = { "..........",
                ".....#....",
                "......##..",
                "...##.....",
                "....#....." };

        String[] t3 = { ".##...##.",
                "#..#.#..#",
                "#...#...#",
                ".#.....#.",
                "..#...#..",
                "...#.#...",
                "....#...." };

        String[] t4 = { "..",
                "#." };

        System.out.println( Arrays.toString( lev.solution( t1 ) ) );
        System.out.println( Arrays.toString( lev.solution( t2 ) ) );
        System.out.println( Arrays.toString( lev.solution( t3 ) ) );
        System.out.println( Arrays.toString( lev.solution( t4 ) ) );
    }

    public int[] solution( String[] wallpaper ) {
        int lux = 0;
        int luy = 0;
        int rdx = 0;
        int rdy = 0;
        loop1:
        for ( int i = 0 ; i < wallpaper.length ; i++ ) {
            for ( int j = 0 ; j < wallpaper[i].length() ; j++ ) {
                if ( wallpaper[i].charAt( j ) == '#' ) {
                    lux = i;
                    luy = j;
                    rdx = i;
                    rdy = j;
                    break loop1;
                }
            }
        }
        // lux, luy, rdx, rdy의 초기값 정하기

        for ( int i = 0 ; i < wallpaper.length ; i++ ) {
            for ( int j = 0 ; j < wallpaper[i].length() ; j++ ) {
                if ( wallpaper[i].charAt( j ) == '#' ) {
                    if ( luy > j ) {
                        luy = j;
                    }
                    if ( i > rdx ) {
                        rdx = i;
                    }
                    if ( j > rdy ) {
                        rdy = j;
                    }
                }
            }
        }
        // luy보다 더 왼쪽에 있을 경우 luy 수정.
        // rdx보다 i가 더 오른쪽에 있을 경우 rdx 수정
        // rdy보다 j가 더 아래에 있을 경우 rdy 수정

        rdx++;
        rdy++;
        // 문제에서는 줄로 세지만 여기서는 칸으로 세므로 끝 칸 값을 하나씩 더해줌.

        int[] answer = new int[] { lux, luy, rdx, rdy };
        return answer;
    }
}

/*

테스트 31 〉	통과 (0.29ms, 71.3MB) -> 가장 오래 걸림

다른 사람의 풀이
minX 에는 Integer.MAX_VALUE; 가장 큰 값을 넣어 비교하였을 때 작은 값이 들어가도록 하고
maxX 에는 Integer.MIN_VALUE; 가장 작은 값을 넣어 비교하였을 때 가장 큰 값이 들어가도록 하여
나처럼 따로 초기값이 주어진 for문이 필요 없다..!

0을 넣어 비교하기 어려울 때는 이렇게 비교하면 좋다는 것을 기억!
배열의 크기의 최대값이 정해져 있으므로 그것과 비교해도 좋을 것 같다.

*/
