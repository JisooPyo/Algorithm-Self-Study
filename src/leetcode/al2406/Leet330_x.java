package leetcode.al2406;

/**
 * Hard
 * 330. Patching Array
 *
 * Given
 * nums : 정렬된 정수 배열
 * n : 정수
 *
 * 배열에 요소를 추가하여 [1, n] 범위 내의 모든 숫자가 배열의 일부 요소의 합으로 형성될 수 있도록 하십시오.
 * 필요한 최소한의 패치 수를 반환하십시오.
 */
public class Leet330_x {
    public static void main(String[] args) {
        Leet330_x l = new Leet330_x();

        int[] nums1 = {1, 3};
        // [1, 2, 3]
        System.out.println(l.minPatches(nums1, 6));     // 1

        int[] nums2 = {1, 5, 10};
        // [1, 2, 4, 5, 10]
        System.out.println(l.minPatches(nums2, 20));     // 2

        int[] nums3 = {1, 2, 2};
        System.out.println(l.minPatches(nums3, 5));     // 0

        int[] nums4 = {1, 2, 31, 33};
        System.out.println(l.minPatches(nums4, 2147483647));     // 28

        int[] nums5 = {1, 2, 32};
        System.out.println(l.minPatches(nums5, 2147483647));     // 28

        int[] nums7 = {2, 4, 14, 18, 20, 25, 25, 35, 73, 94};
        System.out.println(l.minPatches(nums7, 42));       // 2

        int[] nums6 = {2};
        System.out.println(l.minPatches(nums6, 2147483647));     // 30

        int[] nums8 = {10, 30, 36, 42, 50, 76, 87, 88, 91, 92};
        System.out.println(l.minPatches(nums8, 54));     // 5 <<< 이게 왜 5야 4지 !!
    }

    // 다른 사람의 풀이 : 왜 이렇게 간단해....? 0ms..
    // 엇비슷하게 간 것에 대한 나에게 칭찬하자.. (2시간 걸렸지만)
    public int minPatches(int[] nums, int n) {
        // 현재 만들 수 없는 가장 작은 숫자
        long miss = 1;
        // 추가 시켜야 하는 원소 개수(return 값)
        int result = 0;
        // nums 에서 사용할 index
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                result++;
            }
        }

        return result;
    }

    // 내 풀이 : 못 풀었다..Greedy 는 너무 어려오..
    public int minPatchesMe(int[] nums, int n) {
        if (n == 1) {
            if (nums[0] == 1) {
                return 0;
            } else {
                return 1;
            }
        }

        // 이진으로 표현했을 때 길이 구하기
        int binaryLength = 0;
        int nCopied = n;
        while (nCopied > 0) {
            nCopied /= 2;
            binaryLength++;
        }

        // 1, 2, 3~4, 5~8, 9~16, 17~32, 33~64, ... 배치하는 배열 만들기
        int[] position = new int[binaryLength];
        int sum = 0;
        int pow = 0;
        // nums에 있는 숫자 position에 배치
        for (int i = 0; i < nums.length; i++) {
            if (Math.pow(2, binaryLength - 1) < nums[i]) {
                break;
            }
            if (Math.pow(2, pow - 1) < nums[i] && nums[i] <= Math.pow(2, pow)) {
                if (position[pow] != 0) {
                    sum += nums[i];
                } else {
                    position[pow] = nums[i];
                }
            } else {
                i--;
                pow++;
            }
        }

        // position 의 0 부분 채워넣기
        int positionSum = 0;
        int count = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] == 0) {
                position[i] = (int)Math.pow(2, i);
                positionSum += (int)Math.pow(2, i);
                count++;
                continue;
            }
            if (position[i] > positionSum + 1) {
                count++;
                positionSum += (int)Math.pow(2, i - 1);
            }
        }

        // 다 채웠는데도 부족하다면 중간에 nums[i] value 가 부족해서 안 된다는 것. 따라서 + 1
        return count;
    }
}
