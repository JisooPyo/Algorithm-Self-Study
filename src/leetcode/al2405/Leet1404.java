package leetcode.al2405;

/**
 * Medium
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One
 *
 * Given
 * s: 이진법으로 표현된 정수 문자열
 *
 * Return
 * 다음 규칙을 따르면서 s를 1로 줄여 나가는 스텝 수를 구하라.
 * - 만약 현재 수가 짝수라면 2로 나눈다.
 * - 만약 현재 수가 홀수라면 1을 더한다.
 */
public class Leet1404 {
    public static void main(String[] args) {
        Leet1404 l = new Leet1404();

        System.out.println(l.numSteps("1101"));     // 6
        System.out.println(l.numSteps("10"));       // 1
        System.out.println(l.numSteps("1"));        // 0
        System.out.println(l.numSteps("1111011110000011100000110001011011110010111001010111110001"));        // 85
    }
    // 내 풀이(3ms)
    // 처음에 10진법으로 변환해서 풀었는데 s.length 가 최대 500이었다..
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        while (!sb.toString().equals("1")) {
            int lastIndex = sb.length() - 1;
            if (sb.charAt(lastIndex) == '0') {
                sb.deleteCharAt(lastIndex);
            } else {
                plusOne(sb);
            }
            count++;
        }
        return count;
    }

    private void plusOne(StringBuilder sb) {
        int index = sb.length() - 1;
        sb.setCharAt(index, '0');
        int carry = 1;
        index--;
        while (index >= 0 && carry == 1) {
            if (sb.charAt(index) == '1') {
                sb.setCharAt(index, '0');
                index--;
            } else {
                sb.setCharAt(index, '1');
                carry = 0;
            }
        }
        if (index == -1 & carry == 1) {
            sb.insert(0, '1');
        }
    }

    // 다른 사람의 풀이(1ms)
    // 이진법의 자리를 줄이면서 >> for문 첫번째 줄 res++
    // 홀수인 경우 올리는 경우의 수를 하나씩 더하는 >> if문
    // 방법으로 구현하였다. 여기서 carry는 더했을 때 올라가는 올림자리를 뜻한다.
    // 어렵따.. ;ㅅ;
    public int numStepsOther(String s) {
        int res = 0, carry = 0;

        for(int i = s.length() - 1; i> 0; i--){
            res++;
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                res ++;
            }

        }

        return res + carry;
    }
}
