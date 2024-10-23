package kotlin_programmers

/**
 * 프로그래머스 lv.0 편지
 */
fun main() {
    val p = P120898()
    println(p.solution("happy birthday!"))  // 30
    println(p.solution("i love you~"))      // 22

}

class P120898 {
    fun solution(message: String) = message.length * 2
}
