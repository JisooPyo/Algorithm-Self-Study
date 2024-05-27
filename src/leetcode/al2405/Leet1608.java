package leetcode.al2405;

import java.util.Arrays;

/**
 * Easy
 * 1608. Special Array With X Elements Greater Than or Equal X
 *
 * Given
 * nums: 음이 아닌 정수 배열
 *
 * 만약 x보다 크거나 같은 수가 nums에 x개 있고, 그 x가 하나 존재한다면 nums는 "special"하다고 한다.
 *
 * Note
 * x는 nums의 원소일 필요는 없다.
 *
 * Return
 * 만약 array가 special하다면 x를 return하라.
 * 아니면 -1을 return하라.
 */
public class Leet1608 {
    public static void main(String[] args) {
        Leet1608 l = new Leet1608();

        int[] nums1 = {3, 5};
        int[] nums2 = {0, 0};
        int[] nums3 = {0, 4, 3, 0, 4};
        int[] nums4 = {
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
            100, 100, 100, 100, 100, 100, 100, 100, 100, 100
        };

        System.out.println(l.specialArray(nums1));  // 2
        System.out.println(l.specialArray(nums2));  // -1
        System.out.println(l.specialArray(nums3));  // 3
        System.out.println(l.specialArray(nums4));  // 100
    }

    // 내 풀이(1ms)
    // 이진 검색으로 풀까 했었으나 x는 nums의 원소가 아니어도 된다는 조건이 있으므로 오히려 더 복잡해질 것 같아서
    // 단순 탐색으로 해결하였다.
    public int specialArray(int[] nums) {
        // 주어진 배열을 정렬한다.
        Arrays.sort(nums);
        // X를 구하기 위한 cur. 하나하나 높여가며 X를 찾는데 사용된다.
        int cur = Math.min(nums.length, nums[0]);
        // X보다 큰 원소의 개수를 구하기 위한 index
        int index = 0;

        // cur == 개수 이거나 cur > 개수 가 되면 while 문에서 빠져나오게 된다.
        while (index < nums.length && cur < (nums.length - index)) {
            cur++;
            while (index < nums.length && cur > nums[index]) {
                index++;
            }
        }

        // 이 때, index가 nums.length에 도달했다면 만족하는 x가 없다는 뜻이므로 -1을 반환한다.
        if (index == nums.length) {
            return -1;
        }
        // cur == 개수 를 지나쳐서 cur > 개수 가 된 케이스이므로 역시 x가 존재하지 않으므로 -1을 반환한다.
        if (cur > (nums.length - index)) {
            return -1;
        }

        // cur은 유일해야 하므로 유일한지 테스트 한다.
        // cur가 유일한 경우 이가 답이므로 미리 저장한다.
        int ans = cur;
        // cur에 하나를 더해 cur == 개수가 되는지 테스트한다.
        cur++;
        while (index < nums.length && cur > nums[index]) {
            index++;
        }

        // cur == 개수가 되면 X가 유일하지 않다는 뜻이므로 -1을 반환한다.
        // 아닌 경우 유일하다는 뜻이므로 저장해놓았던 ans를 반환한다.
        if (cur == (nums.length - index)) {
            return -1;
        } else {
            return ans;
        }
    }

}
