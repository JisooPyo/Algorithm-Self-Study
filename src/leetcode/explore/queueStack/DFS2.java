package leetcode.explore.queueStack;

public class DFS2 {
    public static void main(String[] args) {
        DFS2 d = new DFS2();
        int[] nums1 = {1, 1, 1, 1, 1};
        int[] nums2 = {1};
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(d.findTargetSumWays(nums1, 3));  // 5
        System.out.println(d.findTargetSumWays(nums2, 1));  // 1
        System.out.println(d.findTargetSumWays(nums3, 3));  // 3

    }

    // 다른 사람 풀이(2ms)
    public int findTargetSumWays2(int[] nums, int target) {
        // nums 원소들의 절댓값의 합
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
            sum += nums[i];
        }
        /*
        수학적인 부분이라 안되는 건 알겠지만 왜 안되는 건 알기 어려움.. > 리트코드 discuss 보고 이해!
        nums = {1, 2, 3, 4, 5}, target = 3일 때, 가능한 합 중의 하나가 +1-2+3-4+5라고 하면
        양의 부분 집합 P = {1, 3, 5}, 음의 부분집합 N = {2, 4}로 나눌 수 있다.
        이를 식으로 나타내면
        sum(P) - sum(N) = target
        sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N)
        2 * sum(P) = target + sum(nums)
        따라서 target + sum(nums)(절댓값의 합)은 짝수여야 한다.
        */
        int k = sum + Math.abs(target);
        if (k % 2 == 1) {
            return 0;
        }
        // 모든 원소가 0이라는 뜻.
        // 2의 nums.length승만큼의 방법(최대)이 있다.
        if (target == 0 && sum == 0) {
            return 1 << nums.length;
        }
        // 위의 설명에서 k = "양의 부분집합의 합"이다.
        // 위의 예시에서 k = 9
        // 즉 원소를 더했을 때 9가 나오는 경우의 수를 구하면 된다.
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
