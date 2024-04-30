package leetcode.al2404;

import java.util.HashMap;
import java.util.Map;

/**
 * 1915. Number Of Wonderful Substrings
 *
 * wonderful string: 최대 하나의 문자가 홀수번 나타나는 문자열
 * ex. ccjjc, abab -> wonderful, ab -> not wonderful
 *
 * Given
 * a부터 j까지 첫번째 10개 영소문자로 이루어져 있는 문자열 word
 *
 * return
 * word에서 비지 않은 wonderful한 부분문자열의 개수
 * 만약 같은 부분문자열이 word내에서 여러번 보이면 각각 개수를 셀 것
 *
 */
public class Leet1915_x {
    public static void main(String[] args) {
        Leet1915_x l = new Leet1915_x();
        System.out.println(l.wonderfulSubstrings("aba"));   // 4
        System.out.println(l.wonderfulSubstrings("aabb"));  // 9
    }

    public long wonderfulSubstrings(String word) {
        // wonderful substring의 수를 저장하는 데 사용된다.
        long wonderful = 0;
        // 10비트의 2진수. 표현할 수 있는 모든 경우의 수
        final int TOTAL = 1 << 10;
        // 모든 이전에 나타난 substring 패턴의 수를 저장
        long[] map = new long[TOTAL];
        map[0] = 1L;
        // 현재까지의 substring 패턴
        int value = 0;
        int length = word.length();
        // map 배열에 각 패턴의 등장 횟수를 누적하여 저장
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            value ^= (1 << index);
            map[value]++;
        }
        // 패턴 고려하여 wonderful substring 수 계산
        for (int i = 0; i < TOTAL; i++) {
            wonderful += map[i] * (map[i] - 1) / 2;
            for (int j = 1; j <= i; j <<= 1) {
                if ((i & j) == j)
                    wonderful += map[i] * map[i - j];
            }
        }
        return wonderful;
    }
}
