package bookStudy.study2409;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 15. 요세푸스 문제
 *
 * 이 문제는 유대인 역사가인 플라비우스 요세푸스가 만든 문제입니다.
 *
 * N명의 사람이 원 형태로 서 있습니다. 각 사람은 1부터 N까지 번호표를 갖고 있습니다.
 * 그리고 임의의 숫자 K가 주어졌을 때 다음과 같이 사람을 없앱니다.
 *   - 1번 번호표를 가진 사람을 기주으로 K번째 사람을 없앱니다.
 *   - 없앤 사람 다음 사람을 기준으로 하고 다시 K번째 사람을 없앱니다.
 * N과 K가 주어질 때 마지막에 살아있는 사람의 번호를 반환하는 solution() 함수를 구현해주세요.
 *
 * 제약 조건
 *   - N과 K는 1이상 1000 이하의 자연수입니다.
 *
 * 입출력의 예
 *   - N: 5, K:2, return:3
 */
public class Problem15 {
    public static void main(String[] args) {
        Problem15 p = new Problem15();

        System.out.println(p.solution(5, 2));   // 3
    }

    public int solution(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.peek();
    }
}
