package kotlin_programmers


/**
 * Programmers lv.0 최댓값 만들기
 */

fun main() {
    val p = P120847()
    println(p.solution(intArrayOf(1, 2, 3, 4, 5)))          // 20
    println(p.solution(intArrayOf(0, 31, 24, 10, 1, 9)))    // 744
}

class P120847 {
    fun solution(numbers: IntArray): Int {
        val size: Int = numbers.size
        numbers.sort()
        return numbers[size - 1] * numbers[size - 2]
    }

    fun solutionOther(numbers: IntArray): Int =
        numbers.sorted().takeLast(2).fold(1) { i, acc -> acc * i }

    /**
     * .fold(1) { i, acc -> acc * i }: 마지막 두 개의 요소에 대해 fold 함수를 사용하여 곱셈 연산을 수행합니다.
     *     fold(1)은 초기 값을 1로 설정하여 시작합니다.
     *     { i, acc -> acc * i }에서 acc는 누적 값(이전 결과값)이고 i는 현재 요소입니다.
     *     이 표현식은 acc * i를 반복하여 모든 요소를 곱합니다.
     *     fold(1) { acc, i -> acc * i }는 1 * 5 * 8 = 40을 반환합니다.
     */


    fun solutionOther2(numbers: IntArray) =
        numbers.sorted().let { it[it.lastIndex] * it[it.lastIndex - 1] }
}
