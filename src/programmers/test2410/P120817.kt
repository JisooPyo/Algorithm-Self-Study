package programmers.test2410

/**
 * 프로그래머스 lv.0 배열의 평균값
 */
fun main() {
    val p = P120817()
    println(p.solution(IntArray(10) { it + 1 }))     // 5.5
    println(p.solution(IntArray(11) { it + 89 }))    // 94.0
}

class P120817 {
    fun solution(numbers: IntArray) = numbers.sum() / numbers.size.toDouble()

    fun solutionOther(numbers: IntArray) = numbers.average()
}
