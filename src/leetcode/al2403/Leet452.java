package leetcode.al2403;

import java.util.Arrays;
import java.util.Comparator;

public class Leet452 {
    public static void main(String[] args) {
        Leet452 l = new Leet452();

        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] points4 = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int[][] points5 = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        int[][] points6 = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};

        System.out.println(l.findMinArrowShots(points1));   // 2
        System.out.println(l.findMinArrowShots(points2));   // 4
        System.out.println(l.findMinArrowShots(points3));   // 2
        System.out.println(l.findMinArrowShots(points4));   // 2
        System.out.println(l.findMinArrowShots(points5));   // 2
        System.out.println(l.findMinArrowShots(points6));   // 2
    }

    // 다시 보니 start는 필요 없는 변수..일지도
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }

        Arrays.sort(points,
            Comparator
                .comparingInt((int[] arr) -> arr[0])
                .thenComparingInt(arr -> arr[1]));

        int count = 1;
        int start = points[0][0];
        int end = points[0][1];
        int index = 1;
        while (index < points.length) {
            if (points[index][0] <= end) {
                if (start < points[index][0]) {
                    start = points[index][0];
                    if (points[index][1] < end) {
                        end = points[index][1];
                    }
                }
            } else {
                count++;
                start = points[index][0];
                end = points[index][1];
            }
            index++;
        }

        return count;
    }
}
