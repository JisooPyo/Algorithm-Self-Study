package leetcode.al2404;

import java.util.HashSet;
import java.util.Set;

public class Leet79 {
    public static void main(String[] args) {
        Leet79 l = new Leet79();
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        char[][] board2 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word2 = "SEE";
        char[][] board3 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word3 = "ABCB";
        char[][] board4 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'E', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word4 = "ABCESEEEFS";
        System.out.println(l.exist(board1, word1));     // true
        System.out.println(l.exist(board2, word2));     // true
        System.out.println(l.exist(board3, word3));     // false
        System.out.println(l.exist(board4, word4));     // true
    }

    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        Set<int[]> coordinates = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    coordinates.add(new int[]{i, j});
                }
            }
        }
        if (coordinates.isEmpty()) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int[] coor : coordinates) {
            if (rec(coor[0], coor[1], 0, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean rec(int x, int y, int index, boolean[][] visited) {
        visited[x][y] = true;
        if (index == word.length() - 1) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
        if (x != 0) {
            if (!visited[x - 1][y] && board[x - 1][y] == word.charAt(index + 1)) {
                up = rec(x - 1, y, index + 1, visited);
            }
        }
        if (x != board.length - 1) {
            if (!visited[x + 1][y] && board[x + 1][y] == word.charAt(index + 1)) {
                down = rec(x + 1, y, index + 1, visited);
            }
        }
        if (y != 0) {
            if (!visited[x][y - 1] && board[x][y - 1] == word.charAt(index + 1)) {
                left = rec(x, y - 1, index + 1, visited);
            }
        }
        if (y != board[0].length - 1) {
            if (!visited[x][y + 1] && board[x][y + 1] == word.charAt(index + 1)) {
                right = rec(x, y + 1, index + 1, visited);
            }
        }
        if (left || right || up || down) {
            return true;
        } else {
            visited[x][y] = false;
            return false;
        }
    }

    // 다른 사람의 풀이
    // 배열에서 일단 문자열의 문자들이 있는지 먼저 검사한 후 재귀를 돌렸다.
}
