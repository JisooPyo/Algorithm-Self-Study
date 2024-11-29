package kotlin_programmers

/**
 * 프로그래머스 lv.0 배열 두 배 만들기
 */
fun main() {
    val p = P120809()
    println(p.solution(intArrayOf(1, 2, 3, 4, 5)).contentToString())              // [2, 4, 6, 8, 10]
    println(p.solution(intArrayOf(1, 2, 100, -99, 1, 2, 3)).contentToString())    // [2, 4, 200, -198, 2, 4, 6]

}

class P120809 {
    fun solution(numbers: IntArray) = numbers.map { it * 2 }.toIntArray()
}
