package leetcode.al2405;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 857. Minimum Cost to Hire K Workers
 *
 * Given
 * quality: 정수 배열
 *          quality[i] - i번째 사람의 quality
 * wage: 정수 배열
 *       wage[i] - i번째 사람의 최소 봉급 기대값
 * k: 정수
 *
 * Description
 * k명의 사람을 고용할 것.
 * 1. 모든 고용된 사람에게 적어도 최소 봉급 기대값 이상을 지불해야 한다.
 * 2. 그룹에서, 각 피고용인의 페이는 그들의 퀄리티에 비례해야 한다.
 *    이는 그룹에서 한 피고용인의 퀄리티가 다른 피고용인의 퀄리티의 두 배일 때, 페이도 두 배여야 함을 의미한다.
 *
 * Return
 * 위 조건을 만족하는 유급 그룹을 형성할 수 있는 최소 페이 양(소수점 다섯자리까지 생각한다.)
 */
public class Leet857 {
    public static void main(String[] args) {
        Leet857 l = new Leet857();
        l.problem1();
        l.problem2();
    }

    private void problem1() {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;
        // 105.00000
        System.out.println(mincostToHireWorkers(quality, wage, k));
    }

    private void problem2() {
        int[] quality = {3, 1, 10, 10, 1};
        int[] wage = {4, 8, 2, 2, 7};
        int k = 3;
        // 30.66667
        System.out.println(mincostToHireWorkers(quality, wage, k));
    }

    // 내 풀이: 못 풀었다
    // (봉급의 합) * (봉급/퀄리티의 최댓값) 의 최솟값 찾기. Greedy인 거 같은데 감을 잘 못 잡겠다.

    // 다른 사람의 풀이
    class Worker implements Comparable<Worker> {
        final int q, w;

        public Worker(int q, int w) {
            this.q = q;
            this.w = w;
        }

        @Override
        public int compareTo(Worker other) {
            return Integer.compare(w * other.q, q * other.w);
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] a = new Worker[n];
        for (int i = 0; i < n; ++i) {
            a[i] = new Worker(quality[i], wage[i]);
        }
        // W/Q를 기준으로 정렬
        Arrays.sort(a);

        int s = 0;
        double res = 1e15;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Worker worker : a) {
            q.add(-worker.q);
            s += worker.q;
            if (q.size() > k)   // 일꾼의 수가 K를 초과하면 품질이 낮은 일군 제거
                s += q.poll();
            if (q.size() == k)  // 일꾼의 수가 K이면 최소 비용 업데이트
                res = Math.min(res, (double)s * worker.w / worker.q);
        }
        return res;
    }
}
