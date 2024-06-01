package leetcode.al2406;

/**
 * Easy
 * 3110. Score of a String
 *
 * Given
 * s: 문자열
 * 문자열의 점수는 인접한 문자들의 아스키 코드 값 차이의 절대값의 합으로 나타낸다.
 *
 * Return
 * s의 점수를 구하라.
 */
public class Leet3110 {
    public static void main(String[] args) {
        Leet3110 l = new Leet3110();
        System.out.println(l.scoreOfString("hello"));
        System.out.println(l.scoreOfString("zaz"));
    }

    // 내 풀이
    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            res += Math.abs(s.charAt(i + 1) - s.charAt(i));
        }
        return res;
    }
}
