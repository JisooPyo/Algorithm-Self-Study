package leetcode.al2404;

public class Leet1011_x {
    public static void main(String[] args) {
        Leet1011_x l = new Leet1011_x();

        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int[] weights3 = {1, 2, 3, 1, 1};

        System.out.println(l.shipWithinDays(weights1, 5));
        System.out.println(l.shipWithinDays(weights2, 3));
        System.out.println(l.shipWithinDays(weights3, 4));
    }

    // 다른 사람의 풀이
    // isPossible() 메서드는 구현했으나
    // 1. 이진탐색으로 가지 않아서 최적화가 덜 된 점
    // 2. max만 생각하고 sum은 생각하지 않았던 점
    // 으로 Time Limit Exceeded가 나왔다.
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int val : weights) {
            sum += val;
            max = Math.max(max, val);
        }
        if (weights.length == days) {
            return max;
        }

        // 최댓값 <= 답 <= 총 합계
        // 이진 탐색으로 답 찾기
        int low = max;
        int high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int weight[], int mid, int days) {
        int d = 1;
        int sum = 0;
        for (int i = 0; i < weight.length; i++) {
            sum += weight[i];
            if (sum > mid) {
                d++;
                sum = weight[i];
            }
        }
        return d <= days;
    }
}
