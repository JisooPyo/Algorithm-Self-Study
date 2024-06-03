package leetcode.al2406;

/**
 * Medium
 * 2486. Append Characters to String to Make Subsequence
 *
 * Given
 * s, t: 영소문자로 이루어져있는 문자열
 *
 * Return
 * t가 s의 subsequence 가 되기 위해 덧붙여야 할 문자의 최소 수를 구하라.
 *
 * Note
 * subsequence 는 다른 문자열에서 남은 문자의 순서 변화없이 몇 글자를 삭제하여 얻어지는 문자열이다.
 */
public class Leet2486 {
    public static void main(String[] args) {
        Leet2486 l = new Leet2486();
        System.out.println(l.appendCharacters("coaching", "coding"));   // 4
        System.out.println(l.appendCharacters("abcde", "a"));   // 0
        System.out.println(l.appendCharacters("z", "abcde"));   // 5
    }

    // 내 풀이 : 8ms
    public int appendCharacters(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        // t의 문자 하나하나를 s의 index를 높여가며 순서대로 찾는다.
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                sIndex++;
            }
        }

        // 없는만큼 붙인다.
        if (tIndex == t.length()) {
            return 0;
        } else {
            return t.length() - tIndex;
        }
    }

    // 다른 사람의 풀이
    // 내가 while문으로 푼 것을 for문으로 풀었는데 좀 더 빠르다.
    public int appendCharactersOther(String s, String t) {
        // 예외처리! 내 풀이에서 이 코드를 넣고 8ms -> 6ms로 시간이 감소함.
        if (s.equals(t))
            return 0;
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();

        // j: 더할 필요 없는 문자의 수
        int i = 0, j = 0;
        int m = chS.length, n = chT.length;
        for (; i < m; i++) {
            if (chS[i] == chT[j])
                j++;

            if (j == n)
                return 0;
        }
        return n - j;

    }
}
