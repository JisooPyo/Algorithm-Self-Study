package leetcode.al2403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet57 {
    public static void main(String[] args) {
        Leet57 l = new Leet57();
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] intervals3 = {{1, 2}, {3, 5}, {6, 7}, {9, 10}, {12, 16}};
        int[] newInterval3 = {8, 11};
        int[][] intervals4 = {{1, 5}};
        int[] newInterval4 = {2, 7};
        // [[1,5],[6,9]]
        System.out.println(Arrays.deepToString(l.insert(intervals1, newInterval1)));
        // [[1,2],[3,10],[12,16]]
        System.out.println(Arrays.deepToString(l.insert(intervals2, newInterval2)));
        System.out.println(Arrays.deepToString(l.insert(intervals3, newInterval3)));
        System.out.println(Arrays.deepToString(l.insert(intervals4, newInterval4)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval[1] < intervals[0][0]) {
            return insertFront(intervals, newInterval);
        }
        if (intervals[intervals.length - 1][1] < newInterval[0]) {
            return insertBack(intervals, newInterval);
        }
        return insertIn(intervals, newInterval);
    }

    private int[][] insertIn(int[][] intervals, int[] newInterval) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1]) {
                start = i;
            } else if (intervals[i][1] < newInterval[0]) {
                start = i + 1;
            }
            if (intervals[i][0] <= newInterval[1] && newInterval[1] <= intervals[i][1]) {
                end = i;
                break;
            } else if (i != intervals.length - 1 && intervals[i][1] < newInterval[1] && newInterval[1] < intervals[i
                + 1][0]) {
                end = i;
                break;
            } else if (i == intervals.length - 1 && intervals[i][1] < newInterval[1]) {
                end = i;
            }
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < start; i++) {
            list.add(intervals[i]);
        }

        int left = 0;
        int right = 0;
        if (intervals[start][0] <= newInterval[0]) {
            left = intervals[start][0];
        } else {
            left = newInterval[0];
        }
        if (newInterval[1] <= intervals[end][1]) {
            right = intervals[end][1];
        } else {
            right = newInterval[1];
        }
        list.add(new int[]{left, right});

        for (int i = end + 1; i < intervals.length; i++) {
            list.add(intervals[i]);
        }

        // list to array
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private int[][] insertBack(int[][] intervals, int[] newInterval) {
        int[][] answer = new int[intervals.length + 1][2];
        answer[answer.length - 1] = newInterval;
        System.arraycopy(intervals, 0, answer, 0, answer.length - 1);
        return answer;
    }

    private int[][] insertFront(int[][] intervals, int[] newInterval) {
        int[][] answer = new int[intervals.length + 1][2];
        answer[0] = newInterval;
        System.arraycopy(intervals, 0, answer, 1, intervals.length);
        return answer;
    }
}
