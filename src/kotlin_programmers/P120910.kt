package kotlin_programmers

/**
 * 프로그래머스 lv.0 세균 증식
 */

fun main() {
    val p = P120910()
    println(p.solution(2, 10))      // 2048
    println(p.solution(7, 15))      // 229376
}

class P120910 {
    fun solution(n: Int, t: Int) = n * Math.pow(2.0, t.toDouble()).toInt()
}
