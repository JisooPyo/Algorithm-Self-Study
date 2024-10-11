package programmers.test2410

fun main() {
    println(solution(3, 2))     // 1
    println(solution(10, 5))     // 0
}

private fun solution(num1: Int, num2: Int): Int {
    return num1 % num2
}
