package programmers.test2401;

public class P12931 {
    public static void main(String[] args) {
        P12931 p = new P12931();
        System.out.println(p.solution(123));    // 6
        System.out.println(p.solution(987));    // 24
    }

    public int solution(int n) {
        int answer = 0;
        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }
}
