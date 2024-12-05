package leetcode.al2412.week1

/**
 * Leetcode
 * 217. Contains Duplicate
 * Easy
 */
fun main() {
    val cd = ContainsDuplicate()
    println(cd.containsDuplicate(intArrayOf(1, 2, 3, 1)))                       // true
    println(cd.containsDuplicate(intArrayOf(1, 2, 3, 4)))                       // false
    println(cd.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))     // true
}

/**
 * Runtime: 17 ms(Beats: 80.99 %)
 * Time Complexity: O(n)
 *   - 배열 순회
 *
 * Memory: 50.63 MB(Beats: 70.32 %)
 * Space Complexity: O(n)
 *   - HashSet에 최악의 경우 배열 원소 모두 저장
 */
class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = hashSetOf<Int>()
        for (i in nums) {
            if (set.contains(i)) {
                return true
            }
            set.add(i)
        }
        return false
    }
}
