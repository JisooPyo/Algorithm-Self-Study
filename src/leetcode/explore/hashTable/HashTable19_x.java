package leetcode.explore.hashTable;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HashTable19_x {
    public static void main(String[] args) {
        HashTable19_x h = new HashTable19_x();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1};

        System.out.println(Arrays.toString(h.topKFrequent(nums1, 2)));
        System.out.println(Arrays.toString(h.topKFrequent(nums2, 1)));
    }

    // Point
    // 1. PriorityQueue 사용
    // 2. PriorityQueue 생성자에 key를 저장하되, value 순서대로 저장하도록 Comparator 설정
    public int[] topKFrequent(int[] nums, int k) {
        // 숫자, 개수
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> map.get(x) - map.get(y));
        for (Integer i : map.keySet()) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] answer = new int[k];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}
