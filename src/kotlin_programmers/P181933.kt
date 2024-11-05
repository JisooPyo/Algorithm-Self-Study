package kotlin_programmers

/**
 * 프로그래머스 lv.0 flag에 따라 다른 값 반환하기
 */
fun main() {
    val p = P181933()
    println(p.solution(-4, 7, true))        // 3
    println(p.solution(-4, 7, false))       // -11
}

class P181933 {
    fun solution(a: Int, b: Int, flag: Boolean) = if (flag) a + b else a - b


}
