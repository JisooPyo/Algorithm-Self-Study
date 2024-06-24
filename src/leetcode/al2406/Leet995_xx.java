package leetcode.al2406;

/**
 Hard
 995. Minimum Number of K Consecutive Bit Flips

 Given
 nums : 이진 배열
 k : 정수

 k-비트 플립은 nums 배열에서 길이 k 만큼의 부분배열을 고르는 것이다.
 그리고 동시에 부분배열의 모든 0을 1로, 모든 1을 0으로 바꾸는 것이다.

 Return
 배열에 0이 없게 만들기 위한 k-비트 플립의 최소 수를 구하여라.
 만약 불가능하다면 -1을 반환하라.
 */
public class Leet995_xx {
    public static void main(String[] args) {
        Leet995_xx l = new Leet995_xx();

        int[] nums1 = {0, 1, 0};
        int[] nums2 = {1, 1, 0};
        int[] nums3 = {0, 0, 0, 1, 0, 1, 1, 0};

        System.out.println(l.minKBitFlips(nums1, 1));   // 2
        System.out.println(l.minKBitFlips(nums2, 2));   // -1
        System.out.println(l.minKBitFlips(nums3, 3));   // 3
    }

    // 다른 사람의 풀이 : 4ms
    // ?? 하나도 모르겠다..
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flipped = 0;
        int res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                flipped ^= isFlipped[i - k];
            }
            if (flipped == nums[i]) {
                if (i + k > nums.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}
