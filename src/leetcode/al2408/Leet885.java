package leetcode.al2408;

import java.util.Arrays;

/**
 * Medium
 * 885. Spiral Matrix III
 *
 * rows X cols 그리드의 칸 (rStart, cStart) 에서 동쪽으로 출발합니다.
 * 북서쪽 코너는 그리드의 첫 번째 row 와 column 이 만나는 곳입니다.
 * 남동쪽 코너는 그리드의 마지막 row 와 column 이 만나는 곳입니다.
 *
 * 당신은 grid 에서 둥글게 시계방향으로 걸어갑니다.
 * 그리드의 경계에서 벗어날 때마다, grid 바깥에서도 계속해서 걸어나갑니다.
 * 결국 , 우리는 grid의 모든 rows * cols 공간에 도달합니다.
 * 당신이 방문하는 순서대로 그리드의 위치를 나타내는 좌표의 배열을 반환하세요.
 */
public class Leet885 {
    public static void main(String[] args) {
        Leet885 leet885 = new Leet885();
        // [[0,0],[0,1],[0,2],[0,3]]
        System.out.println(Arrays.deepToString(leet885.spiralMatrixIII(1, 4, 0, 0)));
        /*
        [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],
        [3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],
        [4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
         */
        System.out.println(Arrays.deepToString(leet885.spiralMatrixIII(5, 6, 1, 4)));
    }

    // 내 풀이: 3ms
    int rows;
    int cols;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        this.rows = rows;
        this.cols = cols;
        int count = 1;
        // +1 +1 +2  +2 +3 +3
        int move = 1;
        res[0][0] = rStart;
        res[0][1] = cStart;
        int index = 1;
        while (count < rows * cols) {
            for (int i = 0; i < move; i++) {
                cStart++;
                if (isInBoundary(rStart, cStart)) {
                    res[index][0] = rStart;
                    res[index][1] = cStart;
                    index++;
                    count++;
                }
            }
            if (count == rows * cols) {
                break;
            }
            for (int i = 0; i < move; i++) {
                rStart++;
                if (isInBoundary(rStart, cStart)) {
                    res[index][0] = rStart;
                    res[index][1] = cStart;
                    index++;
                    count++;
                }
            }
            if (count == rows * cols) {
                break;
            }
            move++;
            for (int i = 0; i < move; i++) {
                cStart--;
                if (isInBoundary(rStart, cStart)) {
                    res[index][0] = rStart;
                    res[index][1] = cStart;
                    index++;
                    count++;
                }
            }
            if (count == rows * cols) {
                break;
            }
            for (int i = 0; i < move; i++) {
                rStart--;
                if (isInBoundary(rStart, cStart)) {
                    res[index][0] = rStart;
                    res[index][1] = cStart;
                    index++;
                    count++;
                }
            }
            move++;
        }
        return res;
    }

    private boolean isInBoundary(int cx, int cy) {
        return 0 <= cx && cx < rows && 0 <= cy && cy < cols;
    }
}
