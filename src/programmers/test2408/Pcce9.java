package programmers.test2408;

public class Pcce9 {
    public static void main(String[] args) {
        Pcce9 pcce9 = new Pcce9();
        String[][] board1 = {
            {"blue", "red", "orange", "red"},
            {"red", "red", "blue", "orange"},
            {"blue", "orange", "red", "red"},
            {"orange", "orange", "red", "blue"}
        };
        String[][] board2 = {
            {"yellow", "green", "blue"},
            {"blue", "green", "yellow"},
            {"yellow", "blue", "blue"}
        };
        System.out.println(pcce9.solution(board1, 1, 1));       // 2
        System.out.println(pcce9.solution(board2, 0, 1));       // 1
    }

    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        for (int i = 0; i <= 3; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if (0 <= h_check && h_check < n && 0 <= w_check && w_check < n) {
                if (board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }
        return count;
    }
}
