package leetcode.al2406;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Easy
 * 1002. Find Common Characters
 *
 * Given
 * words: 문자열 배열
 *
 * Return
 * 어떤 순서로든 상관없이 words 안 모든 문자열에서 보이는 모든 문자들의 집합(반복되어 나타나는 것 포함)을 구하라.
 */
public class Leet1002 {
    public static void main(String[] args) {
        Leet1002 l = new Leet1002();
        String[] words1 = {"bella", "label", "roller"};
        String[] words2 = {"cool", "lock", "cook"};

        // ["e","l","l"]
        System.out.println(l.commonChars(words1));
        // ["c","o"]
        System.out.println(l.commonChars(words2));
    }

    // 내 풀이
    // 더 쉽고 빠른 방법이 있지 않을까 했는데 내 풀이가 제일 빠른 풀이였다
    public List<String> commonChars(String[] words) {
        // 공통 문자를 카운트할 배열
        int[] common = new int[26];

        // 첫 문자열의 문자를 common에 기록
        String firstWord = words[0];
        for (int i = 0; i < firstWord.length(); i++) {
            common[firstWord.charAt(i) - 'a']++;
        }

        // 다른 문자열과 common 비교
        for (int i = 1; i < words.length; i++) {
            checkCommon(common, words[i]);
        }

        // 기록했었던 공통 문자 common을 문자열화 하여 List에 저장하여 반환
        List<String> list = new ArrayList<>();
        for (int i = 0; i < common.length; i++) {
            if (common[i] != 0) {
                for (int j = 0; j < common[i]; j++) {
                    list.add(String.valueOf((char)(i + 'a')));
                }
            }
        }

        return list;
    }

    private void checkCommon(int[] common, String word) {
        // word 문자 count에 기록
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }

        // common을 기준으로 0이 아닌 경우
        // common을 새로 문자열을 센 것과 이 전에 셌던 것을 비교하여 적은 값으로 업데이트
        for (int i = 0; i < common.length; i++) {
            if (common[i] != 0) {
                common[i] = Math.min(count[i], common[i]);
            }
        }
    }
}
