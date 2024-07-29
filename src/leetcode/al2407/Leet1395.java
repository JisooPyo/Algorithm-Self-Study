package leetcode.al2407;

/**
 * Medium
 * 1395. Count Number of Teams
 *
 * 줄에 n명의 군인들이 서 있다. 각 군인들은 unique 한 rating 값을 할당받는다.
 *
 * 너는 다음 규칙들 하에 그들 중에서 세 군인들로 이루어진 팀을 꾸려야 한다.
 *   - rating 이 (rating[i], rating[j], rating[k])인 index(i, j, k)인 3명의 군인을 뽑는다.
 *   - 팀은 0 <= i < j < k < n에서 rating[i] < rating[j] < rating[k] 이거나 rating[i] > rating[j] > rating[k] 인 경우만 유효합니다.
 *
 * 주어진 조건에서 꾸릴 수 있는 팀의 수를 구하세요.
 * (한 군인은 여러 팀에 속할 수도 있습니다.)
 */
public class Leet1395 {
    public static void main(String[] args) {
        Leet1395 l = new Leet1395();

        System.out.println(l.numTeams(new int[]{2, 5, 3, 4, 1}));   // 3
        System.out.println(l.numTeams(new int[]{2, 1, 3}));         // 0
        System.out.println(l.numTeams(new int[]{1, 2, 3, 4}));      // 4
    }

    // 내 풀이 : 1314ms
    // 푸는 데 걸린 시간 : 3m
    // 이용한 알고리즘 : brute force
    // 시간복잡도 : O(n^3)
    public int numTeams(int[] rating) {
        int count = 0;
        int n = rating.length;
        // 오름차순
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (rating[i] > rating[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (rating[j] > rating[k]) {
                        continue;
                    }
                    count++;
                }
            }
        }
        // 내림차순
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (rating[i] < rating[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (rating[j] < rating[k]) {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    // 다른 사람의 풀이 : 6ms
    // 시간복잡도 : O(n log n)
    // 이용한 알고리즘 : Fenwick Tree
    public int numTeamsOther(int[] rating) {
        int n = rating.length;

        // rating 최소값, 최대값 찾기
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : rating) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] leftTree = new int[max - min + 2];
        int[] rightTree = new int[max - min + 2];

        for (int num : rating) {
            update(rightTree, num - min, 1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            update(rightTree, rating[i] - min, -1);

            int lessLeft = query(leftTree, rating[i] - min - 1);
            int greaterLeft = i - lessLeft;

            int lessRight = query(rightTree, rating[i] - min - 1);
            int greaterRight = (n - i - 1) - lessRight;

            count += lessLeft * greaterRight + greaterLeft * lessRight;

            update(leftTree, rating[i] - min, 1);
        }

        return count;
    }

    private void update(int[] tree, int index, int value) {
        index++;
        while (index < tree.length) {
            tree[index] += value;
            index += index & (-index);
        }
    }

    private int query(int[] tree, int index) {
        int sum = 0;
        index++;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }
}
