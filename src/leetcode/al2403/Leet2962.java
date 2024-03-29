package leetcode.al2403;

public class Leet2962 {
    public static void main(String[] args) {
        Leet2962 l = new Leet2962();

        int[] nums1 = {1, 3, 2, 3, 3};
        int[] nums2 = {1, 4, 2, 1};

        System.out.println(l.countSubarrays(nums1, 2));
        System.out.println(l.countSubarrays(nums2, 3));
    }

    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }

        int left = 0;
        int count = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                count++;
            }
            while (count >= k) {
                answer += nums.length - right;
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }

        }
        return answer;
    }
}
