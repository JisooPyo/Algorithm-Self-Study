package leetcode.explore.hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTable14_v {
    public static void main(String[] args) {
        HashTable14_v h = new HashTable14_v();
        char[][] board1 = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board2 = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(h.isValidSudoku(board1));
        System.out.println("-----------------------");
        System.out.println(h.isValidSudoku(board2));
    }

    // 한 번 나왔던 수는 true체크하여 나중에 또 같은 수가 나왔을 때 false 리턴.
    public boolean isValidSudoku2(char[][] board) {
        boolean[][] rowValid = new boolean[9][10];
        boolean[][] columnValid = new boolean[9][10];
        boolean[][] cellValid = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // i,j 를 바탕으로 해당 숫자가 몇번째 셀인지 알아야 함
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (rowValid[i][num] || columnValid[j][num] || cellValid[getCellNumber(i, j)][num]) {
                        return false;
                    }
                    rowValid[i][num] = true;
                    columnValid[j][num] = true;
                    cellValid[getCellNumber(i, j)][num] = true;
                }
            }
        }
        return true;
    }

    int getCellNumber(int i, int j) {
        if (i < 3 && j < 3) return 0;
        if (i < 3 && j < 6) return 1;
        if (i < 3 && j < 9) return 2;
        if (i < 6 && j < 3) return 3;
        if (i < 6 && j < 6) return 4;
        if (i < 6 && j < 9) return 5;
        if (i < 9 && j < 3) return 6;
        if (i < 9 && j < 6) return 7;
        if (i < 9 && j < 9) return 8;
        return 0;
    }

    public boolean isValidSudoku(char[][] board) {
        System.out.println(checkRow(board));
        System.out.println(checkColumn(board));
        System.out.println(checkSubBox(board));
        return checkRow(board) && checkColumn(board) && checkSubBox(board);
    }

    private boolean checkSubBox(char[][] board) {
        // subBox Index
        // i - 012 -> 0, 345 -> 1, 678 -> 2
        // j - 012 -> 0, 345 -> 1, 678 -> 2
        // key -> i+j
        // values
        Map<String, Set<Character>> subBox = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!isNumberWithinRange(board[i][j])) {
                    return false;
                }
                String key = getSubBoxKey(i, j);
                if (!subBox.containsKey(key)) {
                    subBox.put(key, new HashSet<>());
                }
                if (subBox.get(key).contains(board[i][j])) {
                    return false;
                }
                subBox.get(key).add(board[i][j]);
            }
        }
        return true;
    }

    private String getSubBoxKey(int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(i / 3);
        sb.append(j / 3);
        return sb.toString();
    }

    private boolean checkColumn(char[][] board) {
        // column Index, values
        Map<Integer, Set<Character>> column = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0) {
                    column.put(i, new HashSet<>());
                }
                char num = board[j][i];
                if (num != '.') {
                    if (!isNumberWithinRange(num)) {
                        return false;
                    }
                    if (column.get(i).contains(num)) {
                        return false;
                    }
                    column.get(i).add(num);
                }
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board) {
        // row Index, values
        Map<Integer, Set<Character>> row = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0) {
                    row.put(i, new HashSet<>());
                }
                char num = board[i][j];
                if (num != '.') {
                    if (!isNumberWithinRange(num)) {
                        return false;
                    }
                    if (row.get(i).contains(num)) {
                        return false;
                    }
                    row.get(i).add(num);
                }
            }
        }
        return true;
    }

    private boolean isNumberWithinRange(char c) {
        return '1' <= c && c <= '9';
    }
}
