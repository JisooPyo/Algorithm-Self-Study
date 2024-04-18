package leetcode.al2404;

public class Leet463 {
    public static void main(String[] args) {
        Leet463 l = new Leet463();

        int[][] grid1 = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}};
        int[][] grid2 = {{1}};
        int[][] grid3 = {{1, 0}};

        System.out.println(l.islandPerimeter(grid1));
        System.out.println(l.islandPerimeter(grid2));
        System.out.println(l.islandPerimeter(grid3));
    }

    // 내 풀이
    // 섬은 모두 채워진 땅이므로 섬을 둘러싸는 최소한의 직사각형을 구하여 둘레를 구한 다음
    // 한 칸 건너뛰고 땅이 있는만큼만 둘레를 더해주면 된다.

    // 건너뛴 땅의 확인을 비트 연산자로 하면 더 좋았을 것!
    public int islandPerimeter(int[][] grid) {
        // 섬을 둘러싸는 최소한의 직사각형 구하기
        int r0 = grid.length;
        int r1 = -1;
        int c0 = grid[0].length;
        int c1 = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    r0 = Math.min(i, r0);
                    r1 = Math.max(i, r1);
                    c0 = Math.min(j, c0);
                    c1 = Math.max(j, c1);
                }
            }
        }

        // row를 탐색하면서 건너뛴 땅이 있는지 확인(더해줘야 할 세로 둘레가 더 있는지 확인)
        int rowAdd = 0;
        for (int i = r0; i <= r1; i++) {
            boolean start = false;
            boolean end = false;
            for (int j = c0; j <= c1; j++) {
                if (!start && grid[i][j] == 1) {
                    start = true;
                }
                if (start && grid[i][j] == 0) {
                    end = true;
                }
                if (end && grid[i][j] == 1) {
                    rowAdd++;
                    end = false;
                }
            }
        }

        // column을 탐색하면서 건너뛴 땅이 있는지 확인(더해줘야 할 가로 둘레가 더 있는지 확인)
        int colAdd = 0;
        for (int i = c0; i <= c1; i++) {
            boolean start = false;
            boolean end = false;
            for (int j = r0; j <= r1; j++) {
                if (!start && grid[j][i] == 1) {
                    start = true;
                }
                if (start && grid[j][i] == 0) {
                    end = true;
                }
                if (end && grid[j][i] == 1) {
                    colAdd++;
                    end = false;
                }
            }
        }

        return (r1 - r0 + 1) * 2 + (c1 - c0 + 1) * 2 + rowAdd * 2 + colAdd * 2;
    }

    // 다른 사람의 풀이
    public int islandPerimeteOther(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        int result = 0;

        // ^ 연산자를 통하여 건너뛴 column이 있는지 확인한 후 더해준다.
        for (int y = 0; y < height; y++) {
            int prev = 0;
            for (int x = 0; x < width; x++) {
                int keep = grid[y][x];
                result += prev ^ keep;
                prev = keep;
            }
            result += prev;
        }

        // ^ 연산자를 이용하여 건너뛴 row가 있는지 확인한 후 더해준다.
        for (int x = 0; x < width; x++) {
            int prev = 0;
            for (int y = 0; y < height; y++) {
                int keep = grid[y][x];
                result += prev ^ keep;
                prev = keep;
            }
            result += prev;
        }
        return result;
    }
}
