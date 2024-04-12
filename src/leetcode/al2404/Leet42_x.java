package leetcode.al2404;

public class Leet42_x {
    public static void main(String[] args) {
        Leet42_x l = new Leet42_x();

        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};

        System.out.println(l.trap(height1));
        System.out.println(l.trap(height2));
    }

    // 다른 사람의 풀이
    // 물 높이를 나무라고 생각하면 나무를 다 덮는 숲을 만든 다음 숲의 넓이 - 나무의 넓이로 답을 구한다.
    // ^ 여기까지는 생각했었는데 left, right쪽에서 최댓값을 구하고 그 최솟값을 구하면 된다는 생각까지 못 갔다.
    public int trap(int[] height) {
        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int storedWater = 0;

        // Fill left array
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        // Fill right array
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(left[i], right[i]);
            storedWater += minHeight - height[i];
        }

        return storedWater;
    }
}
