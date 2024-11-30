package kotlin_programmers

/**
 * 프로그래머스 lv.0 중앙값 구하기
 */
fun main() {
    val p = P120811()
    println(p.solution(intArrayOf(1, 2, 7, 10, 11)))    // 7
    println(p.solution(intArrayOf(9, -1, 0)))           // 0
}

class P120811 {
    fun solution(array: IntArray) = array.sortedArray()[array.size / 2]

    fun solutionOther(array: IntArray) = array.sorted()[array.size / 2]
}
