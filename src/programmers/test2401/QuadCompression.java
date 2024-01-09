package programmers.test2401;

import java.util.Arrays;

public class QuadCompression {
    public static void main(String[] args) {
        QuadCompression q = new QuadCompression();
        int[][] arr1 = {
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        int[][] arr2 = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(q.solution(arr1)));
        System.out.println(Arrays.toString(q.solution(arr2)));
    }

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        if (allComposedOfOne(arr, 0, arr.length - 1, 0, arr.length - 1)) {
            answer[1]++;
        } else if (allComposedOfZero(arr, 0, arr.length - 1, 0, arr.length - 1)) {
            answer[0]++;
        } else {
            compress(answer, arr, 0, arr.length - 1, 0, arr.length - 1);
        }
        return answer;
    }

    private void compress(int[] answer, int[][] arr, int x1, int x2, int y1, int y2) {
        if (x2 - x1 == 1) {
            plus(answer, arr, x1, x2, y1, y2);
            return;
        }
        int m1 = (x2 - x1 + 1) / 2 + x1;
        int m2 = (y2 - y1 + 1) / 2 + y1;

        if (allComposedOfOne(arr, x1, m1 - 1, y1, m2 - 1)) {
            answer[1]++;
        } else if (allComposedOfZero(arr, x1, m1 - 1, y1, m2 - 1)) {
            answer[0]++;
        } else {
            compress(answer, arr, x1, m1 - 1, y1, m2 - 1);
        }

        if (allComposedOfOne(arr, x1, m1 - 1, m2, y2)) {
            answer[1]++;
        } else if (allComposedOfZero(arr, x1, m1 - 1, m2, y2)) {
            answer[0]++;
        } else {
            compress(answer, arr, x1, m1 - 1, m2, y2);
        }

        if (allComposedOfOne(arr, m1, x2, y1, m2 - 1)) {
            answer[1]++;
        } else if (allComposedOfZero(arr, m1, x2, y1, m2 - 1)) {
            answer[0]++;
        } else {
            compress(answer, arr, m1, x2, y1, m2 - 1);
        }

        if (allComposedOfOne(arr, m1, x2, m2, y2)) {
            answer[1]++;
        } else if (allComposedOfZero(arr, m1, x2, m2, y2)) {
            answer[0]++;
        } else {
            compress(answer, arr, m1, x2, m2, y2);
        }
    }

    private void plus(int[] answer, int[][] arr, int x1, int x2, int y1, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                answer[arr[i][j]]++;
            }
        }
    }

    public boolean allComposedOfOne(int[][] arr, int x1, int x2, int y1, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (arr[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean allComposedOfZero(int[][] arr, int x1, int x2, int y1, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
