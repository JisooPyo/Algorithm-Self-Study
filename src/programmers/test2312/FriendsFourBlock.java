package programmers.test2312;

import java.util.Stack;

public class FriendsFourBlock {
    public static void main(String[] args) {
        FriendsFourBlock f = new FriendsFourBlock();

        String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(f.solution(4, 5, board1));
        System.out.println(f.solution(6, 6, board2));
    }

    public int solution(int m, int n, String[] board) {
        char[][] boardSplit = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardSplit[i][j] = board[i].charAt(j);
            }
        }

        int count = -1;
        while (count != 0) {
            boolean[][] remove = new boolean[m][n];
            for (int i = 0; i < n - 1; i++) {
                Stack<Character> former = new Stack<>();
                Stack<Character> latter = new Stack<>();
                former.push('*');
                latter.push('*');
                int fuIndex = m - 1;
                int fdIndex = m - 1;
                int luIndex = m - 1;
                int ldIndex = m - 1;
                while (fuIndex > -1 && luIndex > -1) {
                    char fChar = boardSplit[fuIndex][i];
                    char lChar = boardSplit[luIndex][i + 1];
                    if (fChar == '#') {
                        fuIndex--;
                        continue;
                    }
                    if (lChar == '#') {
                        luIndex--;
                        continue;
                    }
                    if (former.peek() == latter.peek() && former.peek() == fChar && fChar == lChar) {
                        remove[fuIndex][i] = true;
                        remove[fdIndex][i] = true;
                        remove[luIndex][i + 1] = true;
                        remove[ldIndex][i + 1] = true;
                    }
                    former.push(fChar);
                    latter.push(lChar);
                    fdIndex = fuIndex;
                    ldIndex = luIndex;
                    fuIndex--;
                    luIndex--;
                }
            }

            count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        count++;
                        boardSplit[i][j] = '#';
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (boardSplit[i][j] == '#') {
                    answer++;
                }
            }
        }
        return answer;
    }

}
