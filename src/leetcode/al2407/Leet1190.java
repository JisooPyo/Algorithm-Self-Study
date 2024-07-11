package leetcode.al2407;

/**
 * Medium
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 *
 * 영소문자와 괄호가 포함된 문자열이 주어진다.
 * 가장 안에 있는 것부터 시작하여 괄호가 매칭되는 각 쌍의 문자열을 Reverse 하라.
 * 결과물에 괄호가 포함되면 안된다.
 */
public class Leet1190 {

    public static void main(String[] args) {
        Leet1190 leet1190 = new Leet1190();
        System.out.println(leet1190.reverseParentheses("(abcd)"));  // dcba
        System.out.println(leet1190.reverseParentheses("(u(love)i)"));  // iloveu
        System.out.println(leet1190.reverseParentheses("(ed(et(oc))el)"));  // leetcode
        System.out.println(leet1190.reverseParentheses("a(bcdefghijkl(mno)p)q"));  // apmnolkjihgfedcbq
    }

    int i;

    // 내 풀이 : 1ms
    public String reverseParentheses(String s) {
        i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                i++;
                sb.append(rec(s));
            } else if (s.charAt(i) == ')') {
                break;
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    private String rec(String s) {
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                i++;
                String append = rec(s);
                sb.append(append);
            } else if (s.charAt(i) == ')') {
                break;
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.reverse().toString();
    }

    // 다른 사람의 풀이 : 0ms
    int index = 0;

    public String reverseParenthesesOther(String s) {
        char[] ar = s.toCharArray();
        return helper(ar);
    }

    // while문 안에서 return reverse 를 해서 반복 해결된 풀이.
    public String helper(char[] s) {
        StringBuilder sb = new StringBuilder();

        while (index < s.length) {
            if (s[index] == ')') {
                index++;
                return sb.reverse().toString();
            } else if (s[index] == '(') {
                index++;
                String st = helper(s);
                //System.out.println(st);
                sb.append(st);
            } else {
                sb.append(s[index]);
                index++;
            }
        }
        return sb.toString();

    }
}
