package leetcode.al2406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 Medium
 826. Most Profit Assigning Work

 Given
 difficulty, profit, worker : 정수 배열
 - difficulty[i]와 profit[i]는 i번째 일의 어려움과 이익.
 - worker[j]는 j번째 노동자의 능력이다.(즉, j번째 노동자는 최대 worker[j]만큼 어려운 일을 끝낼 수 있다.)

 n개의 일과 m명의 노동자들이 있다.
 모든 노동자들은 최대 한 가지 일을 할당받을 수 있다.
 하지만 한 가지 일은 여러 번 완료될 수 있다.
 예를 들어, 만약 3명의 노동자들이 1달러를 지불하는 똑같은 일을 시도한다면 총 이익은 3달러가 된다.
 만약, 한 노동자가 어떤 일도 끝마치지 못했다면 이익은 0달러이다.

 Return
 노동자들에게 일을 할당한 후 얻을 수 있는 최대 이익을 구하여라.
 */
public class Leet826 {
    public static void main(String[] args) {
        Leet826 l = new Leet826();
        int[] difficulty1 = {2, 4, 6, 8, 10}, profit1 = {10, 20, 30, 40, 50}, worker1 = {4, 5, 6, 7};

        int[] difficulty2 = {85, 47, 57}, profit2 = {24, 66, 99}, worker2 = {40, 25, 25};

        int[] difficulty3 = {13, 37, 58}, profit3 = {4, 90, 96}, worker3 = {34, 73, 45};

        System.out.println(l.maxProfitAssignment(difficulty1, profit1, worker1));   // 100
        System.out.println(l.maxProfitAssignment(difficulty2, profit2, worker2));   // 0
        System.out.println(l.maxProfitAssignment(difficulty3, profit3, worker3));   //
    }

    // 다른 사람 풀이 : 9ms
    // 배열의 index 를 활용해서 difficulty 를 index 화 해서 풀었다.

    // 다른 사람 풀이 : 19ms
    // 나처럼 Work 클래스를 구현해서 풀었으나, PriorityQueue 가 아니라 Work[] 를 정렬하는 방식으로 풀었다.
    // 이 방식이 공간 복잡도를 크게 늘리지 않으면서 시간 복잡도도 효율적인 풀이인 것 같다!

    // 내 풀이 : 34ms
    // PriorityQueue 활용
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        PriorityQueue<Work> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < difficulty.length; i++) {
            priorityQueue.add(new Work(difficulty[i], profit[i]));
        }
        int res = 0;
        int maxProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            if (priorityQueue.isEmpty() || priorityQueue.peek().difficulty > worker[i]) {
                res += maxProfit;
                continue;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek().difficulty <= worker[i]) {
                maxProfit = Math.max(priorityQueue.poll().profit, maxProfit);
            }
            res += maxProfit;
        }
        // while (!priorityQueue.isEmpty()) {
        //     Work work = priorityQueue.poll();
        //     System.out.println("work.difficulty = " + work.difficulty);
        //     System.out.println("work.profit = " + work.profit);
        // }
        return res;
    }

    public class Work implements Comparable<Work> {
        int difficulty;
        int profit;

        public Work(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        @Override
        public int compareTo(Work w2) {
            if (this.difficulty != w2.difficulty) {
                return Integer.compare(this.difficulty, w2.difficulty);
            } else {
                return Integer.compare(this.profit, w2.profit);
            }
        }
    }

}
