package kotlin_programmers

/**
 * Programmers lv.0 문자열 곱하기
 */
fun main() {
    val p = P181940()

    // "stringstringstring"
    println(p.solution("string", 3))

    // "lovelovelovelovelovelovelovelovelovelove"
    println(p.solution("love", 10))
}

class P181940 {
    fun solution(my_string: String, k: Int) = my_string.repeat(k)
}
