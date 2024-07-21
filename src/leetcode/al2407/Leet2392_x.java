package leetcode.al2407;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Hard
 * 2392. Build a Matrix With Conditions
 *
 * 양의 정수 k가 주어집니다.
 * 또한, 다음이 주어집니다.
 *  - rowConditions[i] = [above_i, below_i]인 크기 n의 2D 정수 배열 rowConditions
 *  - colConditions[i] = [left_i, right_i]의 크기 m인 2D 정수 배열 colConditions
 *
 * 두 배열은 1에서부터 k 까지의 정수를 포함합니다.
 * 당신은 k X k 배열을 만들어야 합니다.
 * 이 배열은 1에서 k까지 정확히 딱 한 번 각각의 숫자들을 포함합니다.
 * 남은 공간은 0으로 채웁니다.
 *
 * 배열은 또한 다음 조건을 만족해야 합니다.
 *   - 숫자 above_i는 모든 i에 대해 0부터 n-1까지 숫자 below_i가 나타나는 행보다 위의 행에 나타나야 합니다.
 *   - 숫자 left_i는 모든 i에 대해 0부터 m-1까지 숫자 right_i가 나타나는 열의 왼쪽 열에 나타나야 합니다.
 *
 * 조건을 만족하는 어떤 배열이든 리턴하세요. 만약 답이 존재하지 않는다면 빈 배열을 리턴하세요.
 */
public class Leet2392_x {
    public static void main(String[] args) {
        Leet2392_x l = new Leet2392_x();

        int[][] rowConditions1 = {{1, 2}, {3, 2}};
        int[][] colConditions1 = {{2, 1}, {3, 2}};
        int[][] rowConditions2 = {{1, 2}, {2, 3}, {3, 1}, {2, 3}};
        int[][] colConditions2 = {{2, 1}};

        System.out.println(Arrays.deepToString(l.buildMatrix(3, rowConditions1, colConditions1)));
        System.out.println(Arrays.deepToString(l.buildMatrix(3, rowConditions2, colConditions2)));
    }

    // 다른 사람의 풀이
    // 쓰이는 알고리즘 : topological sort(위상 정렬)
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // 행 조건을 나타내는 그래프 생성
        List<Integer>[] rowGraph = new ArrayList[k + 1];
        for (int i = 1; i < rowGraph.length; i++) {
            rowGraph[i] = new ArrayList();
        }
        for (int[] rowCondition : rowConditions) {
            rowGraph[rowCondition[0]].add(rowCondition[1]);
        }

        // 열 조건을 나타내는 그래프 생성
        List<Integer>[] colGraph = new ArrayList[k + 1];
        for (int i = 1; i < colGraph.length; i++) {
            colGraph[i] = new ArrayList();
        }
        for (int[] colCondition : colConditions) {
            colGraph[colCondition[0]].add(colCondition[1]);
        }

        // 행 조건에 대한 위상 정렬
        int[] visited = new int[k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i < rowGraph.length; i++) {
            if (!topSort(rowGraph, i, visited, queue)) {
                return new int[0][0];   // 조건을 만족하지 못할 경우 빈 배열 반환
            }
        }

        // 위상 정렬 결과를 기반으로 행 인덱스 맵 생성
        int[] rowIndexMap = new int[k + 1];
        for (int i = 0; i < k; i++) {
            int node = queue.pollLast();
            rowIndexMap[node] = i;
        }

        // 열 조건에 대한 위상 정렬
        visited = new int[k + 1];
        queue = new LinkedList();
        for (int i = 1; i < colGraph.length; i++) {
            if (!topSort(colGraph, i, visited, queue)) {
                return new int[0][0];   // 조건을 만족하지 못할 경우 빈 배열 반환
            }
        }

        // 위상 정렬 결과를 기반으로 열 인덱스 맵 생성
        int[] colOrder = new int[k];
        int[] colIndexMap = new int[k + 1];
        for (int i = 0; i < k; i++) {
            int node = queue.pollLast();
            colOrder[i] = node;
            colIndexMap[node] = i;
        }

        // 결과 매트릭스 생성
        int[][] result = new int[k][k];

        for (int i = 1; i <= k; i++) {
            result[rowIndexMap[i]][colIndexMap[i]] = i;
        }

        return result;

    }

    public boolean topSort(List<Integer>[] graph, int node, int[] visited, Deque<Integer> queue) {
        if (visited[node] == 2) {
            return false;   // 사이클이 존재하여 위상 정렬이 불가능한 경우
        }
        if (visited[node] == 0) {
            visited[node] = 2;
            for (int child : graph[node]) {
                if (!topSort(graph, child, visited, queue)) {
                    return false;   // 사이클이 존재하여 위상 정렬이 불가능한 경우
                }
            }
            visited[node] = 1;  // 방문 완료
            queue.add(node);
        }
        return true;
    }
}
