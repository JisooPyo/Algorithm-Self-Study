package leetcode.al2408;

import java.util.Arrays;

/**
 * Medium
 * 3016. Minimum Number of Pushes to Type Word II
 *
 * 영소문자로 이루어진 문자열 word가 주어집니다.
 *
 * 전화번호 키패드는 서로 다른 영소문자의 조합들과 매칭됩니다.
 * 키패드를 누름으로써 단어들을 만들 수 있습니다.
 * 예를 들어서, key 2가 ["a", "b", "c"]와 맵핑되어 있으면,
 * 한 번 누르면 "a", 두 번 누르면 "b", 세 번 누르면 "c"를 만들 수 있습니다.
 *
 * key 는 2부터 9까지의 숫자로 다시 맵핑할 수 있습니다.
 * key 들은 어떤 양의 문자들로도 맵핑될 수 있습니다.
 * 하지만 한 문자는 반드시 한 key 와 맵핑되어야 합니다.
 * key 를 다시 매핑하고 word 를 만들기 위해 눌러야 하는 가장 적은 push 수를 구하세요.
 *
 * 주의. 1, *, #, 0은 맵핑하지 않습니다.
 */
public class Leet3016 {
    public static void main(String[] args) {
        Leet3016 leet3016 = new Leet3016();

        System.out.println(leet3016.minimumPushes("abcde"));    // 5
        System.out.println(leet3016.minimumPushes("xyzxyzxyzxyz")); // 12
        System.out.println(leet3016.minimumPushes("aabbccddeeffgghhiiiiii"));   // 24
    }

    // 내 풀이: 8ms
    public int minimumPushes(String word) {
        // 1. 문자별 출현 수 구하기
        int[] count = new int[26];
        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }

        // 2. 출현 수 별로 정렬
        Arrays.sort(count);

        // 3. 답 구하기
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (i <= 1) {
                res += count[i] * 4;
            } else if (i <= 9) {
                res += count[i] * 3;
            } else if (i <= 17) {
                res += count[i] * 2;
            } else {
                res += count[i];
            }
        }

        return res;
    }

}
// 0  1                    - * 4
// 2  3  4  5  6  7  8  9  - * 3
// 10 11 12 13 14 15 16 17 - * 2
// 18 19 20 21 22 23 24 25 - * 1