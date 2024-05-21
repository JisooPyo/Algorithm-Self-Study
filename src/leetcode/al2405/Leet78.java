package leetcode.al2405;

import java.util.ArrayList;
import java.util.List;

public class Leet78 {
    public static void main(String[] args) {
        Leet78 l = new Leet78();

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0};

        System.out.println(l.subsets(nums1));
        System.out.println(l.subsets(nums2));
    }

    // 내 풀이(0ms)
    // 어제 푼 것과 거의 같은 문제!
    List<List<Integer>> list;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        this.nums = nums;
        list.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            combination(i, 0, new ArrayList<>());
        }
        return list;
    }

    private void combination(int n, int start, List<Integer> subList) {
        if (n == 0) {
            list.add(subList);
            return;
        }
        for (int i = start; i <= nums.length - n; i++) {
            List<Integer> copyList = new ArrayList<>(subList);
            copyList.add(nums[i]);
            combination(n - 1, i + 1, copyList);
        }
    }
}
