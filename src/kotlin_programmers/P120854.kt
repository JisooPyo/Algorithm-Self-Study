package kotlin_programmers

/**
 * 프로그래머스 lv.0 배열 원소의 길이
 */
fun main() {
    val p = P120854()

    val strlist1: Array<String> = arrayOf("We", "are", "the", "world!")
    val strlist2: Array<String> = arrayOf("I", "Love", "Programmers.")

    println(p.solution(strlist1).contentToString())     // [2, 3, 3, 6]
    println(p.solution(strlist2).contentToString())     // [1, 4, 12]
}

class P120854 {
    fun solution(strlist: Array<String>): IntArray {
        var answer = IntArray(strlist.size)
        strlist.forEachIndexed { index, s -> answer[index] = s.length }
        return answer
    }

    fun solutionOther(strList: Array<String>) = strList.map { it.length }.toIntArray()

}
