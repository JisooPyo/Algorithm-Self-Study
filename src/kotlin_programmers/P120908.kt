package kotlin_programmers

/**
 * 프로그래머스 lv.0 문자열안에 문자열
 */
fun main() {
    val p = P120908()
    println(p.solution("ab6CDE443fgh22iJKlmn1o", "6CD"))    // 1
    println(p.solution("ppprrrogrammers", "pppp"))          // 2
    println(p.solution("AbcAbcA", "AAA"))                   // 2
}

class P120908 {
    fun solution(str1: String, str2: String) = if (str1.contains(str2)) 1 else 2

    fun solutionOther(str1: String, str2: String) = if (str2 in str1) 1 else 2
}
