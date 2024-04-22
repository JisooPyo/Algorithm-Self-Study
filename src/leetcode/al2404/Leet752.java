package leetcode.al2404;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 당신의 앞에는 4개의 휠로 이루어진 자물쇠가 있습니다.
 * 각 휠은 열 개의 슬롯을 가지고 있습니다. ('0' ~ '9')
 * ('0'에서 '9'로 '9'에서 '0'으로 넘어갈 수 있습니다.)
 *
 * 자물쇠는 초기에 '0000'으로 시작하며 문자열은 네 개의 휠의 상태를 의미한다.
 *
 * given
 * deadends -> 자물쇠가 이 코드에 도달하면 코드는 돌아가지 않는다.
 * target -> 자물쇠를 풀 수 있는 코드
 *
 * 문제
 * 자물쇠를 풀 수 있는 최소한의 횟수를 반환하라.
 * 풀 수 없다면 -1을 반환하라.
 */
public class Leet752 {
    public static void main(String[] args) {
        Leet752 l = new Leet752();

        String[] deadends1 = {"0201", "0101", "0102", "1212", "2002"};
        String target1 = "0202";
        String[] deadends2 = {"8888"};
        String target2 = "0009";
        String[] deadends3 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target3 = "8888";
        String[] deadends4 = {"0000"};
        String target4 = "8888";

        System.out.println(l.openLock(deadends1, target1));     // 6
        System.out.println(l.openLock(deadends2, target2));     // 1
        System.out.println(l.openLock(deadends3, target3));     // -1
        System.out.println(l.openLock(deadends4, target4));     // -1
    }

    // 내 풀이
    // 이전에 풀었던 문제인데 더 효율적으로 풀었다.
    // 이전 풀이는 현재 휠 상태를 int로 다루지 않고 String 그 자체로 다루어서 시간이 더 많이 걸렸다.
    public int openLock(String[] deadends, String target) {
        int targetInt = Integer.parseInt(target);

        boolean[] visited = new boolean[10000];
        for (String deadend : deadends) {
            int parse = Integer.parseInt(deadend);
            if (parse == 0) {
                return -1;
            }
            visited[parse] = true;
        }
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == targetInt) {
                    return count;
                }
                insertNearNumberIntoQueue(cur, visited, queue);
            }
            count++;
        }
        return -1;
    }

    private void insertNearNumberIntoQueue(int cur, boolean[] visited, Queue<Integer> queue) {
        insertPlus(cur, visited, queue);
        insertMinus(cur, visited, queue);
    }

    private void insertMinus(int cur, boolean[] visited, Queue<Integer> queue) {
        if (one(cur) == 0) {
            if (!visited[cur + 9]) {
                queue.add(cur + 9);
                visited[cur + 9] = true;
            }
        } else {
            if (!visited[cur - 1]) {
                queue.add(cur - 1);
                visited[cur - 1] = true;
            }
        }
        if (ten(cur) == 0) {
            if (!visited[cur + 90]) {
                queue.add(cur + 90);
                visited[cur + 90] = true;
            }
        } else {
            if (!visited[cur - 10]) {
                queue.add(cur - 10);
                visited[cur - 10] = true;
            }
        }
        if (hundred(cur) == 0) {
            if (!visited[cur + 900]) {
                queue.add(cur + 900);
                visited[cur + 900] = true;
            }
        } else {
            if (!visited[cur - 100]) {
                queue.add(cur - 100);
                visited[cur - 100] = true;
            }
        }
        if (thousand(cur) == 0) {
            if (!visited[cur + 9000]) {
                queue.add(cur + 9000);
                visited[cur + 9000] = true;
            }
        } else {
            if (!visited[cur - 1000]) {
                queue.add(cur - 1000);
                visited[cur - 1000] = true;
            }
        }
    }

    private void insertPlus(int cur, boolean[] visited, Queue<Integer> queue) {
        if (one(cur) == 9) {
            if (!visited[cur - 9]) {
                queue.add(cur - 9);
                visited[cur - 9] = true;
            }
        } else {
            if (!visited[cur + 1]) {
                queue.add(cur + 1);
                visited[cur + 1] = true;
            }
        }
        if (ten(cur) == 9) {
            if (!visited[cur - 90]) {
                queue.add(cur - 90);
                visited[cur - 90] = true;
            }
        } else {
            if (!visited[cur + 10]) {
                queue.add(cur + 10);
                visited[cur + 10] = true;
            }
        }
        if (hundred(cur) == 9) {
            if (!visited[cur - 900]) {
                queue.add(cur - 900);
                visited[cur - 900] = true;
            }
        } else {
            if (!visited[cur + 100]) {
                queue.add(cur + 100);
                visited[cur + 100] = true;
            }
        }
        if (thousand(cur) == 9) {
            if (!visited[cur - 9000]) {
                queue.add(cur - 9000);
                visited[cur - 9000] = true;
            }
        } else {
            if (!visited[cur + 1000]) {
                queue.add(cur + 1000);
                visited[cur + 1000] = true;
            }
        }
    }

    private int thousand(int i) {
        return i / 1000;
    }

    private int hundred(int i) {
        return (i / 100) % 10;
    }

    private int ten(int i) {
        return (i / 10) % 10;
    }

    private int one(int i) {
        return i % 10;
    }
}
