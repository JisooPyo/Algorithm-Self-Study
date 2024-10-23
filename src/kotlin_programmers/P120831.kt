package kotlin_programmers

/**
 * 프로그래머스 lv.0 짝수의 합
 */
fun main() {
    println(solution(10))   // 30
    println(solution(4))    // 6
}

fun solution(n: Int): Int {
    var answer = 0

    for (i in 1..n / 2) {
        answer += i * 2
    }

    return answer
}

fun solutionOther(n: Int) = (0..n).filter { it % 2 == 0 }.sum()
