package leetcode.al2403;

import java.util.Arrays;

public class Leet621_x {
    public static void main(String[] args) {
        Leet621_x l = new Leet621_x();

        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        char[] tasks2 = {'A', 'C', 'A', 'B', 'D', 'B'};
        char[] tasks3 = {'A', 'A', 'A', 'B', 'B', 'B'};

        System.out.println(l.leastInterval(tasks1, 2));      // 8
        System.out.println(l.leastInterval(tasks2, 1));      // 6
        System.out.println(l.leastInterval(tasks3, 3));      // 10
    }

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task-'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleTime = (maxFreq-1) * n;

        for(int i = 24; i >= 0; i--) {
            idleTime-= Math.min(maxFreq-1, freq[i]);
        }

        return tasks.length + Math.max(idleTime, 0);
    }
}
