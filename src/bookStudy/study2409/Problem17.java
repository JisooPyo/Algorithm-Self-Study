package bookStudy.study2409;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 lv.1
 * 17. 카드 뭉치
 */
public class Problem17 {
    public static void main(String[] args) {
        Problem17 p = new Problem17();

        String[] cards1_1 = {"i", "drink", "water"};
        String[] cards2_1 = {"want", "to"};
        String[] goal1 = {"i", "want", "to", "drink", "water"};

        String[] cards1_2 = {"i", "water", "drink"};
        String[] cards2_2 = {"want", "to"};
        String[] goal2 = {"i", "want", "to", "drink", "water"};
        System.out.println(p.solution(cards1_1, cards2_1, goal1));      // Yes
        System.out.println(p.solution(cards1_2, cards2_2, goal2));      // No
    }

    // goal도 Queue에 넣어놓고 판단했으면 더 좋았을 것 같다!
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> card1Queue = new LinkedList<>();
        Queue<String> card2Queue = new LinkedList<>();
        for (int i = 0; i < cards1.length; i++) {
            card1Queue.offer(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            card2Queue.offer(cards2[i]);
        }
        int index = 0;

        while ((!card1Queue.isEmpty() || !card2Queue.isEmpty()) && index < goal.length) {
            if (!card1Queue.isEmpty() && card1Queue.peek().equals(goal[index])) {
                card1Queue.poll();
                index++;
            } else if (!card2Queue.isEmpty() && card2Queue.peek().equals(goal[index])) {
                card2Queue.poll();
                index++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
