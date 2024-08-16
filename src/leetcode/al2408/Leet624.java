package leetcode.al2408;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * 624. Maximum Distance in Arrays
 *
 * m개의 배열들이 주어집니다. 각 배열은 오름차순으로 정렬되어 있습니다.
 * 두 개의 다른 배열들에서 각 배열마다 한 개씩 두 정수들을 고르고 거리를 계산합니다.
 * 두 정수들 a와 b 사이에 거리는 |a - b|로 정의합니다.
 * 최대 거리를 구하시오.
 */
public class Leet624 {
    public static void main(String[] args) {
        Leet624 leet624 = new Leet624();

        List<List<Integer>> list1 = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(1, 2, 3));
        List<List<Integer>> list2 = List.of(List.of(1), List.of(1));
        List<List<Integer>> list3 = List.of(List.of(1, 5), List.of(2, 3));

        System.out.println(leet624.maxDistance(list1));     // 4
        System.out.println(leet624.maxDistance(list2));     // 0
        System.out.println(leet624.maxDistance(list3));     // 3
    }

    // 내 풀이: runtime 78ms
    // 시간복잡도 : O(N log N)
    public int maxDistance(List<List<Integer>> arrays) {
        List<ListInfo> listInfos = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            listInfos.add(new ListInfo(i, arrays.get(i)));
        }

        listInfos.sort((a, b) -> a.list.get(a.list.size() - 1) - b.list.get(b.list.size() - 1));
        ListInfo firstMax = listInfos.get(listInfos.size() - 1);
        ListInfo secondMax = listInfos.get(listInfos.size() - 2);

        listInfos.sort((a, b) -> a.list.get(0) - b.list.get(0));
        ListInfo firstMin = listInfos.get(0);
        ListInfo secondMin = listInfos.get(1);

        if (firstMin.index != firstMax.index) {
            return firstMax.list.get(firstMax.list.size() - 1) - firstMin.list.get(0);
        } else {
            return Math.max(
                firstMax.list.get(firstMax.list.size() - 1) - secondMin.list.get(0),
                secondMax.list.get(secondMax.list.size() - 1) - firstMin.list.get(0)
            );
        }
    }

    class ListInfo {
        int index;
        List<Integer> list;

        public ListInfo(int index, List<Integer> list) {
            this.index = index;
            this.list = list;
        }
    }

    // 다른 사람의 풀이: runtime: 5ms
    // 기본적인 아이디어는 나와 비슷한데, 이 풀이에서는 첫번째 최대값, 최소값, 두번째 최대값, 최소값,
    // 첫번째 최대값, 최소값에 대한 index를 int에 저장하여 시간, 공간적으로 효율적으로 구할 수 있었다.
    public int maxDistanceOther(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int secMin = min;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int secMax = max;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int curMin = arr.get(0);
            int curMax = arr.get(arr.size() - 1);
            if (min > curMin) {
                secMin = min;
                min = curMin;
                minIdx = i;
            } else if (secMin > curMin) {
                secMin = curMin;
            }

            if (max < curMax) {
                secMax = max;
                max = curMax;
                maxIdx = i;
            } else if (secMax < curMax) {
                secMax = curMax;
            }
        }
        return minIdx == maxIdx ? Math.max(max - secMin, secMax - min) : max - min;
    }
}
