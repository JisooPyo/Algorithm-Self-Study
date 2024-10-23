package kotlin_programmers

fun main() {
    val p = P120807()
    println(p.solution(2, 3))   // -1
    println(p.solution(11, 11))   // 1
    println(p.solution(7, 99))   // -1
}

class P120807 {
    fun solution(num1: Int, num2: Int): Int = if (num1 == num2) 1 else -1
}
