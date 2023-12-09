package programmers.test2312;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Spicier {
    public static void main(String[] args) {
        Spicier s = new Spicier();

        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int k1 = 7;

        System.out.println(s.solution(scoville1, k1));
    }

    public int solution(int[] scoville, int K) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < scoville.length; i++) {
            list.add(scoville[i]);
        }
        PriorityQueue<Integer> mixScoville = new PriorityQueue<>(list);
        int count = 0;
        while (mixScoville.peek() < K) {
            if (mixScoville.size() <= 1) {
                return -1;
            }
            int first = mixScoville.poll();
            int second = mixScoville.poll();
            mixScoville.add(first + second * 2);
            count++;
        }
        return count;
    }
}
