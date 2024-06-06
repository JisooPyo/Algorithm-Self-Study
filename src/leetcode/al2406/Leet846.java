package leetcode.al2406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Medium
 * 846. Hand of Straights
 *
 * Alice 는 몇 장의 카드를 가지고 있다.
 * 이 카드를 그룹으로 재배치하려고 합니다.
 * 각 그룹은 크기가 groupSize 이어야 하며, 연속된 groupSize 개의 카드로 구성되어야 합니다.
 *
 * Given
 * hand : 정수 배열
 *        hand[i]는 i번째 카드에 적힌 값
 * groupSize : 정수
 *
 * Return
 * Alice 가 카드를 재배치할 수 있다면 true 를 반환하고, 그렇지 않으면 false 를 반환하세요.
 */
public class Leet846 {
    public static void main(String[] args) {
        Leet846 l = new Leet846();

        int[] hand1 = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize1 = 3;
        int[] hand2 = {1, 2, 3, 4, 5};
        int groupSize2 = 4;
        int[] hand3 = {1, 2, 3, 4, 5, 6};
        int groupSize3 = 2;
        int[] hand4 = {8, 10, 12};
        int groupSize4 = 3;
        int[] hand5 = {1, 1, 2, 2, 3, 3};
        int groupSize5 = 2;

        System.out.println(l.isNStraightHand(hand1, groupSize1));   // true
        System.out.println(l.isNStraightHand(hand2, groupSize2));   // false
        System.out.println(l.isNStraightHand(hand3, groupSize3));   // true
        System.out.println(l.isNStraightHand(hand4, groupSize4));   // false
        System.out.println(l.isNStraightHand(hand5, groupSize5));   // false
    }

    // 내 풀이 - 372ms
    int groupSize;

    public boolean isNStraightHand(int[] hand, int groupSize) {
        this.groupSize = groupSize;
        if (hand.length % groupSize != 0) {
            return false;
        }
        if (groupSize == 1) {
            return true;
        }
        Arrays.sort(hand);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < hand.length; i++) {
            queue.add(hand[i]);
        }

        return checkQueue(queue);
    }

    private boolean checkQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return true;
        }
        if (queue.size() == groupSize) {
            return checkContinuous(queue);
        }
        Queue<Integer> parameter = new LinkedList<>();
        int standard = queue.poll();
        int index = 1;
        while (index < groupSize) {
            int peek = queue.peek();
            if (peek == standard + 1) {
                standard = queue.poll();
                index++;
            } else if (peek == standard) {
                parameter.add(queue.poll());
            } else {
                return false;
            }
        }
        parameter.addAll(queue);
        return checkQueue(parameter);
    }

    private boolean checkContinuous(Queue<Integer> queue) {
        int standard = queue.poll();
        int index = 1;
        while (index < groupSize) {
            int peek = queue.peek();
            if (peek == standard + 1) {
                standard = queue.poll();
                index++;
            } else {
                return false;
            }
        }
        return true;
    }

    // GPT 추천 풀이 - 66ms
    // 계속 자료구조를 초기화하지 않고 Map을 이용하기 때문에 시간을 많이 줄일 수 있었다.
    public boolean isNStraightHandGPT(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        for (int key : count.keySet()) {
            if (count.get(key) > 0) {
                int numGroups = count.get(key);
                for (int i = 0; i < groupSize; i++) {
                    if (count.getOrDefault(key + i, 0) < numGroups) {
                        return false;
                    }
                    count.put(key + i, count.get(key + i) - numGroups);
                }
            }
        }
        return true;
    }

    // 다른 사람의 풀이 - 9ms
    // 배열 자체 값을 바꾸면서 반복을 줄인 풀이
    // Map보다 좀 더 메모리 효율적이나 가독성이 떨어지는 단점이 있다.

    public boolean isNStraightHandOther(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Arrays.sort(hand);
        for (int i = 0; i < n; i++) {
            if (hand[i] >= 0) {
                if (!findsucessors(hand, groupSize, i, n))
                    return false;
            }
        }
        return true;
    }

    public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if (count != groupSize)
            return false;
        else
            return true;
    }
}
