package bookStudy.study2409;

import java.util.Stack;

/**
 * 프로그래머스 lv.1
 * 13. 크레인 인형뽑기 게임
 */
public class Problem13 {
    public static void main(String[] args) {
        Problem13 p = new Problem13();

        int[][] board1 = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}
        };
        int[] moves1 = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(p.solution(board1, moves1)); // 4
    }

    // 시간복잡도: O(N^2+M)
    // N: board의 길이
    // M: moves의 길이
    public int solution(int[][] board, int[] moves) {
        // 칸마다 제일 겉에 있는 인형의 위치를 구한다.
        int n = board.length;
        int[] boardIndex = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (board[i][j] != 0) {
                    boardIndex[j] = i;
                    break;
                }
            }
        }

        // 스택을 이용하여 문제를 푼다.
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < moves.length; i++) {
            if (boardIndex[moves[i] - 1] == n) {
                continue;
            }
            int element = board[boardIndex[moves[i] - 1]][moves[i] - 1];
            if (stack.isEmpty() || stack.peek() != element) {
                stack.push(element);
            } else {
                stack.pop();
                answer += 2;
            }
            boardIndex[moves[i] - 1]++;
        }
        return answer;
    }
}
/*
정확성 테스트
테스트 1 〉	통과 (0.17ms, 75.4MB)
테스트 2 〉	통과 (0.15ms, 70.9MB)
테스트 3 〉	통과 (0.19ms, 75MB)
테스트 4 〉	통과 (0.71ms, 72.8MB)
테스트 5 〉	통과 (0.13ms, 72.5MB)
테스트 6 〉	통과 (0.14ms, 78.1MB)
테스트 7 〉	통과 (0.21ms, 73.3MB)
테스트 8 〉	통과 (0.54ms, 78.8MB)
테스트 9 〉	통과 (0.44ms, 75.5MB)
테스트 10 〉	통과 (0.42ms, 71.9MB)
테스트 11 〉	통과 (0.72ms, 77.7MB)
 */
