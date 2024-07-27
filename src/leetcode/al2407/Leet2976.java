package leetcode.al2407;

import java.util.Arrays;

/**
 * Medium
 * 2976. Minimum Cost to Convert String I
 *
 * 0-indexed 인 두 개의 문자열 source 와 target 이 주어집니다.
 * 두 문자열 모두 길이가 n이며, 영소문자로 이루어져 있습니다.
 * 또한 0-indexed 인 문자 배열 original, changed, 정수 배열 cost 가 주어집니다.
 * cost[i]는 original[i]인 문자를 changed[i]로 바꾸는데 필요한 비용을 나타냅니다.
 *
 * 문자열 source 부터 시작합니다.
 * 만약 cost[j] == z, original[j] == x, changed[j] = y인 j가 있다면,
 * 한 번의 연산으로 문자열에서 문자 x를 골라 z 비용을 내고 문자 y로 변화시킵니다.
 *
 * 몇 번의 연산이든, source 문자열에서 target 문자열로 변환할 수 있는 가장 적은 비용을 반환하세요.
 * 만약 불가능하다면 -1을 반환하세요.
 *
 * original[j] == original[i] 이고, changed[j] == changed[i]인 인덱스 i, j가 존재할 수 있습니다.
 */
public class Leet2976 {
    public static void main(String[] args) {
        Leet2976 l = new Leet2976();
        char[] original1 = {'a', 'b', 'c', 'c', 'e', 'd'}, changed1 = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost1 = {2, 5, 5, 1, 2, 20};

        char[] original2 = {'a', 'c'}, changed2 = {'c', 'b'};
        int[] cost2 = {1, 2};

        char[] original3 = {'a'}, changed3 = {'e'};
        int[] cost3 = {10000};

        System.out.println(l.minimumCost("abcd", "acbe", original1, changed1, cost1));  // 28
        System.out.println(l.minimumCost("aaaa", "bbbb", original2, changed2, cost2));  // 12
        System.out.println(l.minimumCost("abcd", "abce", original3, changed3, cost3));  // -1
    }

    // 내 풀이 : 19ms
    // 어제 문제에서 나왔던 플로이드 와샬 알고리즘 응용하여 풀이
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // 1. 그래프 기록
        int[][] records = new int[26][26];
        //   1) 주어지지 않은 비용은 무한
        for (int[] record : records) {
            Arrays.fill(record, Integer.MAX_VALUE / 2);
        }
        //   2) 같은 노드로 가는 비용은 0
        for (int i = 0; i < 26; i++) {
            records[i][i] = 0;
        }
        //   3) 주어진 비용 기록 - 현재까지 계산된 최소 비용
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            records[from][to] = Math.min(records[from][to], cost[i]); // 최소 비용으로 갱신
        }

        // 2. 모든 정점에서의 모든 정점 최소 거리 구하기
        // 거쳐가는 노드
        for (int k = 0; k < 26; k++) {
            // 출발 노드
            for (int i = 0; i < 26; i++) {
                // 도착 노드
                for (int j = 0; j < 26; j++) {
                    if (records[i][k] < Integer.MAX_VALUE / 2 && records[k][j] < Integer.MAX_VALUE / 2) {
                        records[i][j] = Math.min(records[i][j], records[i][k] + records[k][j]);
                    }
                }
            }
        }

        // 3. cost 구하기
        long result = 0L;
        for (int i = 0; i < source.length(); i++) {
            long minCost = records[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (minCost == Integer.MAX_VALUE / 2) {
                return -1;
            }
            result += minCost;
        }
        return result;
    }
}
