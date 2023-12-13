package leetcode.explore.arrayAndString;

import java.util.Arrays;

public class ArrayAndString3 {

    public static void main(String[] args) {
        ArrayAndString3 aas3 = new ArrayAndString3();

        int[] digits1 = {1, 2, 3};
        int[] digits2 = {4, 3, 2, 1};
        int[] digits3 = {9};
        int[] digits4 = {4, 3, 2, 9};
        int[] digits5 = {9, 9};

        System.out.println(Arrays.toString(aas3.plusOne(digits1)));
        System.out.println(Arrays.toString(aas3.plusOne(digits2)));
        System.out.println(Arrays.toString(aas3.plusOne(digits3)));
        System.out.println(Arrays.toString(aas3.plusOne(digits4)));
        System.out.println(Arrays.toString(aas3.plusOne(digits5)));
    }

    public int[] plusOne(int[] digits) {
        int nineCount = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 9) {
                nineCount++;
            }
        }
        if (nineCount == digits.length) {
            int[] answer = new int[digits.length + 1];
            answer[0] = 1;
            for (int i = 1; i < answer.length; i++) {
                answer[i] = 0;
            }
            return answer;
        }
        int index = digits.length - 1;
        while (index >= 0) {
            digits[index]++;
            if (digits[index] == 10) {
                digits[index] = 0;
                index--;
            } else {
                break;
            }
        }
        return digits;
    }
}
