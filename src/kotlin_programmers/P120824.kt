package kotlin_programmers

import kotlin.system.measureTimeMillis

/**
 * Programmers lv.0 짝수 홀수 개수
 */
fun main() {
    val p = P120824()

    val arr1 = intArrayOf(1, 2, 3, 4, 5)
    val arr2 = intArrayOf(1, 3, 5, 7)

    println(p.solution(arr1).contentToString())       // [2, 3]
    println(p.solution(arr2).contentToString())       // [0, 4]
    println(p.solution2(arr1).contentToString())       // [2, 3]
    println(p.solution2(arr2).contentToString())       // [0, 4]
    println(p.solution3(arr1).contentToString())       // [2, 3]
    println(p.solution3(arr2).contentToString())       // [0, 4]

    // 시간 테스트
    val testArr = IntArray(100_000_000)

    val time1 = measureTimeMillis { p.solution(testArr) }
    val time2 = measureTimeMillis { p.solution2(testArr) }
    val time3 = measureTimeMillis { p.solution3(testArr) }

    println("solution execution time: $time1 ms")       // 70ms
    println("solution2 execution time: $time2 ms")      // 40ms
    println("solution3 execution time: $time3 ms")      // 1038ms
}

class P120824 {
    // 풀이 1
    // 짧지만, count 시에 아마 배열을 한 번 돌 것이므로 배열을 두 번 돌아 비효율적이라고 생각되어짐.
    fun solution(num_list: IntArray) = intArrayOf(
        num_list.count { it % 2 == 0 },
        num_list.count { it % 2 == 1 }
    )

    // 풀이 2
    // for문을 이용하여 배열을 한 번만 돌면서 해결할 수 있지만 길이가 길어짐
    fun solution2(num_list: IntArray): IntArray {
        val arr = IntArray(2)
        for (i in num_list) {
            if (i % 2 == 0) {
                arr[0]++
            } else {
                arr[1]++
            }
        }
        return arr
    }

    // 풀이 3
    // GPT에게 풀이 2 리팩터링을 해달라고 했을 때 --> 느리다!
    // partition은 조건에 맞는 요소와 그렇지 않은 요소를 Pair로 반환.
    fun solution3(num_list: IntArray): IntArray {
        val (even, odd) = num_list.partition { it % 2 == 0 }
        return intArrayOf(even.size, odd.size)
    }
}
