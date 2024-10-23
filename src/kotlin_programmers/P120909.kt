package kotlin_programmers

import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * 프로그래머스 lv.0 제곱수 판별하기
 */
fun main() {
    val p = P120909()
    println(p.solution(144))        // 1
    println(p.solution(976))        // 2
}

class P120909 {
    fun solution(n: Int) =
        if (sqrt(n.toDouble()).toInt().toDouble().pow(2.0) == n.toDouble()) 1 else 2

    fun solutionOther(n: Int) =
        if (sqrt(n.toDouble()) == floor(sqrt(n.toDouble()))) 1 else 2
}
