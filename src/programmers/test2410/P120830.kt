package programmers.test2410

/**
 * 프로그래머스 lv.0 양꼬치
 */
fun main() {
    val p = P120830()
    println(p.solution(10, 3))      // 124,000
    println(p.solution(64, 6))      // 768,000
}

class P120830 {
    fun solution(n: Int, k: Int) = n * 12000 + (k - n / 10) * 2000
}
