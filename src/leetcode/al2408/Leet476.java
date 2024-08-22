package leetcode.al2408;

/**
 * Easy
 * 476. Number Complement
 *
 * 정수의 보수는 정수를 이진수로 표현했을 때, 모든 0은 1로, 모든 1은 0으로 바꾸어 얻을 수 있는 정수이다.
 *
 * 예를 들어, 정수 5는 이진수로 표현하면 101이고, 이것의 보수는 010이므로 정수 2가 된다.
 *
 * 정수 num이 주어질 때, 보수를 구하여라.
 */
public class Leet476 {
    public static void main(String[] args) {
        Leet476 l = new Leet476();

        System.out.println(l.findComplement(5));    // 2
        System.out.println(l.findComplement(1));    // 0
    }

    // 내 풀이: 0ms
    public int findComplement(int num) {
        int answer = 0;
        int multiplier = 1;
        while (num != 0) {
            if (num % 2 == 0) {
                answer += multiplier;
            }
            multiplier *= 2;
            num = num / 2;
        }
        return answer;
    }
}
