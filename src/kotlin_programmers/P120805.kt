package kotlin_programmers

fun main() {
    val p = P120805()
    println(p.solution(10, 5))      // 2
    println(p.solution(7, 2))       // 3
}

class P120805 {
    fun solution(num1: Int, num2: Int): Int = num1 / num2
}
