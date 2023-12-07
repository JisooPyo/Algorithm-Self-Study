package programmers.test2312;

import java.util.HashMap;
import java.util.Map;

public class VowelDictionary {
    public static void main(String[] args) {
        VowelDictionary v = new VowelDictionary();

        String word1 = "AAAAE";     // 6
        String word2 = "AAAE";      // 10
        String word3 = "I";         // 1563
        String word4 = "EIO";       // 1189

        System.out.println(v.solution(word1));
        System.out.println(v.solution(word2));
        System.out.println(v.solution(word3));
        System.out.println(v.solution(word4));
    }

    Map<Character, Integer> number;

    public int solution(String word) {
        addNumber();
        char[] chars = word.toCharArray();
        int[] multiple = {781, 156, 31, 6, 1};
        int answer = 0;
        for (int i = 0; i < chars.length; i++) {
            answer += multiple[i] * number.get(chars[i]);
            answer += 1;
        }
        return answer;
    }

    private void addNumber() {
        number = new HashMap<>();
        number.put('A', 0);
        number.put('E', 1);
        number.put('I', 2);
        number.put('O', 3);
        number.put('U', 4);
    }


}
