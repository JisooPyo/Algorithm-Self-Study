package leetcode.explore.recursion;

public class Rec9 {
    public static void main(String[] args) {
        Rec9 r = new Rec9();
        // System.out.println(r.myPow(-2.00000, 2));
        System.out.println(r.myPow(2.00000, 12));
    }

    // 다른 사람의 풀이 - 애초에 반으로 나눠서 풀면 되는 것..!!
    public double myPow(double x, int n) {
        return half(x, (long)n);
    }

    private double half(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return half(1 / x, -n);
        if (n % 2 == 1)
            return x * half(x * x, (n - 1) / 2);
        else
            return half(x * x, n / 2);
    }

    // 내 풀이
    public double myPow2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long number = n;
        if (n < 0) {
            x = 1.0 / x;
            number *= -1;
        }
        if (x == 1.0) {
            return 1.0;
        }
        if (x == -1.0) {
            if (number % 2 == 0) {
                return 1.0;
            } else {
                return -1.0;
            }
        }
        long[] record = restAndNumOfTwo(number);
        double answer = x;
        int count = 1;
        while (count < record[0]) {
            if (0 < answer && answer < 0.000001) {
                return 0.0;
            }
            answer *= x;
            count++;
        }
        count = 0;
        while (count < record[1]) {
            answer *= answer;
            count++;
        }
        return answer;
    }

    private long[] restAndNumOfTwo(long n) {
        long[] answer = new long[2];
        int count = 0;
        while (n % 2 == 0) {
            n = n / 2;
            answer[1]++;
        }
        answer[0] = n;
        return answer;
    }

}
