package programmers.test2311;

public class IntegerTriangle {
    public static void main(String[] args) {
        IntegerTriangle it = new IntegerTriangle();
        int[][] triangle1 = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        // 30
        System.out.println(it.solution(triangle1));
    }

    public int solution(int[][] triangle) {
        if (triangle.length == 1) {
            return triangle[0][0];
        }

        if (triangle.length == 2) {
            return Math.max(triangle[1][0], triangle[1][1]) + triangle[0][0];
        }

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];

        for (int y = 2; y < triangle.length; y++) {
            for (int x = 0; x < triangle[y].length; x++) {
                if (x == 0) {
                    dp[y][x] = dp[y - 1][x] + triangle[y][x];
                    continue;
                }
                if (x == triangle[y].length - 1) {
                    dp[y][x] = dp[y - 1][x - 1] + triangle[y][x];
                    continue;
                }
                dp[y][x] = Math.max(dp[y - 1][x - 1], dp[y - 1][x]) + triangle[y][x];
            }
        }

        return getmax(dp[triangle.length - 1]);
    }

    private int getmax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
