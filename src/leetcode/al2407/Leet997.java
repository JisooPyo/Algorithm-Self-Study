package leetcode.al2407;

import java.util.HashSet;
import java.util.Set;

/**
 * Graph - Easy
 * 997. Find the Town Judge
 *
 * 어떤 마을에는 1부터 n까지 번호가 매겨진 n명의 사람이 있습니다.
 * 이들 중 한 사람이 비밀리에 마을 판사라는 소문이 있습니다.
 *
 * 만약 마을 판사가 존재한다면:
 *
 * 1. 마을 판사는 아무도 신뢰하지 않습니다.
 * 2. 마을 판사를 제외한 모든 사람은 마을 판사를 신뢰합니다.
 * 3. 위의 두 조건을 만족하는 사람은 오직 한 명입니다.
 *
 * 배열 `trust`가 주어집니다.
 * `trust[i] = [a_i, b_i]`는 번호가 `a_i`인 사람이 번호가 `b_i`인 사람을 신뢰한다는 것을 나타냅니다.
 * 만약 `trust` 배열에 특정 신뢰 관계가 존재하지 않으면, 그러한 신뢰 관계는 존재하지 않는 것으로 간주합니다.
 *
 * 마을 판사가 존재하고 식별될 수 있다면 그 사람의 번호를 반환하고, 그렇지 않으면 `-1`을 반환하세요.
 */
public class Leet997 {
    public static void main(String[] args) {
        Leet997 l = new Leet997();

        int[][] trust1 = {{1, 2}};
        int[][] trust2 = {{1, 3}, {2, 3}};
        int[][] trust3 = {{1, 3}, {2, 3}, {3, 1}};

        System.out.println(l.findJudge(2, trust1));     // 2
        System.out.println(l.findJudge(3, trust2));     // 3
        System.out.println(l.findJudge(4, trust3));     // -1
    }

    // 내 풀이 : 7ms
    public int findJudge(int n, int[][] trust) {
        int[] beTrusted = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int i = 0; i < trust.length; i++) {
            set.remove(trust[i][0]);
            beTrusted[trust[i][1]]++;
        }
        for (Integer i : set) {
            if (beTrusted[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
