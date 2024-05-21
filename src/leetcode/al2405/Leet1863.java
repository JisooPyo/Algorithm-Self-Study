package leetcode.al2405;

/**
 * 1863. Sum of All Subset XOR Totals(Easy)
 *
 * 배열의 XOR total : 배열의 모든 원소를 XOR 연산시킨 것
 *                   배열이 비어있다면 0
 * - 예를 들어, [2, 5, 6] 배열의 XOR total 은 2 XOR 5 XOR 6 = 1이다.
 *
 * Given
 * nums : 배열
 *
 * Return
 * sums의 모든 부분집합의 XOR total 의 합을 구하라.
 *
 * Constraints
 *  * 1 <= nums.length <= 12
 *  * 1 <= nums[i] <= 20
 */
public class Leet1863 {
    public static void main(String[] args) {
        Leet1863 l = new Leet1863();

        int[] nums1 = {1, 3};
        int[] nums2 = {5, 1, 6};
        int[] nums3 = {3, 4, 5, 6, 7, 8};

        System.out.println(l.subsetXORSum(nums1));      // 6
        System.out.println(l.subsetXORSum(nums2));      // 28
        System.out.println(l.subsetXORSum(nums3));      // 480
    }

    // 내 풀이(1ms)
    // 재귀를 통해 부분집합을 구하면서 동시에 XOR값을 구하고 sum에 더해준다.
    // 전에 구했던 XOR값을 다시 구하지 않아도 되는 것이 point!
    int sum;
    int[] nums;

    public int subsetXORSum(int[] nums) {
        sum = 0;
        this.nums = nums;

        for (int i = 1; i <= nums.length; i++) {
            combination(i, 0, 0);
        }
        return sum;
    }

    // n개 부분집합을 구하는 메서드
    // start: 부분집합의 시작 index
    // cur: 현재 부분집합의 XOR값
    private void combination(int n, int start, int cur) {
        if (n == 0) {
            sum += cur;
            return;
        }
        for (int i = start; i <= nums.length - n; i++) {
            combination(n - 1, i + 1, cur ^ nums[i]);
        }
    }
}
