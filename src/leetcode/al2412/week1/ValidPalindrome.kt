package leetcode.al2412.week1

/**
 * Leetcode
 * 125. Valid Palindrome
 * Easy
 */
fun main() {
    val vp = ValidPalindrome()
    println(vp.isPalindrome("A man, a plan, a canal: Panama"))      // true
    println(vp.isPalindrome("race a car"))                          // false
    println(vp.isPalindrome(" "))                                   // true
}

class ValidPalindrome {
    /**
     * Runtime: 4 ms(Beats: 98.27 %)
     * Time Complexity: O(n)
     *
     * Memory: 38.22 MB(Beats: 46.74 %)
     * Space Complexity: O(1)
     */
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left <= right) {
            when (s[left]) {
                // 왼쪽의 문자가 alphanumeric일 때
                in 'a'..'z', in 'A'..'Z', in '0'..'9' -> {

                    when (s[right]) {
                        // 오른쪽의 문자가 alphanumeric일 때
                        in 'a'..'z', in 'A'..'Z', in '0'..'9' -> {
                            // 문자 비교
                            if (s[left].equals(s[right], true)) {
                                left++
                                right--
                                continue
                            } else {
                                return false
                            }
                        }
                        // 오른쪽의 문자가 alphanumeric이 아닐 때
                        else -> {
                            right--
                            continue
                        }
                    }
                }

                // 왼쪽의 문자가 alphanumeric이 아닐 때
                else -> {
                    left++
                    continue
                }
            }
        }
        return true
    }

    /**
     * 개선한 버전
     * Runtime: 5 ms(Beats: 87.14 %)
     * Time Complexity: O(n)
     *
     * Memory: 37.76 MB(Beats: 61.52 %)
     * Space Complexity: O(1)
     */
    fun isPalindrome2(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            // 왼쪽에서 유효한 문자를 찾음
            while (left < right && !s[left].isLetterOrDigit()) {
                left++
            }

            // 오른쪽에서 유효한 문자를 찾음
            while (left < right && !s[right].isLetterOrDigit()) {
                right--
            }

            // 문자 비교
            if (!s[left].equals(s[right], ignoreCase = true)) {
                return false
            }

            left++
            right--
        }
        return true
    }
}
