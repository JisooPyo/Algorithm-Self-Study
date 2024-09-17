package bookStudy.study2409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 프로그래머스 lv.2
 * 16. 기능 개발
 */
public class Problem16 {
    public static void main(String[] args) {
        Problem16 p = new Problem16();

        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(p.solution(progresses1, speeds1)));  // [2, 1]
        System.out.println(Arrays.toString(p.solution(progresses2, speeds2)));  // [1, 3, 2]
    }

    // 처음에 각 작업별 배포 가능일을 계산해두는 것도 좋았을 것!
    // 꼭 Queue를 이용하지 않아도 되는 문제!
    public int[] solution(int[] progresses, int[] speeds) {
        // Queue에 현재 작업 진도 입력
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
        }

        // 배포 과정
        List<Integer> list = new ArrayList<>();
        int days = 0;
        int index = 0;  // speed index
        while (!queue.isEmpty()) {
            int count = 0;
            while (!queue.isEmpty() && queue.peek() + (days * speeds[index]) >= 100) {
                queue.poll();
                count++;
                index++;
            }
            list.add(count);

            if (queue.isEmpty())
                break;

            int cur = queue.peek();
            days = (100 - cur) % speeds[index] == 0
                ? (100 - cur) / speeds[index]
                : (100 - cur) / speeds[index] + 1;

        }

        // List -> array
        int[] answer = new int[list.size() - 1];
        for (int i = 1; i < list.size(); i++) {
            answer[i - 1] = list.get(i);
        }

        return answer;
    }
}
/*
테스트 1 〉	통과 (0.18ms, 75.6MB)
테스트 2 〉	통과 (0.18ms, 76.2MB)
테스트 3 〉	통과 (0.17ms, 75.7MB)
테스트 4 〉	통과 (0.16ms, 72.1MB)
테스트 5 〉	통과 (0.13ms, 73.7MB)
테스트 6 〉	통과 (0.15ms, 76.1MB)
테스트 7 〉	통과 (0.24ms, 87.5MB)
테스트 8 〉	통과 (0.18ms, 71.9MB)
테스트 9 〉	통과 (0.18ms, 81.4MB)
테스트 10 〉	통과 (0.18ms, 77.8MB)
테스트 11 〉	통과 (0.13ms, 83.5MB)
 */
