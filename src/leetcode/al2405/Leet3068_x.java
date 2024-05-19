package leetcode.al2405;

/**
 * 3068. Find the Maximum Sum of Node Values(Hard)
 *
 * 여기에 0부터 n - 1까지 넘버링되는 n개의 방향성없는 노드들이 있다.
 *
 * Given
 * edges : n - 1 길이의 0-indexed 2D 정수 배열
 *        edges[i] = [ui, vi]는 트리의 ui와 vi가 연결되어 있음을 의미한다.
 * k : 양의 정수
 * nums : 길이 n의 0-indexed 음이 아닌 정수 배열
 *        nums[i]는 i로 넘버링된 노드의 값을 의미한다.
 *
 * 앨리스는 트리에서 몇 번이든 다음 연산을 적용해서(0번 포함) 트리 노드들의 값의 합이 최대값이 되기를 원한다.
 * - 연결되어 있는 노드 u와 v를 골라 다음과 같이 값을 업데이트한다.
 *   - nums[u] = nums[u] XOR k
 *   - nums[v] = nums[v] XOR k
 *
 * Return
 * 몇 번이든 연산을 적용했을 때(0번 포함) 앨리스가 얻을 수 있는 가능한 가장 최대 합을 구하라.
 */
public class Leet3068_x {
    public static void main(String[] args) {
        Leet3068_x l = new Leet3068_x();
        int[] nums1 = {1, 2, 1};
        int[][] edges1 = {{0, 1}, {0, 2}};
        int[] nums2 = {2, 3};
        int[][] edges2 = {{0, 1}};
        int[] nums3 = {7, 7, 7, 7, 7, 7};
        int[][] edges3 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}};

        int[] nums4 = {78, 43, 92, 97, 95, 94};
        int[][] edges4 = {{1, 2}, {3, 0}, {4, 0}, {0, 1}, {1, 5}};

        // System.out.println(l.maximumValueSum(nums1, 3, edges1));     // 6
        // System.out.println(l.maximumValueSum(nums2, 7, edges2));     // 9
        // System.out.println(l.maximumValueSum(nums3, 3, edges3));     // 42
        System.out.println(l.maximumValueSum(nums4, 6, edges4));    // 507
        int k = 6;
        System.out.println("78 ^ k = " + (78 ^ k));
        System.out.println("43 ^ k = " + (43 ^ k));
        System.out.println("92 ^ k = " + (92 ^ k));
        System.out.println("97 ^ k = " + (97 ^ k));
        System.out.println("95 ^ k = " + (95 ^ k));
        System.out.println("94 ^ k = " + (94 ^ k));
    }

    // 내 풀이
    // edges를 돌면서 xor한 값과 아닌 값을 비교해서 크면 바꾸고 작으면 바꾸지 않는다
    // -> 발생한 문제: 0-1, 0-2 둘 다 바꾸면 이득인데 개개로 보면 이득이 아니라서 바꾸고 지나치는 부분 발생.

    // 다른 사람의 풀이
    // https://leetcode.com/problems/find-the-maximum-sum-of-node-values/solutions/5176685/fastest-100-video-explanation-easy-to-understand
    // 으악 이해가 잘 안된다... ;ㅅ;
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;      // XOR 연산 후 요소의 총합
        int count = 0;              // XOR 연산으로 증가된 요소 수
        int positiveMin = Integer.MAX_VALUE;
        int negativeMax = Integer.MIN_VALUE;

        for (int nodeValue : nums) {
            //
            int nodeValAfterOperation = nodeValue ^ k;
            totalSum += nodeValue;

            int netChange = nodeValAfterOperation - nodeValue;

            if (netChange > 0) {    // XOR 연산 결과가 더 높은 값이 된 경우
                positiveMin = Math.min(positiveMin, netChange);
                totalSum += netChange;
                count += 1;
            } else {
                negativeMax = Math.max(negativeMax, netChange);
            }
        }

        if (count % 2 == 0) {
            return totalSum;
        }
        return Math.max(totalSum - positiveMin, totalSum + negativeMax);
    }
}
