package kotlin_programmers

/**
 * Programmers: 중복된 숫자 개수
 */
fun main() {
    val p = P120583()

    val arr1 = intArrayOf(1, 1, 2, 3, 4, 5)
    val arr2 = intArrayOf(0, 2, 3, 4)

    println(p.solution(arr1, 1))     // 2
    println(p.solution(arr2, 1))     // 0
}

class P120583 {
    fun solution(array: IntArray, n: Int) =
        array.count { element -> element == n }
}
