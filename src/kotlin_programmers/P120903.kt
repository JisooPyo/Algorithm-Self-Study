package kotlin_programmers

/**
 * 프로그래머스 lv.0 배열의 유사도
 */
fun main() {
    val p = P120903()

    // 2
    println(p.solution(arrayOf("a", "b", "c"), arrayOf("com", "b", "d", "p", "c")))
    // 0
    println(p.solution(arrayOf("n", "omg"), arrayOf("m", "dot")))
}

class P120903 {
    fun solution(s1: Array<String>, s2: Array<String>) = s1.intersect(s2.toSet()).size

    fun solutionOther(s1: Array<String>, s2: Array<String>) = s1.map(s2::contains).count { it }

    fun solutionOther2(s1: Array<String>, s2: Array<String>): Int = s1.count { s2.contains(it) }
}
