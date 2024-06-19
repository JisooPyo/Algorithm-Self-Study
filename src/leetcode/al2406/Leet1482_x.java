package leetcode.al2406;

/**
 Medium
 1482. Minimum Number of Days to Make m Bouquets

 Given
 bloomDay : 정수 배열
 m, k : 정수

 m개의 부케를 만들려고 한다.
 부케를 만들기 위해 정원에서 k개의 인접한 꽃들이 필요하다.
 정원은 n개의 꽃들로 이루어져 있으며,
 i번째 꽃은 bloomDay[i]에 피어있고, 한 부케에서만 사용될 수 있다.

 Return
 정원에서 m개의 부케를 만들 수 있는 최소 기간(며칠)을 구하여라.
 만들 수 없다면 -1을 반환하라.
 */
public class Leet1482_x {
    public static void main(String[] args) {
        Leet1482_x l = new Leet1482_x();

        /**
         * Let us see what happened in the first three days.
         * x means flower bloomed and _ means flower did not bloom in the garden.
         * We need 3 bouquets each should contain 1 flower.
         * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
         * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
         * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
         */
        int[] bloomDay1 = {1, 10, 3, 10, 2};
        int m1 = 3, k1 = 1;
        System.out.println(l.minDays(bloomDay1, m1, k1));       // 3

        /**
         * We need 3 bouquets each has 2 flowers, that means we need 6 flowers.
         * We only have 5 flowers, so it is impossible to get the needed bouquets.
         * and we return -1.
         */
        int[] bloomDay2 = {1, 10, 3, 10, 2};
        int m2 = 3, k2 = 2;
        System.out.println(l.minDays(bloomDay2, m2, k2));       // -1

        /**
         * We need 2 bouquets each should have 3 flowers.
         * Here is the garden after the 7 and 12 days:
         * After day 7: [x, x, x, x, _, x, x]
         * We can make one bouquet of the first three flowers that bloomed.
         * We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
         * After day 12: [x, x, x, x, x, x, x]
         * It is obvious that we can make two bouquets in different ways.
         */
        int[] bloomDay3 = {7, 7, 7, 7, 12, 7, 7};
        int m3 = 2, k3 = 3;
        System.out.println(l.minDays(bloomDay3, m3, k3));       // 12
    }

    // 어떻게 풀어야 하는지 아예 감을 못 잡았다...

    // 생각보다 훨씬 단순(?)하게 이진 검색으로 그냥 풀었다..
    // 다른 사람 풀이 : 9ms
    int arr[];
    int m, k;

    public int minDays(int[] arr, int m, int k) {
        if (m * k > arr.length) {
            return -1;
        }
        this.m = m;
        this.k = k;
        this.arr = arr;

        // 최대 일 수 구하기
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            max = Math.max(max, arr[i]);

        int start = 1;
        int end = max;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (count(mid)) {
                end = mid - 1;
            } else
                start = mid + 1;
        }

        return start;
    }

    boolean count(int val) {
        int temp = 0, temp2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= val) {
                temp++;
                if (temp == k) {
                    temp = 0;
                    temp2++;
                    if (temp2 == m)
                        return true;
                }
            } else {
                if ((arr.length - i) / k < m - temp2)
                    return false;
                temp = 0;
            }

        }
        return false;

    }
}
