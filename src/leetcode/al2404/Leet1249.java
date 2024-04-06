package leetcode.al2404;

import java.util.Stack;

public class Leet1249 {
    public static void main(String[] args) {
        Leet1249 l = new Leet1249();
        System.out.println(l.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(l.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(l.minRemoveToMakeValid("))(("));

        System.out.println(l.minRemoveToMakeValidOther("lee(t(c)o)de)"));
        System.out.println(l.minRemoveToMakeValidOther("a)b(c)d"));
        System.out.println(l.minRemoveToMakeValidOther("))(("));
    }

    // 내 풀이
    public String minRemoveToMakeValid(String s) {
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(new int[]{i, '('});
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek()[1] == '(') {
                    stack.pop();
                } else {
                    stack.add(new int[]{i, ')'});
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);
        while (!stack.isEmpty()) {
            int[] peek = stack.peek();
            sb.deleteCharAt(peek[0]);
            stack.pop();
        }

        return sb.toString();
    }

    // 다른 사람의 풀이
    // s.toCharArray 를 정방향으로 돌면서 제거해야 할 ')'를 찾고 '*로 표시한다.
    //       "       를 역방향으로 돌면서 제거해야 할 '('를 찾고 '*'로 표시한다.
    // *로 표시된 부분은 건너뛰고 한 자리씩 앞으로 옮긴다.
    // 옮긴 만큼 substring 해주고 return한다.
    // 괄호 문제는 보통 Stack으로 풀게 되는데 Stack을 쓰지 않은 풀이라 인상적이었다.
    public String minRemoveToMakeValidOther(String s) {
        char[] arr = s.toCharArray();
        int open = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')
                open++;
            else if (arr[i] == ')') {
                if (open == 0)
                    arr[i] = '*';
                else
                    open--;
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (open > 0 && arr[i] == '(') {
                arr[i] = '*';
                open--;
            }
        }

        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*')
                arr[p++] = arr[i];
        }

        return new String(arr).substring(0, p);
    }
}
