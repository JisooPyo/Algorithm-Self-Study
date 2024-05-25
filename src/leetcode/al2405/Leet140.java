package leetcode.al2405;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 140. Word Break II(Hard)
 *
 * Given
 * s: 문자열
 * wordDict: 문자열 사전
 *
 * Return
 * s에 공간을 만들어 각 단어가 유효한 단어인 문장을 만들어라.
 * 모든 가능한 문장을 반환하라.(순서는 상관없음)
 *
 * Note
 * 사전에 있는 단어는 여러 번 재사용 가능하다.
 */
public class Leet140 {
    public static void main(String[] args) {
        Leet140 l = new Leet140();

        String s1 = "catsanddog";
        String[] arr1 = {"cat", "cats", "and", "sand", "dog"};
        List<String> list1 = Arrays.stream(arr1).toList();

        String s2 = "pineapplepenapple";
        String[] arr2 = {"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> list2 = Arrays.stream(arr2).toList();

        String s3 = "catsandog";
        String[] arr3 = {"cats", "dog", "sand", "and", "cat"};
        List<String> list3 = Arrays.stream(arr3).toList();

        // ["cats and dog","cat sand dog"]
        System.out.println(l.wordBreak(s1, list1));
        // ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
        System.out.println(l.wordBreak(s2, list2));
        // []
        System.out.println(l.wordBreak(s3, list3));
    }

    // 내 풀이(1ms)
    // 하나하나 재귀로 가능한지 확인하는 것.
    String s;
    List<String> wordDict;
    List<String> list;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        res(0, sb);
        return list;
    }

    private void res(int start, StringBuilder sb) {
        if (start == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (presentWordAt(start, word)) {
                StringBuilder copied = new StringBuilder(sb);
                copied.append(word);
                copied.append(' ');
                res(start + word.length(), copied);
            }
        }
    }

    private boolean presentWordAt(int start, String word) {
        if (s.length() - start < word.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (s.charAt(start++) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // 다른 사람의 풀이에서는 단어를 Set에 저장한 뒤,
    // 확인하려는 단어를 사전에 있는 단어만큼 잘라서 set에 있는지 확인함으로써 그 단어로 시작하는지 체크했다.
}
