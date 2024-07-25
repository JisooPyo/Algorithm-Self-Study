package leetcode.al2407;

import java.util.Arrays;

/**
 * Medium
 * 912. Sort an Array
 *
 * 정수 배열 nums 가 주어진다.
 * 오름차순으로 정렬한 배열을 반환하라.
 *
 * 제공되는 메서드를 쓰지 않고 O(nlog(n)) 시간 복잡도로 문제를 풀어야 합니다.
 * 가능하다면 공간 복잡도를 적게 써야 합니다.
 */
public class Leet912_x {
    public static void main(String[] args) {
        Leet912_x l = new Leet912_x();
        int[] nums1 = {5, 2, 3, 1};
        int[] nums2 = {5, 1, 1, 2, 0, 0};

        // [1, 2, 3, 5]
        System.out.println(Arrays.toString(l.sortArray(nums1)));
        // [0, 0, 1, 1, 2, 5]
        System.out.println(Arrays.toString(l.sortArray(nums2)));

        // [1, 2, 3, 5]
        System.out.println(Arrays.toString(l.sortArrayOther(nums1)));
        // [0, 0, 1, 1, 2, 5]
        System.out.println(Arrays.toString(l.sortArrayOther(nums2)));
    }

    // 다른 사람의 풀이 : 4ms
    // 카운팅 정렬 알고리즘
    public int[] sortArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int n = max - min;
        int[] arr = new int[n + 1];

        for (int num : nums) {
            arr[num - min]++;
        }

        int index = 0;

        for (int i = 0; i <= n; i++) {
            while (arr[i] > 0) {
                nums[index] = min;
                index++;
                arr[i]--;
            }

            min++;
        }

        return nums;
    }

    // 힙 정렬 --> 이 문제에 한해서 카운팅 정렬보다는 느리지만 문제의 조건을 만족하는 알고리즘은 힙 정렬!
    public int[] sortArrayOther(int[] nums) {
        int n = nums.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
        return nums;
    }

    private void heapify(int[] nums, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(nums, n, largest);
        }
    }
}
