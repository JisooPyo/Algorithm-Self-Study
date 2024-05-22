package leetcode.al2405;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning - Medium
 *
 * Given
 * s : 문자열
 *
 * 파티션 s는 모든 파티션의 substring이 palindrome인 것을 의미한다.
 *
 * Return
 * 모든 가능한 s의 팰린드롬 파티셔닝을 구하라.
 */
public class Leet131 {
    public static void main(String[] args) {
        Leet131 l = new Leet131();
        System.out.println(l.partition("aab"));
        System.out.println(l.partition("a"));
    }

    // 어제와 그제 풀었던 문제처럼 재귀를 이용해서 풀면 되는 문제 같았다.
    // 내 풀이 - 12ms
    // 1. 다른 사람의 풀이 중에서 더 빨랐던 풀이는 초반에 String s를 전역변수 StringBuilder로 저장해서 좀 더 빨랐던 것 같다.
    // 2. 일일이 다 substring 하지 않고 같은 s에서 index만 뽑아 palindrome인지 아닌지 확인할 수 있었다.
    List<List<String>> list;
    String s;
    int len;

    public List<List<String>> partition(String s) {
        list = new ArrayList<>();
        this.s = s;
        this.len = s.length();
        List<String> strList = new ArrayList<>();
        res(0, strList);
        return list;
    }

    private void res(int start, List<String> strList) {
        if (start == len) {
            list.add(strList);
            return;
        }
        for (int i = start + 1; i <= len; i++) {
            String sub = s.substring(start, i);
            if (isPalindrome(sub)) {
                List<String> copiedList = new ArrayList<>(strList);
                copiedList.add(sub);
                res(i, copiedList);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i <= len / 2 - 1; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
