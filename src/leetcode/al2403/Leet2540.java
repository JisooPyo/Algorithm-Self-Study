package leetcode.al2403;

public class Leet2540 {
    public static void main(String[] args) {
        Leet2540 l = new Leet2540();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4};
        int[] nums3 = {1, 2, 3, 6};
        int[] nums4 = {2, 3, 4, 5};
        int[] nums5 = {1, 2, 3, 4};
        int[] nums6 = {5, 6, 7, 8};
        // System.out.println(l.getCommon(nums1, nums2));
        // System.out.println(l.getCommon(nums3, nums4));
        System.out.println(l.getCommon(nums5, nums6));
    }

    // 내 풀이
    public int getCommon(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length && nums1[index1] != nums2[index2]) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
                continue;
            }
            if (nums1[index1] < nums2[index2]) {
                index1++;
            }
        }
        if (index1 == nums1.length || index2 == nums2.length) {
            return -1;
        }
        return nums1[index1];
    }

    // 다른 사람 풀이
    // 애초에 nums1의 끝과 nums2의 시작, nums1의 시작과 nums2의 끝을 비교하여
    // 겹치는 게 아예 없을 경우의 수를 줄인다.
}
