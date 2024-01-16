// Open the Lock
package leetcode.explore.queueStack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS2 {
    public static void main(String[] args) {
        BFS2 b = new BFS2();
        b.problem1();
        b.problem2();
        b.problem3();
    }

    private void problem3() {
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        System.out.println(openLock(deadends, target));
    }

    private void problem2() {
        String[] deadends = {"8888"};
        String target = "0009";
        System.out.println(openLock(deadends, target));
    }

    private void problem1() {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadendNums = new HashSet<>();
        for (String str : deadends) {
            deadendNums.add(str);
        }
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add("0000");
        loop1:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String peek = queue.peek();
                if (target.equals(peek)) {
                    break loop1;
                }
                if (deadendNums.contains(peek)) {
                    queue.poll();
                    continue;
                }
                addNextValueToQueue(visited, queue, peek);
                queue.poll();
            }
            level++;
        }
        return queue.isEmpty() ? -1 : level;
    }

    private void addNextValueToQueue(Set<String> visited, Queue<String> queue, String peek) {
        StringBuilder sb = new StringBuilder(peek);
        for (int i = 0; i < 4; i++) {
            char ch = sb.charAt(i);
            StringBuilder beforeString = new StringBuilder(sb);
            StringBuilder afterString = new StringBuilder(sb);

            if (ch == '0') {
                beforeString.setCharAt(i, '9');
                afterString.setCharAt(i, '1');
            } else if (ch == '9') {
                beforeString.setCharAt(i, '8');
                afterString.setCharAt(i, '0');
            } else {
                char before = (char) ((int) ch - 1);
                char after = (char) ((int) ch + 1);
                beforeString.setCharAt(i, before);
                afterString.setCharAt(i, after);
            }

            if (!visited.contains(beforeString.toString())) {
                queue.add(beforeString.toString());
                visited.add(beforeString.toString());
            }
            if (!visited.contains(afterString.toString())) {
                queue.add(afterString.toString());
                visited.add(afterString.toString());
            }
        }
    }
}
