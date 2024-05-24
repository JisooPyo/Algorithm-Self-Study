package leetcode.al2405;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1255. Maximum Score Words Formed by Letters
 *
 * Given
 * words: 문자열 배열
 * letters: 문자 배열
 * score: 모든 문자에 대한 점수 배열
 *
 * Return
 * 주어진 letters의 문자를 이용하여 words 내의 단어를 만들었을 때 가능한 가장 높은 점수를 구하라.
 *
 * Note
 * 'a', 'b', 'c', 'd',...의 점수는 score[0], score[1], score[2], score[3], ...이다.
 * letters의 문자를 모두 이용할 필요는 없다.
 */
public class Leet1255 {
    public static void main(String[] args) {
        Leet1255 l = new Leet1255();

        String[] words1 = {"dog", "cat", "dad", "good"};
        char[] letters1 = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score1 = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        String[] words2 = {"xxxz", "ax", "bx", "cx"};
        char[] letters2 = {'z', 'a', 'b', 'c', 'x', 'x', 'x'};
        int[] score2 = {4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};

        String[] words3 = {"leetcode"};
        char[] letters3 = {'l', 'e', 't', 'c', 'o', 'd'};
        int[] score3 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};

        System.out.println(l.maxScoreWords(words1, letters1, score1));  // 23
        System.out.println(l.maxScoreWords(words2, letters2, score2));  // 27
        System.out.println(l.maxScoreWords(words3, letters3, score3));  // 0
    }

    // 내 풀이(1ms)
    // words의 길이가 최대 14이므로 부분집합을 구하여 푼다!
    int maxScore;
    int[] score;
    String[] words;
    int[] wordScore;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        // letter Arr에 저장
        int[] letterCount = new int[26];
        for (char ch : letters) {
            letterCount[ch - 'a']++;
        }

        // word마다 점수 구하기 - 만들 수 없으면 0
        wordScore = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (canMake(words[i], letterCount)) {
                wordScore[i] = getScore(words[i]);
            }
        }


        maxScore = 0;
        res(0, 0, letterCount);

        return maxScore;
    }

    // 부분집합 구하기
    private void res(int cur, int start, int[] letterCount) {
        for (int i = start; i < words.length; i++) {
            if (wordScore[i] == 0) {
                continue;
            }
            if (canMake(words[i], letterCount)) {
                int[] copied = afterMakingWord(words[i], letterCount);
                res(cur + wordScore[i], i + 1, copied);
            }
        }
        maxScore = Math.max(maxScore, cur);
    }

    // 단어 만큼의 count 빼기
    private int[] afterMakingWord(String word, int[] letterCount) {
        int[] copied = Arrays.copyOf(letterCount, letterCount.length);
        for (int i = 0; i < word.length(); i++) {
            copied[word.charAt(i) - 'a']--;
        }
        return copied;
    }

    // 단어 점수 구하기
    private int getScore(String word) {
        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            ans += score[word.charAt(i) - 'a'];
        }
        return ans;
    }

    // letterCount를 보고 word 를 만들 수 있는지 boolean으로 return
    private boolean canMake(String word, int[] letterCount) {
        int[] wordCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            wordCount[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < wordCount.length; i++) {
            if (wordCount[i] > letterCount[i]) {
                return false;
            }
        }
        return true;
    }
}
