package leetcode.al2406;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Easy
 * 2037. Minimum Number of Moves to Seat Everyone
 *
 * 한 방에 n개의 좌석과 n명의 학생이 있다.
 *
 * Given
 * seats : 길이 n 의 배열, seats[i] 는 i번째 좌석의 위치이다.
 * students : 길이 n 의 배열. students[j]는 j번째 학생의 위치이다.
 *
 * 다음의 움직임을 몇 번이든 할 수 있다.
 *   - i번째 학생의 위치를 1 증가시키거나 감소시킨다.(즉, i번째 학생을 position x 에서 x + 1 이나 x - 1로 이동시킨다.)
 *
 * Return
 * 어떤 두 학생도 같은 좌석에 있지 않게끔 학생들을 이동시키는 최소한의 움직임 수를 구하여라.
 *
 * Note
 * 처음에는 같은 위치에 여러 개의 좌석이나 여러 명의 학생들이 있을 수 있다.
 *
 * ex. seats = [3, 1, 5], students = [2, 7, 4]
 * students 2 -> seats 1 : 1 움직임
 * students 7 -> seats 5 : 2 움직임
 * students 4 -> seats 3 : 1 움직임
 * => 총 4 움직임
 */
public class Leet2037 {
    public static void main(String[] args) {
        Leet2037 l = new Leet2037();

        int[] seats1 = {3, 1, 5};
        int[] students1 = {2, 7, 4};

        int[] seats2 = {4, 1, 5, 9};
        int[] students2 = {1, 3, 2, 6};

        int[] seats3 = {2, 2, 6, 6};
        int[] students3 = {1, 3, 2, 6};

        System.out.println(l.minMovesToSeat(seats1, students1));    // 4
        System.out.println(l.minMovesToSeat(seats2, students2));    // 7
        System.out.println(l.minMovesToSeat(seats3, students3));    // 4
    }

    // 내 풀이 : 3ms
    // 걸린 시간 : 1h 5m
    // 생각보다 엄청 간단하게 풀리는 문제였는데 너무 어렵게 생갹했다...
    // 근데 이 로직이 맞는 이유를 잘 모르겠다. 어떻게 이게 최소 움직임을 보장하지..?
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }

}
