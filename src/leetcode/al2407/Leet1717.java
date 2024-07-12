package leetcode.al2407;

import java.util.Stack;

/**
 * Medium
 * 1717. Maximum Score From Removing Substrings
 *
 * 문자열 s와 x, y 두 정수가 주어진다. 아래 두 가지 연산을 몇 번이든 수행할 수 있다.
 *   - 부분문자열 "ab"를 삭제하고 x 점을 얻는다.
 *     - 예를 들어, "cabxbae"에서 "ab"를 제거하면 "cxbae"가 된다.
 *   - 부분문자열 "ba"를 지우고 y 점을 얻는다.
 *      - 예를 들어, "cabxbae" 에서 "ba"를 지우면 "cabxe"가 된다.
 * s에서 위의 연산을 적용하고 난 후 최대 점수를 구하라.
 */
public class Leet1717 {
    public static void main(String[] args) {
        Leet1717 l = new Leet1717();
        System.out.println(l.maximumGain("cdbcbbaaabab", 4, 5));    // 19
        System.out.println(l.maximumGain("aabbaaxybbaabb", 5, 4));    // 20
    }

    // 내 풀이 : 144ms
    // 큰 점수 먼저 계산, 작은 점수 나중에 계산
    // Stack 2개 이용하여 계산
    public int maximumGain(String s, int x, int y) {
        char first = x < y ? 'b' : 'a';
        char second = x < y ? 'a' : 'b';
        int score = 0;

        // 큰 점수 먼저 계산
        int bigger = Math.max(x, y);
        int smaller = Math.min(x, y);
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == second) {
                if (!stack.isEmpty() && stack.peek() == first) {
                    stack.pop();
                    score += bigger;
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }

        if (stack.isEmpty()) {
            return score;
        }

        // 작은 점수 계산
        Stack<Character> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            if (stack2.isEmpty()) {
                stack2.push(stack.pop());
                continue;
            }
            if (stack2.peek() == first && stack.peek() == second) {
                stack2.pop();
                stack.pop();
                score += smaller;
                continue;
            }
            stack2.push(stack.pop());
        }
        return score;
    }

    // 다른 사람의 풀이 : 20ms
    public int maximumGainOther(String s, int x, int y) {
        int aCount = 0;
        int bCount = 0;
        int lesser = Math.min(x, y);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 'b') {  // 캐릭터가 'a'나 'b'가 아니면
                // Math.min(aCount, bCount) > a, b 중 덜 나온 것.
                result += Math.min(aCount, bCount) * lesser;
                aCount = 0;
                bCount = 0;
            } else if (c == 'a') {  // 캐릭터가 'a'일 때
                if (x < y && bCount > 0) {
                    bCount--;
                    result += y;
                } else {
                    aCount++;
                }
            } else {
                if (x > y && aCount > 0) {
                    aCount--;
                    result += x;
                } else {
                    bCount++;
                }
            }
        }

        result += Math.min(aCount, bCount) * lesser;

        return result;
    }
}
