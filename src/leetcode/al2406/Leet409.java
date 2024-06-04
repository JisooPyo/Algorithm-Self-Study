package leetcode.al2406;

/**
 * Easy
 * 409. Longest Palindrome
 *
 * Given
 * s: 영소문자와 영대문자로 이루어져 있는 문자열
 *
 * Return
 * s로 만들 수 있는 가장 긴 팰린드롬의 길이를 구하라.
 *
 * Note.
 * 글자들은 영소문자, 영대문자 구별이 있고, "Aa"는 팰린드롬이 아니다.
 */
public class Leet409 {
    public static void main(String[] args) {
        Leet409 l = new Leet409();
        System.out.println(l.longestPalindrome("abccccdd"));    // 7
        System.out.println(l.longestPalindrome("a"));       // 1
        System.out.println(l.longestPalindrome("AAAAAA"));       //
    }

    // 내 풀이
    public int longestPalindrome(String s) {
        boolean[] isOdd = new boolean[52];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                int index = ch - 'a';
                isOdd[index] = !isOdd[index];
            } else {
                int index = ch - 'A' + 26;
                isOdd[index] = !isOdd[index];
            }
        }

        int odd = 0;
        for (int i = 0; i < isOdd.length; i++) {
            if (isOdd[i]) {
                odd++;
            }
        }
        int len = s.length();
        if (odd >= 1) {
            len -= odd - 1;
        }
        return len;
    }
}
