package leetcode.al2405;

/**
 * 861. Score After Flipping Matrix
 *
 * Given
 * grid : m * n 이진 배열
 *
 * 1 move : 한 row나 column을 골라 해당 row나 column에 있는 값을 바꾸는 것(즉, 모든 0과 1을 1과 0으로)
 *
 * 배열의 모든 row는 2진수로 읽을 수 있다. 배열의 점수는 이 이진수들의 합이다.
 *
 * Return
 * 몇 번을 움직이든(0번 포함) 가능한 가장 높은 점수
 */
public class Leet861 {
    public static void main(String[] args) {
        Leet861 l = new Leet861();

        int[][] grid1 = {
            {0, 0, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 0}
        };
        int[][] grid2 = {{0}};
        int[][] grid3 = {
            {0, 1, 1},
            {1, 1, 1},
            {0, 1, 0}
        };
        int[][] grid4 = {
            {0, 1},
            {0, 1},
            {0, 1},
            {0, 0}
        };

        System.out.println(l.matrixScore(grid1));
        System.out.println(l.matrixScore(grid2));
        System.out.println(l.matrixScore(grid3));
        System.out.println(l.matrixScore(grid4));
    }

    int[][] score;

    public int matrixScore(int[][] grid) {
        score = grid;
        // row를 확인해서 첫 원소가 0이면 무조건 뒤집는 게 이득이다.
        // ex. 0111 < 1000
        for (int i = 0; i < grid.length; i++) {
            if (score[i][0] == 0) {
                changeRow(i);
            }
        }

        // column에서는 1의 개수를 확인하여 전체의 반보다 적으면 뒤집는 게 이득이다.
        for (int i = 0; i < grid[0].length; i++) {
            if (isOneLessThanZero(i)) {
                changeColumn(i);
            }
        }

        // score를 return한다.
        return getScore();
    }

    private boolean isOneLessThanZero(int column) {
        int count = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i][column] == 1) {
                count++;
            }
        }
        return count < (score.length + 1) / 2;
    }

    private void changeRow(int row) {
        for (int i = 0; i < score[0].length; i++) {
            if (score[row][i] == 0) {
                score[row][i] = 1;
            } else {
                score[row][i] = 0;
            }
        }
    }

    private void changeColumn(int column) {
        for (int i = 0; i < score.length; i++) {
            if (score[i][column] == 0) {
                score[i][column] = 1;
            } else {
                score[i][column] = 0;
            }
        }
    }

    private int getScore() {
        int max = 0;
        int l = score[0].length - 1;
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[0].length; j++) {
                if (score[i][j] == 1) {
                    max += (int)Math.pow(2, l - j);
                }
            }
        }
        return max;
    }
}
