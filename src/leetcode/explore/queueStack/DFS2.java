package leetcode.explore.queueStack;

public class DFS2 {
    public static void main(String[] args) {
        DFS2 d = new DFS2();
        int[] nums1 = {1, 1, 1, 1, 1};
        int[] nums2 = {1};
        System.out.println(d.findTargetSumWays(nums1, 3));  // 5
        System.out.println(d.findTargetSumWays(nums2, 1));  // 1

    }

    // 다른 사람 풀이(2ms)
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
            sum += nums[i];
        }

        int k = sum + Math.abs(target);
        if (k % 2 == 1) {
            return 0;
        }
        if (target == 0 && sum == 0) {
            return 1 << nums.length;
        }
        k /= 2;

        int dp[] = new int[k + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = k; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[k];
    }

    // 내 풀이(364ms)
    int count;

    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length - 1) {
            if (sum + nums[index] == target) {
                count++;
            }
            if (sum - nums[index] == target) {
                count++;
            }
            return;
        }
        dfs(nums, target, index + 1, sum + nums[index]);
        dfs(nums, target, index + 1, sum - nums[index]);
    }
}
