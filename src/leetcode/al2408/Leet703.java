package leetcode.al2408;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * 703. Kth Largest Element in a Stream
 *
 * 다음은 주어진 스트림에서 `k번째`로 큰 요소를 찾는 클래스를 설계하라는 내용입니다.
 * 여기서 중요한 점은 `k번째` 큰 요소가 정렬된 순서에서의 `k번째` 요소이지,
 * 중복을 제거한 고유한 요소는 아니라는 점입니다.
 *
 * `KthLargest` 클래스는 다음과 같이 구현되어야 합니다:
 * - `KthLargest(int k, int[] nums)`: 정수 `k`와 정수 배열 `nums`로 객체를 초기화합니다.
 * - `int add(int val)`: 정수 `val`을 스트림에 추가하고, 스트림에서 `k번째`로 큰 요소를 반환합니다.
 *
 */
// 내 풀이: 772ms
// 다른 사람 풀이: 12ms -> PriorityQueue 이용.
public class Leet703 {
    class KthLargest {
        int k;
        int[] nums;
        List<Integer> list;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.nums = nums;
            list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
        }

        public int add(int val) {
            list.add(val);
            list.sort((a, b) -> b - a);
            return list.get(k - 1);
        }
    }
}
