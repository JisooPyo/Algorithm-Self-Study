package leetcode.al2412.week1

import kotlin.math.max

/**
 * Leetcode
 * 128. Longest Consecutive Sequence
 * Medium
 */
fun main() {
    val lcs = LongestConsecutiveSequence()
    println(lcs.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))           // 4
    println(lcs.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))   // 9
}

class LongestConsecutiveSequence {
    /**
     * Runtime: 58 ms(Beats: 79.06 %)
     * Time Complexity: O(n)
     *   - while 루프의 총 반복 횟수는 n을 넘을 수 없다.
     *
     * Memory: 62.65 MB(Beats: 10.48 %)
     * Space Complexity: O(n)
     */
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet: MutableSet<Int> = nums.toHashSet()
        val startSet: MutableSet<Int> = hashSetOf()

        // 수열의 시작점이 될 수 있는 수를 찾는다.
        for (num in numsSet) {
            if (!numsSet.contains(num - 1)) {
                startSet.add(num)
            }
        }
        var answer = 0
        for (start in startSet) {
            // 수열의 시작점부터 몇 개 까지 numsSet에 있는지 확인한다.
            var count = 0
            var first = start
            while (numsSet.contains(first)) {
                first++
                count++
            }
            // 최대 수열의 개수를 업데이트한다.
            answer = max(answer, count)
        }
        return answer
    }

    /**
     * 위 풀이에서 startSet을 제거하여 공간적으로 효율적인 풀이
     * Runtime: 63 ms(Beats: 65.70 %)
     * Time Complexity: O(n)
     *
     * Memory: 58.47 MB(Beats: 70.81 %)
     * Space Complexity: O(n)
     */
    fun longestConsecutive2(nums: IntArray): Int {
        val numsSet = nums.toHashSet()
        var maxLength = 0

        for (num in numsSet) {
            if (!numsSet.contains(num - 1)) {
                var currentNum = num
                var currentLength = 0

                while (numsSet.contains(currentNum)) {
                    currentLength++
                    currentNum++
                }
                maxLength = max(maxLength, currentLength)
            }
        }
        return maxLength
    }
}
