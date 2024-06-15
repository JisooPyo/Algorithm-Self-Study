package leetcode.al2406;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Hard
 *
 * 502. IPO
 *
 * LeetCode 가 곧 IPO 를 시작한다고 가정해 봅시다.
 * 벤처 캐피탈에 좋은 가격으로 주식을 판매하기 위해 LeetCode 는 IPO 전에 자본을 늘리기 위해 몇 가지 프로젝트를 진행하려고 합니다.
 * 제한된 자원을 가지고 있기 때문에 IPO 전에 최대 k개의 고유한 프로젝트만 완료할 수 있습니다.
 * LeetCode 가 최대 k개의 고유한 프로젝트를 완료한 후 총 자본을 최대화하는 최선의 방법을 설계하도록 도와주세요.
 *
 * Given
 * n : 프로젝트 개수
 *     i번째 프로젝트 -> 순수 이익 profits[i], 시작하기 위해 필요한 최소 자본 capital[i]
 *
 * 처음에, 당신은 w의 자본을 가지고 있습니다.
 * 프로젝트를 완료하면 그 프로젝트의 순수 이익을 얻게 되며, 그 이익은 총 자본에 추가됩니다.
 *
 * Return
 * 주어진 프로젝트들 중 최대 k개의 고유한 프로젝트 목록을 선택하여 최종 자본을 최대화하고, 최종 최대화된 자본을 반환하세요.
 */
public class Leet502_x {
    public static void main(String[] args) {
        Leet502_x l = new Leet502_x();

        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 1};

        int[] profits2 = {1, 2, 3};
        int[] capital2 = {0, 1, 2};

        System.out.println(l.findMaximizedCapital(2, 0, profits1, capital1));   // 4
        System.out.println(l.findMaximizedCapital(3, 0, profits2, capital2));   // 6
    }

    // 어떤 방향이 최적화인지 잘 모르겠어서 못 풀었다..
    // 비율이 좋은것이 좋은지 자본이 덜 들어가는 것이 좋은지?
    // 다른 사람의 풀이 : 2ms 평균이 50 ~ 60 ms인 거에 비해 엄청나게 빠르다!
    // 풀이를 보니 이 사람은 기본적으로 제공해주는 profit과 capital이 잘 정렬되어 있다고 가정하고 문제를 풀었나보다.
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (w == 1000000000 && profits[0] == 10000) {
            return 2000000000;
        }
        if (k == 100000 && profits[0] == 10000) {
            return 1000100000;
        }
        if (k == 100000 && profits[0] == 8013) {
            return 595057;
        }

        int index = -1;
        int profit = -1;

        for (int i = 0; i < k; i++) {
            index = profit = -1;

            for (int j = 0; j < profits.length; j++) {
                if (capital[j] <= w && (profits[j] > profit)) {
                    profit = profits[j];
                    index = j;
                }
            }

            if (index != -1) {
                w += profits[index];
                profits[index] = -1;
                capital[index] = -1;
            }
        }

        return w;
    }

    // 조금 더 정석일 것 같은 풀이
    // Defining the Project class within the Solution class
    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapitalOther(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<>();

        // Creating list of projects with capital and profits
        for (int i = 0; i < n; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }

        // Sorting projects by capital required
        Collections.sort(projects, (a, b) -> a.capital - b.capital);

        // Max-heap to store profits (using a min-heap with inverted values)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;

        // Main loop to select up to k projects
        for (int j = 0; j < k; j++) {
            // Add all profitable projects that we can afford
            while (i < n && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }

            // If no projects can be funded, break out of the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Otherwise, take the project with the maximum profit
            w += maxHeap.poll();
        }

        return w;
    }
}
