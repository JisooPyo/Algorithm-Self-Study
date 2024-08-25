package leetcode.al2408;

import java.util.ArrayList;
import java.util.List;

/**
 * 592. Fraction Addition and Subtraction
 *
 * 분수의 덧셈과 뺄셈의 식이 표현된 expression 문자열이 주어집니다.
 * 계산 결과를 문자열로 반환하세요.
 *
 * 최종 결과는 약분할 수 없는 분수여야 합니다.
 * 만약 최종 결과가 정수라면 분모를 1로 가지는 분수의 형식으로 변환하세요.
 * 예를 들어, 2라면 2/1로 변환하세요.
 */
public class Leet592 {
    public static void main(String[] args) {
        Leet592 l = new Leet592();

        // System.out.println(l.fractionAddition("-1/2+1/2"));
        // System.out.println(l.fractionAddition("-1/2+1/2+1/3"));
        // System.out.println(l.fractionAddition("1/3-1/2"));
        System.out.println(l.fractionAddition("-1/4-4/5-1/4"));
    }

    // 내 풀이: 9ms
    public String fractionAddition(String expression) {
        // 분모리스트 구하기
        List<Integer> denominators = getDenominators(expression);

        System.out.println("denominators = " + denominators);

        // 최소공배수 구하기
        int lcm = getLcm(denominators);

        System.out.println("lcm = " + lcm);

        // 최소공배수로 바꿔서 계산하기
        long numerator = 0;
        int denominator = lcm;
        int sign = expression.charAt(0) == '-' ? -1 : 1;
        int i = expression.charAt(0) == '-' ? 1 : 0;
        StringBuilder tempNumerator = new StringBuilder();
        StringBuilder tempDenominator = new StringBuilder();
        boolean isNumerator = true;
        for (; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                int tempDe = Integer.parseInt(tempDenominator.toString());
                int tempNum = Integer.parseInt(tempNumerator.toString());
                numerator += (lcm / tempDe) * sign * tempNum;
                tempNumerator = new StringBuilder();
                tempDenominator = new StringBuilder();
                sign = expression.charAt(i) == '-' ? -1 : 1;
                isNumerator = true;
                continue;
            } else if (expression.charAt(i) == '/') {
                isNumerator = false;
                continue;
            }
            if (isNumerator) {
                tempNumerator.append(expression.charAt(i));
            } else {
                tempDenominator.append(expression.charAt(i));
            }
        }
        int tempDe = Integer.parseInt(tempDenominator.toString());
        int tempNum = Integer.parseInt(tempNumerator.toString());
        numerator += (lcm / tempDe) * sign * tempNum;

        // 약분하기
        if (numerator % denominator != 0) {
            int gcd = 1;
            for (int j = 2; j <= Math.min(Math.abs(numerator), denominator); j++) {
                if (numerator % j == 0 && denominator % j == 0) {
                    gcd = j;
                }
            }
            numerator /= gcd;
            denominator /= gcd;
        } else {
            numerator /= denominator;
            denominator = 1;
        }

        // 값 반환하기
        StringBuilder answer = new StringBuilder();
        answer.append(numerator);
        answer.append('/');
        answer.append(denominator);
        return answer.toString();
    }

    private int getLcm(List<Integer> denominators) {
        // 최소공배수
        int lcm = denominators.get(0);
        for (int i = 1; i < denominators.size(); i++) {
            int cur = denominators.get(i);
            if (cur == lcm) {
                continue;
            }
            int gcd = 1;
            for (int j = 2; j <= Math.min(lcm, cur); j++) {
                if (cur % j == 0 && lcm % j == 0) {
                    gcd = j;
                }
            }
            lcm = cur * lcm / gcd;
        }
        return lcm;
    }

    private List<Integer> getDenominators(String expression) {
        // 분모 리스트
        List<Integer> denominators = new ArrayList<>();

        // 표현식 돌면서 분모 리스트에 분모 추가
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (
            int i = expression.charAt(0) == '-' || expression.charAt(0) == '+' ? 1 : 0;
            i < expression.length();
            i++
        ) {
            char ch = expression.charAt(i);
            if (ch == '/') {
                start = true;
                continue;
            }
            if (ch == '+' || ch == '-') {
                denominators.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
                start = false;
                continue;
            }
            if (start) {
                sb.append(ch);
            }
        }
        denominators.add(Integer.parseInt(sb.toString()));
        return denominators;
    }
}
