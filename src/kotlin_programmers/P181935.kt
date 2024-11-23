package kotlin_programmers

import kotlin.math.pow

/**
 * Programmers lv.0 홀짝에 따라 다른 값 반환하기
 */
fun main() {
    val p = P181935()

    println(p.solution(7))      // 16
    println(p.solution(10))     // 220
}

class P181935 {
    fun solution(n: Int): Int {
        return if (n % 2 == 0) {
            1.rangeTo(n).filter { it % 2 == 0 }.sumOf { it * it }
        } else {
            1.rangeTo(n).filter { it % 2 == 1 }.sum()
        }
    }

    fun solutionOther(n: Int) =
        if (n % 2 != 0) (1..n step 2).sum()
        else (2..n step 2).sumOf { it.toDouble().pow(2.0) }.toInt()

    fun solutionOther2(n: Int): Int {
        return if (n % 2 == 0) {
            (n downTo 1 step 2).sumOf { it * it }
        } else {
            (n downTo 1 step 2).sum()
        }
    }
}
