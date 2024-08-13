package leetcode.al2408;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Medium
 * 40. Combination Sum II
 *
 * 지원자의 숫자들로 이루어진 컬렉션(candidates)으로 주어진다.
 * 그리고 타겟 숫자 target이 주어진다.
 * candidates 에서 합이 target이 되는 모든 고유한 조합을 찾아라.
 *
 * candidates의 각 숫자는 조합에서 딱 한 번 사용될 수 있다.
 *
 * solution set은 중복된 조합을 포함해선 안된다.
 */
public class Leet40 {
    public static void main(String[] args) {
        Leet40 leet40 = new Leet40();

        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int[] candidates2 = {2, 5, 2, 1, 2};

        // [[1,1,6],[1,2,5],[1,7],[2,6]]
        System.out.println(leet40.combinationSum2(candidates1, 8));
        // [[1,2,2],[5]]
        System.out.println(leet40.combinationSum2(candidates2, 5));
    }

    // 내 풀이 : 4ms
    // 알고리즘 : 백트래킹, 재귀
    int[] candidates;
    int target;
    List<List<Integer>> answer;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // 배열 정렬
        this.target = target;
        this.candidates = candidates;
        answer = new ArrayList<>();
        rec(new ArrayList<>(), 0, 0);
        return answer;
    }

    private void rec(List<Integer> list, int start, int sum) {
        if (sum > target)
            return;
        if (sum == target) {
            answer.add(new ArrayList<>(list));  // 깊은 복사
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                // 같은 레벨에서 동일한 숫자는 스킵하여 중복 방지
                continue;
            }
            list.add(candidates[i]);
            rec(list, i + 1, sum + candidates[i]);  // 다음 숫자로 넘어가기 위해 i + 1
            list.remove(list.size() - 1);  // 백트래킹
        }
    }
}
