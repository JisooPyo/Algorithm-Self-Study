package leetcode.al12;

import java.util.*;

public class HashTable13 {
    public static void main(String[] args) {
        HashTable13 h = new HashTable13();
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};

        String[] strs2 = {""};

        String[] strs3 = {"a"};

        // {{"bat"}, {"nat", "tan"}, {"ate", "eat", "tea"}}
        System.out.println(h.groupAnagrams(strs1));
        // {{""}}
        System.out.println(h.groupAnagrams(strs2));
        // {{"a"}}
        System.out.println(h.groupAnagrams(strs3));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // key: 문자열을 정렬한 상태
        // value: 정렬된 문자열에 맞는 실제 문자열들을 list에 저장
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(strs[i]);
        }

        // 반환할 list에 value 담기
        List<List<String>> answer = new ArrayList<>();
        for (String key : map.keySet()) {
            answer.add(map.get(key));
        }
        
        return answer;
    }
}
