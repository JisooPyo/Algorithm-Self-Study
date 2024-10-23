package kotlin_programmers

fun main() {
    val p = P120804()
    println(p.solution(3, 4))       // 12
    println(p.solution(27, 19))     // 513
}

class P120804 {
    fun solution(num1: Int, num2: Int) = num1 * num2
}
