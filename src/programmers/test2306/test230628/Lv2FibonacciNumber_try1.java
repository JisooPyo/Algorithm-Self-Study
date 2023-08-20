package programmers.test2306.test230628;

public class Lv2FibonacciNumber_try1 {
    public static void main(String[] args) {
        Lv2FibonacciNumber_try1 lv = new Lv2FibonacciNumber_try1();
        System.out.println(lv.fibonacci(0));
        System.out.println(lv.fibonacci(1));
        System.out.println(lv.fibonacci(2));
        System.out.println(lv.fibonacci(3));
        System.out.println(lv.fibonacci(4));
        System.out.println(lv.fibonacci(5));
        System.out.println(lv.fibonacci(6));
    }

    public int solution(int n) {
        return fibonacci(n) % 1234567;
    }

    public int fibonacci(int nth) {
        switch (nth) {
            case 0:
                return 0;
            case 1:
                return 1;
        }
        return fibonacci(nth - 1) + fibonacci(nth - 2);
    }
}
/*
정확성  테스트
테스트 1 〉통과 (0.03ms, 73.2MB)
테스트 2 〉통과 (0.07ms, 76.4MB)
테스트 3 〉통과 (0.14ms, 75.3MB)
테스트 4 〉통과 (0.04ms, 74.2MB)
테스트 5 〉통과 (0.08ms, 75.4MB)
테스트 6 〉통과 (0.16ms, 74.6MB)
테스트 7 〉실패 (시간 초과)
테스트 8 〉실패 (시간 초과)
테스트 9 〉실패 (시간 초과)
테스트 10 〉실패 (시간 초과)
테스트 11 〉실패 (시간 초과)
테스트 12 〉실패 (시간 초과)
테스트 13 〉실패 (시간 초과)
테스트 14 〉실패 (시간 초과)
 */
