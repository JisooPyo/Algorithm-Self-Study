package leetcode.al2407;

import java.util.Arrays;

/**
 * Medium
 * 2191. Sort the Jumbled Numbers
 *
 * 매핑 규칙:
 *
 * mapping 이라는 0부터 인덱싱된 정수 배열이 주어집니다.
 * mapping[i] = j는 숫자 i가 숫자 j로 매핑되어야 함을 의미합니다.
 * 이 매핑 규칙을 이용하여 원래 숫자를 새로운 숫자로 변환할 수 있습니다.
 *
 * 매핑된 값:
 *
 * 어떤 정수의 매핑된 값은 그 정수의 각 자릿수를 매핑 규칙에 따라 변환하여 얻어집니다.
 * 예를 들어, 매핑 규칙이 [2, 1, 4, 8, 6, 3, 0, 9, 7, 5]이고 숫자 317을 변환하려면, 3은 8로, 1은 1로, 7은 9로 변환되어 최종 값은 819가 됩니다.
 *
 * 숫자 배열:
 *
 * nums라는 정수 배열이 주어집니다.
 * 이 배열의 각 요소를 매핑 규칙에 따라 변환한 후, 그 매핑된 값을 기준으로 오름차순으로 정렬합니다.
 *
 * 정렬 조건:
 *
 * 매핑된 값이 같은 요소들은 입력에서의 순서를 유지해야 합니다 (안정 정렬).
 * 배열 nums의 요소들은 매핑된 값에 따라 정렬되지만, 실제 배열 요소들은 변환되지 않은 원래 값을 유지해야 합니다.
 * 출력:
 *
 * 매핑된 값에 따라 정렬된 nums 배열을 반환합니다.
 */
public class Leet2191 {
    public static void main(String[] args) {
        Leet2191 leet2191 = new Leet2191();

        int[] mapping1 = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6}, nums1 = {991, 338, 38};
        int[] mapping2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, nums2 = {789, 456, 123};
        int[] mapping3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, nums3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // [338,38,991]
        System.out.println(Arrays.toString(leet2191.sortJumbled(mapping1, nums1)));
        // [123,456,789]
        System.out.println(Arrays.toString(leet2191.sortJumbled(mapping2, nums2)));
        // [9,8,7,6,5,4,3,2,1,0]
        System.out.println(Arrays.toString(leet2191.sortJumbled(mapping3, nums3)));
    }

    // 내 풀이 : 75ms
    int[] mapping;

    public int[] sortJumbled(int[] mapping, int[] nums) {
        this.mapping = mapping;
        Num[] numArr = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArr[i] = new Num(nums[i], getReplacedValue(nums[i]));
        }
        Arrays.sort(numArr, (a, b) -> a.replacedVal - b.replacedVal);
        for (int i = 0; i < numArr.length; i++) {
            nums[i] = numArr[i].val;
        }
        return nums;
    }

    private int getReplacedValue(int num) {
        if (num == 0) {
            return mapping[0];
        }
        int place = 1;
        int value = 0;
        while (num > 0) {
            value += place * mapping[num % 10];
            num /= 10;
            place *= 10;
        }
        return value;
    }

    class Num {
        int val;
        int replacedVal;

        public Num(int val, int replacedVal) {
            this.val = val;
            this.replacedVal = replacedVal;
        }
    }
}
