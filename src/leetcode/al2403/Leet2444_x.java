package leetcode.al2403;

public class Leet2444_x {
    public static void main(String[] args) {
        Leet2444_x l = new Leet2444_x();

        int[] nums1 = {1, 3, 5, 2, 7, 5};
        int[] nums2 = {1, 1, 1, 1};

        System.out.println(l.countSubarrays(nums1, 1, 5));
        System.out.println(l.countSubarrays(nums2, 1, 1));
    }

    // min과 max를 정수에 저장하는 것, 범위를 벗어나면 window가 땡겨 오는 것까지는 생각해 내었는데
    // 세부 디테일을 너무 생각하다보니 코드가 복잡해져서 결국 못 풀게 된 문제
    // 다른 사람의 풀이를 보니 생각보다 간단하게 풀리는 문제였다.

    // 다른 사람의 풀이
    // sliding window 에서의 범위가 minK보다 크거나 같고 maxK보다 작거나 같아야 하기 때문에
    // 그 범위 밖이 되면 window도 땡겨 온다.
    // ex. [1, 3, 5, 2, 1, 7, 5, 1, 3, 1], minK = 1, maxK = 5
    // [1, 3, [5, 2, 1], 7, 5, 1, 3, 1] -> 범위 밖의 7이 나오면
    // [1, 3, 5, 2, 1, 7, [5], 1, 3, 1] -> 이런 식으로 window가 이동한다.
    // min과 max가 나오면 min부터 max까지의 그룹을 1개로 본다.
    // 새로 min이나 max가 나오면 새로운 min(or max)과 기존 max(or min)의 그룹을 1개로 본다.
    // [[1, 3, 5], 2, 1, 7, 5, 1, 3, 1] => 1
    // [[[1, 3, 5], 2], 1, 7, 5, 1, 3, 1] => 1
    // [[1, 3, [5, 2, 1]], 7, 5, 1, 3, 1] => 3
    // [1, 3, 5, 2, 1, 7, [5, 1], 3, 1] => 1
    // [1, 3, 5, 2, 1, 7, [[5, 1], 3], 1] => 1
    // [1, 3, 5, 2, 1, 7, [[5, 1, 3, 1]] => 1
    // => 8
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1, maxI = -1, left = -1, right = 0;
        long count = 0;
        while (right < nums.length) {
            if (nums[right] < minK || nums[right] > maxK) {
                minI = right;
                maxI = right;
                left = right;
            }
            minI = nums[right] == minK ? right : minI; // 4
            maxI = nums[right] == maxK ? right : maxI; // 2
            count += Math.min(minI, maxI) - left;   // (2)-(-1) = 3
            right++;
        }
        return count;
    }
}
