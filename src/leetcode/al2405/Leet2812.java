package leetcode.al2405;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2812. Find the Safest Path in a Grid
 *
 * Given
 * grid: 크기 n * n 2D 배열
 *       grid[r][c] = 1인 칸은 "도둑"을 의미한다.
 *       grid[r][c] = 0인 칸은 빈 칸이다.
 *
 * 처음에는 (0, 0) 칸에 위치한다. 한 번의 움직임에 인접한 칸으로 움직일 수 있다.(도둑이 있는 칸도)
 * 그리드에 있는 경로의 안전 계수는 경로에 있는 칸에서 그리드에 있는 도둑까지의 최소 맨해튼 거리로 정의된다.
 *
 * Return
 * (n - 1, n - 1)까지의 경로의 최대 안전 계수를 반환하라.
 *
 * - (r, c)의 인접한 칸은 (만약 존재한다면)(r, c + 1), (r, c - 1), (r + 1, c), (r - 1, c)이다.
 * - (a, b)와 (x, y) 사이의 맨해튼 거리는 |val|이 val의 절대값일 때, |a - x| + |b - y|와 같다.
 */
public class Leet2812 {
    public static void main(String[] args) {
        Leet2812 l = new Leet2812();
        l.problem();
    }

    private void problem() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(0);
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(0);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(0);
        list3.add(0);
        List<List<Integer>> grid1 = new ArrayList<>();
        grid1.add(list1);
        grid1.add(list2);
        grid1.add(list3);

        System.out.println(maximumSafenessFactor(grid1));     // 1
    }

    // 내 풀이 - 937ms
    // 1. 도둑이 있는 칸에서 BFS 사용하여 도둑까지의 거리 계산.
    // 2. 특정 값 이하의 칸을 지웠을 때 경로가 있는지 확인(이진탐색)하고 안전 팩터를 구한다.
    List<List<Integer>> grid;
    int n;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        this.grid = grid;
        n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        // 각 칸에서 도둑까지의 거리를 BFS로 구합니다.
        // 이 때, 도둑 바로 다음 칸은 2, 다음 다음 칸은 3의 형태로 grid에 기록합니다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    bfs(i, j);
                }
            }
        }

        // 위에서 구한 거리 중 가장 큰 값을 찾아 boolean 배열을 만들고,
        // 특정 거리(값: val) 이하의 칸을 제외했을 때, (0,0)부터 (n-1, n-1)까지의 경로가 존재하는지 existPath(val)로 구하여 boolean 배열에 기록합니다.
        int maxManhattan = getMaxManhattan();

        boolean[] check = new boolean[n + 1];

        int low = 1;
        int high = maxManhattan;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (existPath(mid)) {
                check[mid] = true;
                low = mid + 1;
            } else {
                check[mid] = false;
                high = mid - 1;
            }
        }

        // 최대 안전 계수를 구합니다.
        int answer = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                answer = i;
            }
        }
        return answer;
    }

    private boolean existPath(int mid) {
        boolean[][] visited = new boolean[n][n];
        return dfs(visited, mid, 0, 0);
    }

    private boolean dfs(boolean[][] visited, int val, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n || grid.get(row).get(col) <= val || visited[row][col]) {
            return false;
        }

        if (row == n - 1 && col == n - 1) {
            return true;
        }

        visited[row][col] = true;

        if (dfs(visited, val, row, col + 1)
            || dfs(visited, val, row, col - 1)
            || dfs(visited, val, row + 1, col)
            || dfs(visited, val, row - 1, col)) {
            return true;
        }

        return false;
    }

    private int getMaxManhattan() {
        int maxManhattan = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) > maxManhattan) {
                    maxManhattan = grid.get(i).get(j);
                }
            }
        }
        return maxManhattan;
    }

    private void bfs(int x, int y) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int manhatten = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coor = queue.poll();
                int r = coor[0];
                int c = coor[1];
                grid.get(r).set(c, manhatten);
                if (r != 0 && !visited[r - 1][c] && grid.get(r - 1).get(c) != 1) {
                    if (grid.get(r - 1).get(c) == 0 || manhatten + 1 < grid.get(r - 1).get(c)) {
                        visited[r - 1][c] = true;
                        queue.add(new int[]{r - 1, c});
                    }
                }
                if (r != n - 1 && !visited[r + 1][c] && grid.get(r + 1).get(c) != 1) {
                    if (grid.get(r + 1).get(c) == 0 || manhatten + 1 < grid.get(r + 1).get(c)) {
                        visited[r + 1][c] = true;
                        queue.add(new int[]{r + 1, c});
                    }
                }
                if (c != 0 && !visited[r][c - 1] && grid.get(r).get(c - 1) != 1) {
                    if (grid.get(r).get(c - 1) == 0 || manhatten + 1 < grid.get(r).get(c - 1)) {
                        visited[r][c - 1] = true;
                        queue.add(new int[]{r, c - 1});
                    }
                }
                if (c != n - 1 && !visited[r][c + 1] && grid.get(r).get(c + 1) != 1) {
                    if (grid.get(r).get(c + 1) == 0 || manhatten + 1 < grid.get(r).get(c + 1)) {
                        visited[r][c + 1] = true;
                        queue.add(new int[]{r, c + 1});
                    }
                }
            }
            manhatten++;
        }
    }

    // 다른 사람 풀이 - 81ms
    public int maximumSafenessFactorOther(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;

        // Integer.MAX_VALUE로 채워진 n * n 배열
        int cost[][] = new int[n][n];
        for (var v : cost) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }
        bfs(cost, grid, n);
        // ---여기까지는 나와 로직이 거의 동일하다.

        int l = 1, r = n * n;
        int ans = 0;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (possible(0, 0, cost, mid, n, new boolean[n][n])) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 이 로직도 동일하다.

        // 내 생각에는 bfs에서 필요없는 연산이 더 들어가서 시간이 많이 걸린 것 같고
        // 이 사람은 배열을 다루었는데 나는 List를 다루어서 그 점에서 시간이 더 걸린 것도 있을 것 같다.
        return ans;
    }

    public boolean possible(int i, int j, int cost[][], int mid, int n, boolean visited[][]) {
        if (i < 0 || j < 0 || i >= n || j >= n)
            return false;
        if (cost[i][j] == Integer.MAX_VALUE || cost[i][j] < mid)
            return false;
        if (i == n - 1 && j == n - 1)
            return true;
        if (visited[i][j])
            return false;
        visited[i][j] = true;
        int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean ans = false;
        for (var v : dir) {
            int ii = i + v[0];
            int jj = j + v[1];
            ans |= possible(ii, jj, cost, mid, n, visited);
            if (ans)
                return true;
        }
        return ans;
    }

    public void bfs(int cost[][], List<List<Integer>> grid, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        // 한꺼번에 1인 좌표를 넣어두면 더 빠르게 bfs를 할 수 있다..!!
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int level = 1;
        int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                var v = q.poll();
                var temp = v;
                for (var val : dir) {
                    int ii = temp[0] + val[0];
                    int jj = temp[1] + val[1];
                    if (isValid(ii, jj, n) && !visited[ii][jj]) {
                        q.add(new int[]{ii, jj});
                        cost[ii][jj] = Math.min(cost[ii][jj], level);
                        visited[ii][jj] = true;
                    }
                }
            }
            level++;
        }
    }

    // 움직였을 때의 좌표가 유효한지 확인하는 메서드. 이런 식으로 더 코드를 가독성 있게 줄일 수 있다.
    public boolean isValid(int i, int j, int n) {
        return (i >= 0 && j >= 0 && i < n && j < n);
    }
}
