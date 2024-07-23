package leetcode.al2407;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Easy
 * 1636. Sort Array by Increasing Frequency
 *
 * 정수 배열 nums가 주어진다. 값들의 빈도를 기반으로 오름차순으로 배열을 정렬하라.
 * 만약, 여러 값이 같은 빈도를 가진다면, 그들은 내림차순으로 정렬하라.
 *
 * -100 <= nums[i] <= 100
 */
public class Leet1636 {
    public static void main(String[] args) {
        Leet1636 l = new Leet1636();

        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {2, 3, 1, 3, 2};
        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};

        System.out.println(Arrays.toString(l.frequencySort(nums1)));
        System.out.println(Arrays.toString(l.frequencySort(nums2)));
        System.out.println(Arrays.toString(l.frequencySort(nums3)));
    }

    // 내 풀이 : 4ms
    public int[] frequencySort(int[] nums) {
        int[] frequency = new int[201];
        for (int num : nums) {
            frequency[num + 100]++;
        }

        List<Num> numList = new ArrayList<>();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                numList.add(new Num(i - 100, frequency[i]));
            }
        }
        numList.sort((a, b) -> {
            if (a.frequency != b.frequency) {
                return a.frequency - b.frequency;
            }
            return b.value - a.value;
        });

        int[] res = new int[nums.length];
        int index = 0;
        for (Num num : numList) {
            for (int i = 0; i < num.frequency; i++) {
                res[index++] = num.value;
            }
        }
        return res;
    }

    class Num {
        int value;
        int frequency;

        public Num(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }
}
