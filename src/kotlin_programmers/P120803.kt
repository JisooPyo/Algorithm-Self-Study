package kotlin_programmers

fun main() {
    println(solution(2, 3))     // -1
    println(solution(100, 2))   // 98
}

private fun solution(num1: Int, num2: Int): Int {
    return num1 - num2
}
