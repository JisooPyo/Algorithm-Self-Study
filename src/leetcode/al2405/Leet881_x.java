package leetcode.al2405;

public class Leet881_x {
    public static void main(String[] args) {
        Leet881_x l = new Leet881_x();

        int[] people1 = {1, 2};
        int[] people2 = {3, 2, 2, 1};
        int[] people3 = {3, 5, 3, 4};
        int[] people4 = {5, 1, 4, 2};

        System.out.println(l.numRescueBoats(people1, 3));
        System.out.println(l.numRescueBoats(people2, 3));
        System.out.println(l.numRescueBoats(people3, 5));
        System.out.println(l.numRescueBoats(people4, 6));
    }

    // Greedy
    // 다른 사람 풀이
    public int numRescueBoats(int[] people, int limit) {
        // 해당 몸무게를 가진 사람의 수 저장
        int[] buckets = new int[limit + 1];
        for (int weight : people) {
            buckets[weight]++;
        }

        // start, end 투 포인터를 사용하여 배열 순회
        int start = 0;      // 가장 가벼운 사람
        int end = buckets.length - 1;       // 가장 무거운 사람
        int boats = 0;
        // start와 end를 이동시키면서 두 포인터가 만날 때까지 while문 반복
        while (start <= end) {
            while (start <= end && buckets[start] <= 0)
                start++;
            while (start <= end && buckets[end] <= 0)
                end--;

            if (buckets[start] <= 0 && buckets[end] <= 0)
                break;

            boats++;
            if (start + end <= limit) {
                buckets[start]--;
            }
            buckets[end]--;
        }
        return boats;
    }
}
