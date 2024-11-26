package kotlin_programmers

/**
 * 프로그래머스 lv.0 n의 배수
 */
fun main() {
    val p = P181937()

    println(p.solution(98, 2))      // 1
    println(p.solution(34, 3))      // 0
}

class P181937 {
    fun solution(num: Int, n: Int) = if (num % n == 0) 1 else 0
}
