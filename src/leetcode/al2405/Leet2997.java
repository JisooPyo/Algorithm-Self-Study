package leetcode.al2405;

/**
 * Given
 * nums: 0-indexed 정수 배열 nums
 * k: 양의 정수
 *
 * 다음과 같은 작업을 배열에 임의의 횟수로 적용할 수 있습니다:
 *   -> 배열의 요소를 선택하고 이진 표현에서 비트를 뒤집습니다.
 *      비트를 뒤집는다는 것은 0을 1로 변경하거나 그 반대로 변경하는 것을 의미합니다.
 *
 * 최종 배열의 모든 요소의 비트 XOR을 k로 만들기 위해 필요한 최소 작업 횟수를 반환하세요.
 *
 * Note:
 * 요소의 이진 표현에서 선행하는 0 비트를 뒤집을 수 있습니다.
 * 예를 들어, 숫자 (101)₂의 경우 네 번째 비트를 뒤집어 (1101)₂를 얻을 수 있습니다.
 */
public class Leet2997 {
    public static void main(String[] args) {
        Leet2997 l = new Leet2997();

        int[] nums1 = {2, 1, 3, 4};
        int[] nums2 = {2, 0, 2, 0};

        System.out.println(l.minOperations(nums1, 1));  // 2
        System.out.println(l.minOperations(nums2, 0));  // 0
    }

    public int minOperations(int[] nums, int k) {
        int preXor = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            preXor = preXor ^ nums[i];
        }
        int goal = preXor ^ k;

        // 몇 번 바뀌어야 하는가?
        int answer = goal ^ nums[nums.length - 1];
        return countOne(answer);
    }

    private int countOne(int i) {
        int count = 0;
        while (i > 0) {
            if (i % 2 == 1) {
                count++;
            }
            i = i / 2;
        }
        return count;
    }
}
