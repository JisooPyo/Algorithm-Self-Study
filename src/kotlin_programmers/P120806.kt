package kotlin_programmers

fun main() {
    val p = P120806()
    println(p.solution(3, 2))   // 1500
    println(p.solution(7, 3))   // 2333
    println(p.solution(1, 16))   // 62
}

class P120806 {
    fun solution(num1: Int, num2: Int): Int {
        return ((num1.toDouble() / num2) * 1000).toInt()
    }
}
