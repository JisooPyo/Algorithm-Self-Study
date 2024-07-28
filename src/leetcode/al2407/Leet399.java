package leetcode.al2407;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Medium
 * 399. Evaluate Division
 * 다음은 변수 쌍의 배열 equations 와 실수 배열 values 가 주어집니다.
 * equations[i] = [Ai, Bi]이고, values[i]는 식 Ai / Bi = values[i]를 나타냅니다.
 * 각 Ai 또는 Bi는 단일 변수를 나타내는 문자열입니다.
 *
 * 또한 일부 쿼리도 주어지며, queries[j] = [Cj, Dj]는 j번째 쿼리를 나타내며, Cj / Dj = ?의 답을 찾아야 합니다.
 * 모든 쿼리에 대한 답을 반환하세요. 단일 답을 결정할 수 없는 경우 -1.0을 반환하세요.
 *
 * 참고: 입력은 항상 유효합니다. 쿼리를 평가하는 과정에서 0으로 나누는 상황이 발생하지 않으며, 모순이 발생하지 않는다고 가정할 수 있습니다.
 *  참고: 식 목록에 나타나지 않는 변수는 정의되지 않으므로 그 답을 결정할 수 없습니다.
 */
public class Leet399 {
    public static void main(String[] args) {
        Leet399 l = new Leet399();

        String[][] equationsArr1 = {{"a", "b"}, {"b", "c"}};
        List<List<String>> equations1 = Arrays.stream(equationsArr1).map(Arrays::asList).toList();
        double[] values1 = {2.0, 3.0};
        String[][] queriesArr1 = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        List<List<String>> queries1 = Arrays.stream(queriesArr1).map(Arrays::asList).toList();

        String[][] equationsArr2 = {{"a", "b"}, {"b", "c"}, {"bc", "cd"}};
        List<List<String>> equations2 = Arrays.stream(equationsArr2).map(Arrays::asList).toList();
        double[] values2 = {1.5, 2.5, 5.0};
        String[][] queriesArr2 = {{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}};
        List<List<String>> queries2 = Arrays.stream(queriesArr2).map(Arrays::asList).toList();

        String[][] equationsArr3 = {{"a", "b"}};
        List<List<String>> equations3 = Arrays.stream(equationsArr3).map(Arrays::asList).toList();
        double[] values3 = {0.5};
        String[][] queriesArr3 = {{"a", "b"}, {"b", "a"}, {"a", "c"}, {"x", "y"}};
        List<List<String>> queries3 = Arrays.stream(queriesArr3).map(Arrays::asList).toList();

        // [6.00000, 0.50000, -1.00000, 1.00000, -1.00000]
        System.out.println(Arrays.toString(l.calcEquation(equations1, values1, queries1)));
        // [3.75000, 0.40000, 5.00000, 0.20000]
        System.out.println(Arrays.toString(l.calcEquation(equations2, values2, queries2)));
        // [0.50000, 2.00000, -1.00000, -1.00000]
        System.out.println(Arrays.toString(l.calcEquation(equations3, values3, queries3)));
    }

    // 내 풀이
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 변수 - index 연결
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            if (map.get(dividend) == null) {
                map.put(dividend, index++);
            }
            String divisor = equations.get(i).get(1);
            if (map.get(divisor) == null) {
                map.put(divisor, index++);
            }

        }

        // graph 기록
        int size = map.size();
        double[][] graph = new double[size][size];
        for (int i = 0; i < size; i++) {
            graph[i][i] = 1;
        }
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            graph[map.get(dividend)][map.get(divisor)] = values[i];
            graph[map.get(divisor)][map.get(dividend)] = 1 / values[i];
        }

        // 구할 수 있는 값 구해놓기
        // 거쳐가는 노드
        for (int k = 0; k < size; k++) {
            // 출발 노드
            for (int i = 0; i < size; i++) {
                // 도착 노드
                for (int j = 0; j < size; j++) {
                    if (graph[i][j] != 0) {
                        continue;
                    }
                    if (graph[i][k] != 0 && graph[k][j] != 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }

        // 값 구하기
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Integer value1 = map.get(queries.get(i).get(0));
            Integer value2 = map.get(queries.get(i).get(1));
            if (value1 == null || value2 == null) {
                result[i] = -1;
                continue;
            }
            if (graph[value1][value2] == 0) {
                result[i] = -1;
                continue;
            }
            result[i] = graph[value1][value2];
        }

        return result;
    }

}
