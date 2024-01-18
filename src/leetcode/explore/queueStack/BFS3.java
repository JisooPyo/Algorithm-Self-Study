// Perfect SquaresS
package leetcode.explore.queueStack;

import java.util.Arrays;

public class BFS3 {
    public static void main(String[] args) {
        BFS3 b = new BFS3();
//        b.problem1();
//        b.problem2();
//        b.problem3();
        b.problem4();
    }

    private void problem4() {
        System.out.println(numSquares(329));
    }

    private void problem3() {
        System.out.println(numSquares(16));
    }

    private void problem2() {
        System.out.println(numSquares(13)); // 2
    }

    private void problem1() {
        System.out.println(numSquares(12)); // 3
    }

    // 다른 사람 풀이. dp로 풀어도 쉽게 풀린다.
    public int numSquares(int n) {
        int[] memory = new int[n + 1];
        Arrays.fill(memory, n);
        memory[0] = 0;
        memory[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                memory[i] = Math.min(memory[i], memory[i - j * j] + 1);
            }
        }

        return memory[n];
    }

    public int numSquares2(int n) {
        int maxSquare = findMaxSquare(n);
        System.out.println("maxSquare = " + maxSquare);
        int count = Integer.MAX_VALUE;
        count = rec(maxSquare, n, count, 0);
        return count;
    }

    private int rec(int square, int target, int num, int count) {
        if (num < count) {
            return num;
        }
        for (int i = square; i >= 1; i--) {
            if (i * i > target) {
                continue;
            }
            if (i * i == target) {
                count++;
                num = Math.min(num, count);
                break;
            }
            if (i * i < target) {
                num = Math.min(num, rec(i, target - i * i, num, count + 1));
            }
        }
        return num;
    }

    private int findMaxSquare(int n) {
        int square = 1;
        while (square * square <= n) {
            square++;
        }
        return square - 1;
    }
}
