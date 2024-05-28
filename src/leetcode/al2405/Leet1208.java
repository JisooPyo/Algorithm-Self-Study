package leetcode.al2405;

/**
 * Medium
 * 1208. Get Equal Substrings Within Budget
 *
 * Given
 * s, t : 같은 길이를 가지는 두 문자열
 * maxCost : 정수
 *
 * s에서 t로 문자열을 바꾸려고 한다. s의 i번째 문자에서 t의 i번째 문자로 바꾸는 비용은 |s[i] - t[i]|이다.
 * (즉, 문자의 아스키코드 값 차이의 절대값이다.)
 *
 * Return
 * maxCost보다 적거나 같은 비용으로 t의 부분문자열로 바꿀 수 있는 s의 부분문자열의 최대 길이를 구하라.
 * 만약 바꿀수 있는 부분문자열이 없다면 0을 반환하라.
 */
public class Leet1208 {
    public static void main(String[] args) {
        Leet1208 l = new Leet1208();

        String s1 = "abcd", t1 = "bcdf";
        String s2 = "abcd", t2 = "cdef";
        String s3 = "abcd", t3 = "acde";
        String s4 = "krpgjbjjznpzdfy", t4 = "nxargkbydxmsgby";

        System.out.println(l.equalSubstring(s1, t1, 3));    // 3
        System.out.println(l.equalSubstring(s2, t2, 3));    // 1
        System.out.println(l.equalSubstring(s3, t3, 0));    // 1
        System.out.println(l.equalSubstring(s4, t4, 14));   // 4
    }

    // 내 풀이: 6ms
    // sliding window를 이용하여 풀었다.
    public int equalSubstring(String s, String t, int maxCost) {
        // 비용 구하기
        int[] costs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        // 시작점 찾기
        int index = 0;
        while (index < costs.length) {
            if (costs[index] <= maxCost) {
                break;
            }
            index++;
        }
        if (index == costs.length) {
            return 0;
        }
        if (index == costs.length - 1) {
            return 1;
        }
        int left = index;
        int right = index + 1;

        // substring 최대 길이 찾기
        int maxLength = 1;
        int curCost = costs[left];
        while (right < costs.length) {
            if (costs[right] > maxCost) {
                right++;
                left = right;
                curCost = 0;
                continue;
            }
            if (curCost + costs[right] <= maxCost) {
                curCost += costs[right];
                maxLength = Math.max(right - left + 1, maxLength);
                right++;
            } else {
                curCost -= costs[left];
                left++;
            }
        }
        return maxLength;
    }
}
