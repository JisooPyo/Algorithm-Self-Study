package leetcode.al2408;

/**
 * Medium
 * 959. Regions Cut By Slashes
 *
 * n x n 그리드는 1 x 1 크기의 사각형들로 구성되어 있으며,
 * 각 1 x 1 사각형은 '/', '\', 또는 빈 공간 ' '로 이루어져 있습니다.
 * 이 문자들은 사각형을 서로 인접한 영역으로 나눕니다.
 *
 * 주어진 문자열 배열로 표현된 그리드 grid가 주어질 때, 이 그리드에서 분할된 영역의 개수를 반환하세요.
 *
 * 참고로 백슬래시 문자는 이스케이프되어 있어, '\'는 '\\'로 표현됩니다.
 */
public class Leet959_x {
    public static void main(String[] args) {
        Leet959_x l = new Leet959_x();
        String[] grid1 = {" /", "/ "};
        String[] grid2 = {" /", "  "};
        String[] grid3 = {"/\\", "\\/"};

        System.out.println(l.regionsBySlashes(grid1));  // 2
        System.out.println(l.regionsBySlashes(grid2));  // 1
        System.out.println(l.regionsBySlashes(grid3));  // 5
    }

    // 아예 감을 못 잡았음 8ㅅ8
    // 쓰인 알고리즘 : Union-Find, Disjoint Set
    // https://leetcode.com/problems/regions-cut-by-slashes/solutions/5614698/beats-100-explained-with-video-c-java-python-js-union-find-explained-in-detail
    // 다른 사람의 풀이 : 2ms
    int[] parent;
    int[] rank;
    int count;

    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int dots = rows + 1;
        parent = new int[dots * dots];
        rank = new int[dots * dots];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || j == 0 || i == rows || j == rows) {
                    int cells = i * dots + j;
                    union(0, cells);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            char[] ch = grid[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '\\') {
                    int cell1 = i * dots + j;
                    int cell2 = (i + 1) * dots + (j + 1);
                    union(cell1, cell2);
                } else if (ch[j] == '/') {
                    int cell1 = (i + 1) * dots + j;
                    int cell2 = i * dots + (j + 1);
                    union(cell1, cell2);
                }
            }
        }
        return count;
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) {
            count++;
        } else {
            if (rank[parentA] > rank[parentB]) {
                parent[parentB] = parentA;
            } else if (rank[parentA] < rank[parentB]) {
                parent[parentA] = parentB;
            } else {
                parent[parentB] = parentA;
                rank[parentA]++;
            }
        }
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        int temp = find(parent[a]);
        parent[a] = temp;
        return temp;
    }
}
