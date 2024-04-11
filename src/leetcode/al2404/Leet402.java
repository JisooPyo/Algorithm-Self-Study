package leetcode.al2404;

import java.util.Stack;

public class Leet402 {
    public static void main(String[] args) {
        Leet402 l = new Leet402();

        System.out.println(l.removeKdigits("1432219", 3));
        System.out.println(l.removeKdigits("10200", 1));
        System.out.println(l.removeKdigits("10", 2));
        System.out.println(l.removeKdigits("10", 1));
    }

    // 내 풀이
    // Time Limit Exceeded
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int count = num.length() - k;
        int start = 0;
        while (count > 0) {
            int min = Integer.MAX_VALUE;
            for (int i = start; i <= num.length() - count; i++) {
                int digit = num.charAt(i) - '0';
                if (digit < min) {
                    min = digit;
                    start = i + 1;
                }
            }
            count--;
            sb.append(min);
        }

        while (!sb.isEmpty() && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }

    // 다른 사람의 풀이
    // Stack의 peek과 기존 숫자를 순서대로 비교하여 Stack에는 더 작은 숫자를 넣는다.
    // 이 때 pop할 수 있는 수는 k개까지
    public String removeKdigitsOther1(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Remove remaining k digits from the end of the stack
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Construct the resulting string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse(); // Reverse to get the correct order

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Handle edge case where result might be empty
        return sb.length() > 0 ? sb.toString() : "0";
    }

    // 다른 사람의 풀이 2
    // 배열을 Stack처럼 써서 시간을 더 단축시킬 수 있었다.
    public static String removeKdigitsOther2(String num, int k) {
        char[] digits = num.toCharArray();
        if (k == num.length()) {
            return "0";
        }

        char[] stack = new char[digits.length];
        int stackTop = -1;
        int removalCount = k;

        for (int i = 0; i < digits.length; i++) {
            while (removalCount > 0 && stackTop >= 0 && stack[stackTop] > digits[i]) {
                stackTop--;
                removalCount--;
            }
            stackTop++;
            stack[stackTop] = digits[i];
        }

        int nonZeroStart = 0;

        while (stack[nonZeroStart] == '0' && nonZeroStart < digits.length - k - 1) {
            nonZeroStart++;
        }

        return String.valueOf(stack, nonZeroStart, digits.length - k - nonZeroStart);
    }

}
