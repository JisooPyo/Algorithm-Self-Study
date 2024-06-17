package leetcode.al2406;

/**
 Medium
 633. Sum of Square Numbers

 Given
 c : 음수가 아닌 정수

 (a ^ 2) + (b ^ 2) = c가 되는 두 정수 a, b가 있는지 구하여라.
 */
public class Leet633 {
    public static void main(String[] args) {
        Leet633 l = new Leet633();

        System.out.println(l.judgeSquareSum(5));    // true
        System.out.println(l.judgeSquareSum(3));    // false
        System.out.println(l.judgeSquareSum(4));    // true
    }

    // 내 풀이 : 바로 풀었다..! 사실 이렇게 풀면 시간초과 날 줄 알았는데 아니었다..
    // Runtime : 6ms
    // 시간복잡도 : O(root c)
    public boolean judgeSquareSum(int c) {
        if (c <= 1) {
            return true;
        }
        for (int i = 0; i <= Math.sqrt(c / 2.0); i++) {
            int bSquare = c - (i * i);
            int b = (int)Math.sqrt(bSquare);
            if (b * b == bSquare) {
                return true;
            }
        }
        return false;
    }

    // 다른 사람 풀이 : 0ms
    // 시간복잡도 : O(root c)
    // 페르마의 두 제곱수 정리
    //     n이 두 제곱수의 합으로 표현될 수 있는 조건:
    //     만약 n이 두 제곱수의 합으로 표현될 수 있다면, n의 소인수 분해에 있는 모든 소인수 p가 다음 조건을 만족해야 합니다:
    //     p가 4로 나누어 3이 되는 소인수일 경우, p의 지수는 짝수여야 합니다.
    public boolean judgeSquareSumOther(int c) {
        for (int i = 2; i * i <= c; i++) {
            if (c % i == 0) {
                int count = 0;
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }

}
