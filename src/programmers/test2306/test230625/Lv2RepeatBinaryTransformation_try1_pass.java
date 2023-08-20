package programmers.test2306.test230625;

import java.util.Arrays;

public class Lv2RepeatBinaryTransformation_try1_pass {
    public static void main(String[] args) {
        Lv2RepeatBinaryTransformation_try1_pass lv = new Lv2RepeatBinaryTransformation_try1_pass();
        String t1 = "110010101001";
        String t2 = "01110";
        String t3 = "1111111";

        System.out.println(Arrays.toString(lv.solution(t1)));
        System.out.println(Arrays.toString(lv.solution(t2)));
        System.out.println(Arrays.toString(lv.solution(t3)));

    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!(s.equals("1"))) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                }
            }
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        return answer;
    }

}
/*
테스트 1 〉통과 (0.26ms, 74.9MB)
테스트 2 〉통과 (44.26ms, 89.1MB)
테스트 3 〉통과 (0.18ms, 67.9MB)
테스트 4 〉통과 (0.18ms, 80.5MB)
테스트 5 〉통과 (0.15ms, 86.5MB)
테스트 6 〉통과 (0.93ms, 93.9MB)
테스트 7 〉통과 (3.76ms, 66.6MB)
테스트 8 〉통과 (2.53ms, 72.2MB)
테스트 9 〉통과 (15.05ms, 72MB)
테스트 10 〉통과 (37.90ms, 86.2MB)
테스트 11 〉통과 (41.56ms, 83.2MB)
 */