package leetcode.al10;

import java.util.Arrays;

public class ArrayAndString11 {
	public static void main(String[] args) {
		ArrayAndString11 aas11 = new ArrayAndString11();

		int[] nums1 = {1, 4, 3, 2};
		int[] nums2 = {6, 2, 6, 5, 1, 2};

		System.out.println(aas11.arrayPairSum(nums1));    // 4
		System.out.println(aas11.arrayPairSum(nums2));    // 9
	}

	// 투포인터..쓰는 방법은 없나
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}
		return sum;
	}

	// 다른 사람 솔루션 1
	public int arrayPairSum1(int[] nums) {
		// 정렬까지는 동일하다.
		Arrays.sort(nums);
		// for문을 돌리지 않고 여기서 i와 j의 투포인터를 쓴다.
		int i = 0;
		int j = nums.length - 2;
		int n = nums.length / 2;
		int result = 0;
		boolean odd = false; // n의 홀짝을 나타내는 필드

		if (n % 2 == 1) {
			odd = true;
		}

		// result에 합해주는 것을 처음과 끝부터 더해감
		while (i < j) {
			result += nums[i];
			result += nums[j];
			i += 2;
			j -= 2;
		}

		// n개수가 홀수이면 한 번 더 합해줘야 함(가운데 쌍)
		if (odd) {
			result += nums[i];
		}
		return result;
	}

	// 다른 사람 솔루션 2
	// 1개 <= 페어의 개수 <= 10000개
	// 투포인터로 푼 방법은 아닌 것 같다. 하지만 O(n) 풀이.
	// 공간 복잡도면에서 좋아보이지는 않는다.
	public int arrayPairSum2(int[] nums) {
		// 200001개의 int 배열 생성
		int[] exist = new int[20001];

		// -10000 <= nums[i] <= 10000
		// 0 <= nums[i] <= 20000
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i] + 10000]++;
		}

		// 앞에서부터 홀수번째만 sum에 더한다.
		int sum = 0;
		boolean odd = true;
		for (int i = 0; i < exist.length; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
	}
}
