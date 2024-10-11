package programmers.test2410

fun main() {
    val p = P120829()
    println(p.solution(70))     // 1
    println(p.solution(91))     // 3
    println(p.solution(180))     // 4
}

class P120829 {
    fun solution(angle: Int): Int {
        return when (angle) {
            in 1..89 -> 1
            90 -> 2
            180 -> 4
            else -> 3
        }
    }

    fun solutionOther(angle: Int) = when {
        (angle in 1..89) -> 1
        (angle == 90) -> 2
        (angle in 91..179) -> 3
        else -> 4
    }
}
