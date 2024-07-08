package leetcode.al2407;

import java.util.HashSet;
import java.util.Set;

/**
 * Medium
 * 1823. Find the Winner of the Circular Game
 *
 * 게임을 플레이하는 n명의 친구들이 있다.
 * 친구들은 원으로 앉아 있고, 시계방향 순으로 1부터 n까지 넘버링된다.
 * 더 정확하게는, 1 <= i < n에서 i번째 친구에서부터 i+1번째 친구로 시계 방향으로 이동한다.
 * n번째 친구는 1번째 친구로 이동한다.
 * 게임의 룰은 다음과 같다.
 * 1. 1번째 친구부터 시작한다.
 * 2. 시작할 때의 친구를 포함하여 시계 방향으로 다음 k명의 친구를 센다.
 *    카운팅된 마지막 친구는 원을 빠져나가고 게임에서 진다.
 * 3. 원에서 한 명 초과의 친구가 있다면, 2번으로 돌아가서 방금 졌던 친구에서 시계방향대로 다시 시작한다.
 * 4. 아니라면 원에서 남은 마지막 친구가 게임에서 이긴다.
 *
 * 친구 명 수 n과 정수 k가 주어진다. 게임의 승자를 구하라.
 */
public class Leet1823 {
    public static void main(String[] args) {
        Leet1823 l = new Leet1823();
        System.out.println(l.findTheWinner(5, 2));      // 3
        System.out.println(l.findTheWinner(6, 5));      // 1
    }

    // 내 풀이 : 37ms
    // while, Set 이용
    public int findTheWinner(int n, int k) {
        boolean[] lost = new boolean[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        int cur = 0;
        int count = 1;
        while (set.size() > 1) {
            if (cur == n) {
                cur = 0;
            }
            if (!lost[cur]) {
                if (count == k) {
                    lost[cur] = true;
                    set.remove(cur);
                    count = 1;
                    cur++;
                    continue;
                }
                count++;
            }
            cur++;
        }
        return set.iterator().next() + 1;
    }

    // 다른 사람의 풀이 : 0ms
    // 재귀 이용
    public int findTheWinnerOther(int n, int k) {
        if (n == 1)
            return 1;
        return (findTheWinnerOther(n - 1, k) + k - 1) % n + 1;
    }
}
