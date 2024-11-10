package kotlin_programmers

/**
 * 프로그래머스 lv.0 문자열 뒤집기
 */

fun main() {
    val p = P120822()
    println(p.solution("jaron"))    // "noraj"
    println(p.solution("bread"))    // "daerb"
}

class P120822 {
    fun solution(my_string: String): String = my_string.reversed()
}
