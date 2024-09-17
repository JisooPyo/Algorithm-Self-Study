package bookStudy.study2409;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 lv.1
 * 19. 완주하지 못한 선수
 */
public class Problem19 {
    public static void main(String[] args) {
        Problem19 p = new Problem19();

        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        System.out.println(p.solution(participant1, completion1));  // leo
        System.out.println(p.solution(participant2, completion2));  // vinko
        System.out.println(p.solution(participant3, completion3));  // mislav
    }

    // 내 풀이에서는 참여자를 담고, 완주자를 빼서 마지막 남은 사람을 구했다.
    // 책의 풀이에서는 완주자를 담고, 참여자를 빼면서 완주자 목록에 참여자가 없으면 바로 문자열을 return하는 식으로 풀었다.
    // 두 개의 배열을 모두 돌지 않아도 중간에 끝낼 수 있으므로 더 효율적이다.
    public String bookSolution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (String p : participant) {
            if (map.getOrDefault(p, 0) == 0) {
                return p;
            }
            map.put(p, map.get(p) - 1);
        }
        return null;
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        for (String str : map.keySet()) {
            return str;
        }
        return "";
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.07ms, 78.6MB)
테스트 2 〉	통과 (0.06ms, 73.6MB)
테스트 3 〉	통과 (0.91ms, 77.2MB)
테스트 4 〉	통과 (0.90ms, 77.2MB)
테스트 5 〉	통과 (0.86ms, 76.4MB)
테스트 6 〉	통과 (0.05ms, 73MB)
테스트 7 〉	통과 (0.04ms, 83MB)
효율성  테스트
테스트 1 〉	통과 (38.73ms, 81.8MB)
테스트 2 〉	통과 (75.86ms, 88.4MB)
테스트 3 〉	통과 (132.05ms, 95.4MB)
테스트 4 〉	통과 (80.35ms, 97.4MB)
테스트 5 〉	통과 (75.02ms, 97.1MB)
 */
