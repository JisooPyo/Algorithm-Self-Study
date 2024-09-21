package bookStudy.study2409;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 lv.2
 * 20. 할인 행사
 */
public class Problem20 {
    public static void main(String[] args) {
        Problem20 p = new Problem20();

        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = {3, 2, 2, 2, 1};
        String[] discount1 = {
            "chicken", "apple", "apple", "banana", "rice",
            "apple", "pork", "banana", "pork", "rice",
            "pot", "banana", "apple", "banana"
        };

        String[] want2 = {"apple"};
        int[] number2 = {10};
        String[] discount2 = {
            "banana", "banana", "banana", "banana", "banana",
            "banana", "banana", "banana", "banana", "banana"
        };

        System.out.println(p.solution(want1, number1, discount1));  // 3
        System.out.println(p.solution(want2, number2, discount2));  // 0
    }

    // 책 풀이
    // want 배열과 number 배열을 이용하여 Map 만들기
    // 10칸 단위의 Map 만들기
    // 비교하여 같으면 answer++
    // 책 풀이에서 Map끼리 비교하는 건 좋은 거 같다!
    // 하지만 10칸 단위의 Map을 만들기보다 Sliding window로 풀었음 좋았을 듯!

    // 내 풀이
    Map<String, Integer> map;
    String[] want;
    int[] number;

    public int solution(String[] want, int[] number, String[] discount) {
        this.want = want;
        this.number = number;

        // 10일간 살 수 있는 품목
        this.map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }

        // sliding window
        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            if (canSignup()) {
                answer++;
            }
            if (i == discount.length - 10) {
                break;
            }
            map.put(discount[i], map.get(discount[i]) - 1);
            map.put(discount[i + 10], map.getOrDefault(discount[i + 10], 0) + 1);
        }
        return answer;
    }

    private boolean canSignup() {
        for (int i = 0; i < want.length; i++) {
            if (map.getOrDefault(want[i], 0) != number[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
테스트 1 〉	통과 (5.18ms, 101MB)
테스트 2 〉	통과 (32.91ms, 114MB)
테스트 3 〉	통과 (11.35ms, 99.2MB)
테스트 4 〉	통과 (40.38ms, 109MB)
테스트 5 〉	통과 (26.70ms, 108MB)
테스트 6 〉	통과 (6.81ms, 95.8MB)
테스트 7 〉	통과 (9.29ms, 98MB)
테스트 8 〉	통과 (29.91ms, 123MB)
테스트 9 〉	통과 (7.98ms, 96.3MB)
테스트 10 〉	통과 (21.21ms, 117MB)
테스트 11 〉	통과 (9.00ms, 84.8MB)
테스트 12 〉	통과 (0.05ms, 72.8MB)
 */
