package leetcode.al2406;

import java.util.Arrays;

/**
 Medium
 2285. Maximum Total Importance of Roads

 한 나라 내의 도시들의 수를 의미하는 정수 n이 주어집니다.
 도시들은 0부터 n-1까지 넘버링됩니다.
 또한 2D 정수 배열 roads 가 주어집니다.
 roads[i] = [ai, bi] 는 도시 ai와 bi를 잇는 양방향의 길이 존재함을 의미합니다.

 당신은 각 도시에 정수 1부터 n까지 할당해야 합니다. 이 때 각 값은 한번만 사용할 수 있습니다.
 길의 중요성은 길이 연결하는 두 도시의 값의 합으로 정의됩니다.

 최적으로 값을 할당하여 모든 길의 중요성의 최댓값을 구하세요.
 */

public class Leet2285 {
    public static void main(String[] args) {
        Leet2285 l = new Leet2285();

        int[][] roads1 = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        int[][] roads2 = {{0, 3}, {2, 4}, {1, 3}};

        System.out.println(l.maximumImportance(5, roads1));     // 43
        System.out.println(l.maximumImportance(5, roads2));     // 20
    }

    // 내 풀이 : 8ms
    // 걸린 시간 : 10m
    // 가장 연결이 많이 되어 있는 도시에 중요성을 높게 쳐준다.
    public long maximumImportance(int n, int[][] roads) {
        int[] countCity = new int[n];
        for (int i = 0; i < roads.length; i++) {
            countCity[roads[i][0]]++;
            countCity[roads[i][1]]++;
        }

        Arrays.sort(countCity);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long)countCity[i] * (i + 1);
        }

        return sum;
    }
}
