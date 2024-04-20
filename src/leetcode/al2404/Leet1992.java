package leetcode.al2404;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// given: int[][] land
// 1: 농장
// 0: 숲
// 농장은 직사각형의 모양으로 이루어져 있으며, 한 농장을 그룹이라고 칭한다. 그룹끼리는 인접하지 않는다.
// 한 그룹은 상단 왼쪽의 좌표 (r1, c1)와 하단 오른쪽의 좌표(r2, c2)를 길이 4의 배열 [r1, c1, r2, c2]로 나타낸다.

// land에 있는 그룹들을 나타내는 길이 4의 배열들을 포함하는 2D 배열을 반환하라.
// 만약 농장이 없다면 빈 배열을 반환하라.
// 그룹의 순서는 상관없다.
public class Leet1992 {
    public static void main(String[] args) {
        Leet1992 l = new Leet1992();

        int[][] land1 = {
            {1, 0, 0},
            {0, 1, 1},
            {0, 1, 1}
        };
        int[][] land2 = {{1, 1}, {1, 1}};
        int[][] land3 = {{0}};
        int[][] land4 = {
            {0, 1},
            {1, 0}
        };

        // [[0, 0, 0, 0], [1, 1, 2, 2]]
        System.out.println(Arrays.deepToString(l.findFarmland(land1)));
        // [[0, 0, 1, 1]]
        System.out.println(Arrays.deepToString(l.findFarmland(land2)));
        // []
        System.out.println(Arrays.deepToString(l.findFarmland(land3)));
        // [[0, 1, 0, 1], [1, 0, 1, 0]]
        System.out.println(Arrays.deepToString(l.findFarmland(land4)));
    }

    boolean[][] visited;
    // 내 풀이
    public int[][] findFarmland(int[][] land) {
        visited = new boolean[land.length][land[0].length];
        List<int[]> answerList = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    int[] coor = findCoor(land, i, j);
                    visitLand(coor);
                    answerList.add(coor);
                }
            }
        }

        if (answerList.isEmpty()) {
            return new int[][]{};
        }
        // list to array
        int[][] answer = new int[answerList.size()][4];
        for (int i = 0; i < answerList.size(); i++) {
            for (int j = 0; j < 4; j++) {
                answer[i][j] = answerList.get(i)[j];
            }
        }
        return answer;
    }

    private int[] findCoor(int[][] land, int x, int y) {
        int[] coor = new int[4];
        coor[0] = x;
        coor[1] = y;
        for (int i = x; i < land.length; i++) {
            if (land[i][y] == 1) {
                coor[2] = i;
            } else {
                break;
            }
        }
        for (int i = y; i < land[0].length; i++) {
            if(land[x][i]==1){
                coor[3]=i;
            } else {
                break;
            }
        }
        return coor;
    }

    private void visitLand(int[] coor) {
        for (int i = coor[0]; i <= coor[2]; i++) {
            for (int j = coor[1]; j <= coor[3]; j++) {
                visited[i][j] = true;
            }
        }
    }

    // 다른 사람의 풀이
    // visited를 쓰지 않고 기존 land에서 방문한 좌표는 0으로 바꾸어 해결하였다.
}
