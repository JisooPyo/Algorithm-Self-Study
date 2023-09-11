package programmers.test2309;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EnglishWordChainGame {
    public static void main(String[] args) {
        EnglishWordChainGame ewcg = new EnglishWordChainGame();
        String[] words1 = {"tank", "kick", "know", "wheel", "land",
                "dream", "mother", "robot", "tank"};
        // [3, 3]
        String[] words2 = {"hello", "observe", "effect", "take", "either",
                "recognize", "encourage", "ensure", "establish", "hang",
                "gather", "refer", "reference", "estimate", "executive"};
        // [0, 0]
        String[] words3 = {"hello", "one", "even", "never", "now",
                "world", "draw"};
        // [1, 3]

        System.out.println(Arrays.toString(ewcg.solution(3, words1)));
        System.out.println(Arrays.toString(ewcg.solution(5, words2)));
        System.out.println(Arrays.toString(ewcg.solution(2, words3)));
        System.out.println(Arrays.toString(ewcg.solution(2, new String[]{"ac", "ca", "ac", "ac"})));

    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> save = new HashMap<>();
        save.put(words[0], 1);
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            if (save.get(words[i]) != null) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            save.put(words[i], i % n + 1);
        }
        return answer;
    }
}
