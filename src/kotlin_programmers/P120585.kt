package kotlin_programmers

/**
 * Programmers lv.0 머쓱이보다 키 큰 사람
 */
fun main() {
    val p = P120585()
    println(p.solution(intArrayOf(149, 180, 192, 170), 167))     // 3
    println(p.solution(intArrayOf(180, 120, 140), 190))          // 0
}

class P120585 {
    fun solution(array: IntArray, height: Int) = array.count { it > height }

    fun solutionOther(array: IntArray, height: Int) = array.filter { it > height }.size
}
