package bookStudy.study2409;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 lv.2
 * 21. 오픈채팅방
 */
public class Problem21 {
    public static void main(String[] args) {
        Problem21 p = new Problem21();
        String[] record = {
            "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
            "Enter uid1234 Prodo", "Change uid4567 Ryan"
        };

        // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
        System.out.println(Arrays.toString(p.solution(record)));
    }

    // 내 풀이
    public String[] solution(String[] record) {
        // 유저아이디, 닉네임 저장
        Map<String, String> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if (!split[0].equals("Leave")) {
                map.put(split[1], split[2]);
            }
            if (split[0].equals("Enter") || split[0].equals("Leave")) {
                count++;
            }
        }

        String[] answer = new String[count];
        int index = 0;
        for (int i = 0; i < record.length; i++) {
            if (record[i].charAt(0) == 'C') {
                continue;
            }
            String[] split = record[i].split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(split[1]));
            sb.append(split[0].charAt(0) == 'E' ? "님이 들어왔습니다." : "님이 나갔습니다.");
            answer[index] = sb.toString();
            index++;
        }

        return answer;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.31ms, 77.4MB)
테스트 2 〉	통과 (0.19ms, 77.2MB)
테스트 3 〉	통과 (0.75ms, 76.2MB)
테스트 4 〉	통과 (0.44ms, 78.2MB)
테스트 5 〉	통과 (4.21ms, 76.7MB)
테스트 6 〉	통과 (5.53ms, 78.6MB)
테스트 7 〉	통과 (3.60ms, 74.5MB)
테스트 8 〉	통과 (5.02ms, 79.9MB)
테스트 9 〉	통과 (4.58ms, 79.7MB)
테스트 10 〉	통과 (3.84ms, 82.8MB)
테스트 11 〉	통과 (3.20ms, 79.5MB)
테스트 12 〉	통과 (3.94ms, 83.6MB)
테스트 13 〉	통과 (5.47ms, 84.5MB)
테스트 14 〉	통과 (4.12ms, 79.9MB)
테스트 15 〉	통과 (0.19ms, 74.9MB)
테스트 16 〉	통과 (0.20ms, 82.4MB)
테스트 17 〉	통과 (0.76ms, 70.9MB)
테스트 18 〉	통과 (0.70ms, 72.4MB)
테스트 19 〉	통과 (5.33ms, 83.7MB)
테스트 20 〉	통과 (3.37ms, 77.3MB)
테스트 21 〉	통과 (4.75ms, 74.4MB)
테스트 22 〉	통과 (3.18ms, 73.8MB)
테스트 23 〉	통과 (3.70ms, 78.6MB)
테스트 24 〉	통과 (5.09ms, 79.9MB)
테스트 25 〉	통과 (110.26ms, 167MB)
테스트 26 〉	통과 (108.86ms, 171MB)
테스트 27 〉	통과 (126.75ms, 174MB)
테스트 28 〉	통과 (134.02ms, 179MB)
테스트 29 〉	통과 (119.28ms, 179MB)
테스트 30 〉	통과 (107.68ms, 175MB)
테스트 31 〉	통과 (125.53ms, 175MB)
테스트 32 〉	통과 (132.13ms, 169MB)
 */
