package kotlin_programmers

/**
 * 프로그래머스 lv.0 자릿수 더하기
 */
fun main() {
    val p = P120906()
    println(p.solution(1234))       // 10
    println(p.solution(930211))     // 16
}

class P120906 {
    fun solution(n: Int): Int {
        var answer = 0
        var n2 = n
        while (n2 > 0) {
            answer += n2 % 10
            n2 /= 10
        }
        return answer
    }

    fun solutionOther(n: Int) =
        n.toString()
            .toList()   // -> List<Char>
            .sumOf { it.digitToInt() }
}
