package programmers.test2401;

import java.util.Arrays;

public class BitFunction {
    public static void main(String[] args) {
        BitFunction b = new BitFunction();
        long[] numbers1 = {3, 5, 7, 9, 11, 13, 15};
        System.out.println(Arrays.toString(b.solution(numbers1)));
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long l = numbers[i];
            long val = findValue(l);
            answer[i] = val;
        }
        return answer;
    }

    private long findValue(long l) {
        if (l % 2 == 0) {
            return l + 1;
        }
        int count = 0;
        while (l % 2 != 0) {
            l >>= 1;
            count++;
        }

        return (l + 1) * (long) Math.pow(2, count) + ((long) (Math.pow(2, count) - 1) >> 1);
    }
}
