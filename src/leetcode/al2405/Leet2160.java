package leetcode.al2405;

import java.util.Arrays;

/**
 * 2160. Minimum Sum of Four Digit Number After Splitting Digits
 *
 * Greedy, Easy
 */
public class Leet2160 {
    public static void main(String[] args) {
        Leet2160 l = new Leet2160();

        System.out.println(l.minimumSum(2932));     // 52
        System.out.println(l.minimumSum(4009));     // 13
    }

    public int minimumSum(int num) {
        int[] digits = new int[4];
        int index = 0;
        while (num > 0) {
            digits[index++] = num % 10;
            num /= 10;
        }
        Arrays.sort(digits);

        return (digits[0] + digits[1]) * 10 + digits[2] + digits[3];
    }
}
