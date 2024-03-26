package leetcode.al2403;

import java.util.Arrays;

public class Leet41 {
    public static void main(String[] args) {
        Leet41 l = new Leet41();
        System.out.println(l.firstMissingPositive(new int[]{1, 1}));
    }

    // 정렬이 들어가므로 O(n log n)
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int pointer = 1;
        while (index < nums.length) {
            if (nums[index] <= 0) {
                index++;
                continue;
            }
            if (pointer == nums[index]) {
                pointer++;
                index++;
                continue;
            }
            if (pointer > nums[index]) {
                index++;
                continue;
            }
            if (pointer < nums[index]) {
                return pointer;
            }
        }
        return pointer;
    }

    // 다른 사람의 풀이
    public int firstMissingPositive2(int[] nums) {
        int i = 0;
        // swap을 이용해 nums[j]에 j+1을 넣는 과정
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (correct != i && nums[i] > 0 && nums[i] < nums.length) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, correct);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }

    void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
