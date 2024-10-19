package programmers.test2410

/**
 * 프로그래머스 lv.0 두 수의 합
 */
fun main() {
    val p = P120802()
    println(p.solution(2, 3))   // 5
    println(p.solution(100, 2)) // 102
}

class P120802 {
    fun solution(num1: Int, num2: Int) = num1 + num2
}
