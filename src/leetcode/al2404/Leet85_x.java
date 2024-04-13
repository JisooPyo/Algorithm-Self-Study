package leetcode.al2404;

import java.util.Stack;

public class Leet85_x {
    public static void main(String[] args) {
        Leet85_x l = new Leet85_x();

        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        char[][] matrix2 = {{'0'}};
        char[][] matrix3 = {{'1'}};

        System.out.println(l.maximalRectangle(matrix1));    // 6
        System.out.println(l.maximalRectangle(matrix2));    // 0
        System.out.println(l.maximalRectangle(matrix3));    // 1
    }

    // 다른 사람의 풀이
    // 각 열에 대해 높이를 계산.
    // 각 열에 대해 이전 열에서 높이가 증가했는지 확인.
    // 스택을 사용하여 각 열에서 이전 열에서 높이가 감소한 지점 추적.
    // 각 열에 대해 직사각형 최대 넓이 계산, 최대값 업데이트.
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            // Update heights for each column
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Calculate maximal rectangle area for current row
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;

        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int topIndex = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, heights[topIndex] * width);
            }
        }

        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, heights[topIndex] * width);
        }

        return maxArea;
    }
}
