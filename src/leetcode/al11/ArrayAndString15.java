// Pascal's Triangle 2
package leetcode.al11;

import java.util.ArrayList;
import java.util.List;

public class ArrayAndString15 {
    public static void main(String[] args) {
        ArrayAndString15 aas15 = new ArrayAndString15();
        System.out.println(aas15.getRow(3));
        System.out.println(aas15.getRow(0));
        System.out.println(aas15.getRow(1));
        System.out.println(aas15.calculate_nCr(33, 16));
    }

    /**
     * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
     * <p>
     * nCr 구현하여 구현
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(calculate_nCr(rowIndex, i));
        }
        return result;
    }

    public int calculate_nCr(int n1, int r1) {
        int min = Math.min(n1 - r1, r1);
        long answer = 1;
        int multiple = n1;
        int division = 1;
        while (multiple >= n1 - min + 1 && division <= min) {
            if (multiple == n1 - min) {
                answer /= division;
                division++;
                continue;
            }
            answer *= multiple;
            multiple--;
            if (answer % division == 0) {
                answer /= division;
                division++;
            }
        }
        return (int) answer;
    }
}

/**
 * 1
 * 1   1
 * 1    2   1       2C0~2C2
 * 1    3     3    1   3C0~3C3
 * 1   4     6    4    1    4C0~4C4
 * 1   5   10    10    5   1      5C0~5C5
 * 1   6   15   20    15   6   1
 * 1   7    21   35   35    21  7   1
 * <p>
 * 1,2,3,4,5,6,7            1,1,1,1,1,1
 * 1,3,6,10,15,21      2 3 4,5,6
 * 1,4,10,20,35        3,6,10,15
 * 1,5,15,35            4,10,20
 */
