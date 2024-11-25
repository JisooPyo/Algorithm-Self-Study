package kotlin_programmers

/**
 * Programmers lv.0 점의 위치 구하기
 */
fun main() {
    val p = P120841()
    println(p.solution(intArrayOf(2, 4)))       // 1
    println(p.solution(intArrayOf(-7, 9)))      // 2
}

class P120841 {
    fun solution(dot: IntArray): Int {
        return if (dot[0] > 0) {
            if (dot[1] > 0) 1 else 4
        } else {
            if (dot[1] > 0) 2 else 3
        }
    }

    fun solutionOther(dot: IntArray) = when {
        (dot[0] > 0 && dot[1] > 0) -> 1
        (dot[0] < 0 && dot[1] > 0) -> 2
        (dot[0] < 0 && dot[1] < 0) -> 3
        else -> 4
    }
}
