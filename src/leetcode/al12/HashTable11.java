// Intersection of Two Arrays 2
package leetcode.al12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HashTable11 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        System.out.println(Arrays.toString(intersect(nums3, nums4)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // nums1 LinkedList에 추가
        LinkedList<Integer> nums1List = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1List.add(nums1[i]);
        }

        // nums2 원소 nums1List에 있는지 확인
        List<Integer> intersect = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (nums1List.contains(nums2[i])) {
                intersect.add(nums2[i]);
                nums1List.remove((Integer) nums2[i]);
            }
        }

        // list array로 변환해서 반환
        int[] answer = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++) {
            answer[i] = intersect.get(i);
        }
        return answer;
    }

}
// hashmap을 이용하려면 key에 int값을, value에 개수를 저장하면 된다.
// index를 이용한 방법도 있다.