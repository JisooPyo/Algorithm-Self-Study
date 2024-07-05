package leetcode.al2407;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 Medium
 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

 Linked List 의 critical point 는 local maxima 또는 local minima 이다.
 만약 현재 노드가 전 노드와 다음 노드보다 값이 크다면 local maxima 노드이다.
 만약 현재 노드가 전 노드와 다음 노드보다 값이 적다면 local minima 노드이다.

 노드는 전 노드와 다음 노드가 존재해야지만 local maxima, local minima가 될 수 있다.

 Linked List head 가 주어진다.
 minDistance는 두 구별되는 critical point 사이 최소 거리이고,
 maxDistance는 두 구별되는 critical point 사이 최대 거리이다.
 이 때, [minDistance, maxDistance] 길이 2의 배열을 반환하라.

 만약 critical point가 두 개보다 더 적다면 [-1, -1]을 반환하라.
 */
public class Leet2058 {
    // 내 풀이 : 17ms
    // 시간복잡도 : O(N)
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head.next.next == null) {
            return new int[] {-1, -1};
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        int index = 1;

        List<Integer> list = new ArrayList<>();
        while (next != null) {
            if (cur.val < prev.val && cur.val < next.val) {
                list.add(index);
            } else if (cur.val > prev.val && cur.val > next.val) {
                list.add(index);
            }

            prev = prev.next;
            cur = cur.next;
            next = next.next;
            index++;
        }

        if (list.size() < 2) {
            return new int[] {-1, -1};
        }

        Collections.sort(list);
        return getArray(list);
    }

    private int[] getArray(List<Integer> list) {
        int[] res = new int[2];

        res[0] = Integer.MAX_VALUE;
        res[1] = list.get(list.size() - 1) - list.get(0);

        for (int i = 0; i < list.size() - 1; i++) {
            res[0] = Math.min(res[0], list.get(i + 1) - list.get(i));
        }

        return res;
    }

    // 다른 사람 풀이 : 4ms
    // 시간 복잡도 : O(N)
    // 두 풀이 다 O(N)인데 다른 사람 풀이는 N, 내 풀이는 2N으로 돌아가서 내 풀이가 더 비효율적으로 나온 것 같다.
    public int[] nodesBetweenCriticalPointsOther(ListNode head) {

        ListNode prev = head;
        ListNode curr = head.next;

        int first_index = -1;
        int last_index = -1;

        int index = 1;

        int prev_index = -1;

        int min_dist = Integer.MAX_VALUE;

        while (curr.next != null) {

            if (prev.val > curr.val && curr.val < curr.next.val || prev.val < curr.val && curr.val > curr.next.val) {

                if (prev_index == -1) {
                    first_index = index;
                    prev_index = index;
                } else {
                    if (min_dist > index - prev_index) {
                        min_dist = index - prev_index;
                    }

                    prev_index = index;
                }

            }

            index++;

            curr = curr.next;
            prev = prev.next;

        }

        last_index = prev_index;

        int max_dist = -1;

        if (min_dist == Integer.MAX_VALUE) {
            int[] arr = {-1, -1};
            return arr;
        } else {
            max_dist = last_index - first_index;
            int[] arr = {min_dist, max_dist};
            return arr;
        }

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
