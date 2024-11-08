package kotlin_programmers

/**
 * 프로그래머스 lv.0 배열 뒤집기
 */
fun main() {
    val p = P120821()

    // [5, 4, 3, 2, 1]
    println(p.solution(intArrayOf(1, 2, 3, 4, 5)).contentToString())
    // [2, 1, 1, 1, 1, 1]
    println(p.solution(intArrayOf(1, 1, 1, 1, 1, 2)).contentToString())
    // [5, 3, 1, 1, 1, 0, 1]
    println(p.solution(intArrayOf(1, 0, 1, 1, 1, 3, 5)).contentToString())
}

class P120821 {
    fun solution(num_list: IntArray): IntArray {
        for (index in num_list.indices) {
            if (index > (num_list.size - 1) / 2) {
                break
            }
            val temp = num_list[index]
            num_list[index] = num_list[num_list.size - index - 1]
            num_list[num_list.size - index - 1] = temp
        }
        return num_list
    }

    fun solutionOther(numList: IntArray) = numList.reversedArray()
}
