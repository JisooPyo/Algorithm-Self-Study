package bookStudy.study2408;

/**
 * 9. 10진수를 2진수로 변환하기
 */
public class Problem9 {
    public static void main(String[] args) {
        Problem9 p = new Problem9();
        System.out.println(p.solution(10)); // 1010
        System.out.println(p.solution(27)); // 11011
        System.out.println(p.solution(12345));  // 11000000111001
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }

    // 스택으로도 풀 수 있고, toBinaryString() API를 이용할 수도 있음.
}
