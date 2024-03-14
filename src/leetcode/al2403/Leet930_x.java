package leetcode.al2403;

public class Leet930_x {
    public static void main(String[] args) {
        Leet930_x l = new Leet930_x();
        int[] nums1 = {1, 0, 1, 0, 1};
        int[] nums2 = {0, 0, 0, 0, 0};
        int[] nums3 = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        System.out.println(l.numSubarraysWithSum(nums1, 2));
        System.out.println(l.numSubarraysWithSum(nums2, 0));
        System.out.println(l.numSubarraysWithSum(nums3, 0));
    }

    // 다른 사람 풀아
    // 시간 복잡도 : O(N)
    public int numSubarraysWithSumOther(int[] nums, int goal) {
        int totalCount = 0;
        int sum = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 1;

        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                totalCount += prefixSum[sum - goal];
            }
            prefixSum[sum]++;
        }

        return totalCount;
    }

    // 시간 복잡도 : O(N^2)
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int index = 0;
        int count = 0;
        loop1:
        while (index < nums.length) {
            for (int i = index; i < nums.length; i++) {
                sum += nums[i];
                if (sum == goal) {
                    index++;
                    sum = 0;
                    count++;
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] == 0) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    break;
                }
                if (i == nums.length - 1 && sum < goal) {
                    break loop1;
                }
            }
        }
        return count;
    }
}
